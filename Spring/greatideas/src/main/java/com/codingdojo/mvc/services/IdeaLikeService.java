package com.codingdojo.mvc.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Idea;
import com.codingdojo.mvc.models.IdeaLikes;
import com.codingdojo.mvc.models.Like;
import com.codingdojo.mvc.repositories.IdeaLikeRepository;
import com.codingdojo.mvc.repositories.IdeaRepository;
import com.codingdojo.mvc.repositories.LikeRepository;

@Service
public class IdeaLikeService {
	private final IdeaRepository ideaRepository;
	private final IdeaLikeRepository ideaLikeRepository;
	private final LikeRepository likeRepository;
    public IdeaLikeService(IdeaLikeRepository ideaLikeRepository, IdeaRepository ideaRepository, LikeRepository likeRepository) {
        this.ideaLikeRepository = ideaLikeRepository;
        this.ideaRepository = ideaRepository;
        this.likeRepository = likeRepository;
    }

    public List<IdeaLikes> allItems() {
        return ideaLikeRepository.findAll();
    }
    
    public IdeaLikes createItem(IdeaLikes item) {
        return ideaLikeRepository.save(item);
    }

    public IdeaLikes findItem(Long id) {
    	Optional<IdeaLikes> optionalItem = ideaLikeRepository.findById(id);
        if(optionalItem.isPresent()) {
        	 return optionalItem.get();
        } else {
        	return null;
        }
    }   

	public void deleteItem(Long id) {
		ideaLikeRepository.deleteById(id);		
	}
	
	public void deleteLikesByIdea(Idea idea) {
		Long id = idea.getId();
		List<Like> likes = likeRepository.findByIdea(idea);
		likeRepository.deleteAll(likes);
		try {
			List<IdeaLikes> ideaLikes = ideaLikeRepository.findAllByIdeaId(id);
			for (Iterator<IdeaLikes> iterator = ideaLikes.iterator(); iterator.hasNext();) {
				IdeaLikes ideaLike = (IdeaLikes) iterator.next();
				ideaLikeRepository.delete(ideaLike);
			}
		} finally {
			ideaRepository.deleteById(id);
		}
	}
	
	public List<IdeaLikes> findAll(Sort sortOrder) {
		return ideaLikeRepository.findAll(sortOrder);
	}
}
