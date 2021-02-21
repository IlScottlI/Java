package com.codingdojo.johnson.se.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.johnson.se.mvc.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
    List<Song> findAll(Sort sortOrder);
    List<Song> findByNameContaining(String search);
    List<Song> findByArtistContaining(String search);
    Long countByArtistContaining(String search);
    Long deleteByNameStartingWith(String search);
}
