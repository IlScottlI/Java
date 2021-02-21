package com.codingdojo.johnson.se.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.codingdojo.johnson.se.mvc.models.Song;
import com.codingdojo.johnson.se.mvc.repositories.SongRepository;


@Service
public class SongService {
    private final SongRepository songRepository;
    
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
        	 return optionalSong.get();
        } else {
        	return null;
        }
       
    }
    
    public List<Song> searchSongs(String term) {
       return songRepository.findByArtistContaining(term);    
    }

	public void deleteSong(Long id) {
		songRepository.deleteById(id);		
	}

	public List<Song> findAll(Sort sortOrder) {
		return songRepository.findAll(sortOrder);
	}
}
