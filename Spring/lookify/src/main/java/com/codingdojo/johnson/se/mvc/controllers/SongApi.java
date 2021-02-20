package com.codingdojo.johnson.se.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.johnson.se.mvc.models.Song;
import com.codingdojo.johnson.se.mvc.services.SongService;
@RestController
public class SongApi {
    private final SongService songService;
    public SongApi(SongService songService){
        this.songService = songService;
    }
    @RequestMapping("/api/songs")
    public List<Song> index() {
        return songService.allSongs();
    }
    
    @RequestMapping(value="/api/songs", method=RequestMethod.POST)
    public Song create(
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="artist") String artist, 
    		@RequestParam(value="rating") int rating) {
        Song song = new Song(name, artist, rating);
        return songService.createSong(song);
    }
    
    @RequestMapping("/api/songs/{id}")
    public Song show(@PathVariable("id") Long id) {
        Song song = songService.findSong(id);
        return song;
    }
}
