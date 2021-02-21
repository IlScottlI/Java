package com.codingdojo.johnson.se.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.johnson.se.mvc.models.Song;
import com.codingdojo.johnson.se.mvc.services.SongService;
@Controller
public class Index {
	
	 private final SongService songService;

	    public Index(SongService songService) {
	        this.songService = songService;
	    }

    @RequestMapping("/")
    public String index(Model model, HttpSession sessionStorage) {
    	int counter = 0;
		if (sessionStorage.getAttribute("counter") != null) {
			counter = (int) sessionStorage.getAttribute("counter");
			sessionStorage.setAttribute("counter", counter + 1);
		} else {
			sessionStorage.setAttribute("counter", counter);
		}
        model.addAttribute("message", "<small>You Viewed this site (" + counter + ")</small>" );
        return "home.jsp";
    }
    
    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
    	List<Song> songs = songService.allSongs();    	
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
    
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(
    		@RequestParam String term, 
    		Model model
    		)
    		{
    	if(term.isBlank()) {
    		return "redirect:/dashboard";
    	}
    	model.addAttribute("term", term);
    	 return "redirect:/search/" + term;
    }
    
    @RequestMapping("/search/{term}")
    public String searchSongsArtist(@PathVariable(value="term",required = false)String term,Model model) {
    	String page = "";
        Sort sortOrder = Sort.by("rating").descending();   	 
    	List<Song> songs = songService.findAll(sortOrder);
        if(term.equals("topTen")) {
            model.addAttribute("songs", songs);
            page = "top-songs.jsp";
        } else {
        	List<Song> songsSearch = songService.searchSongs(term);
        	model.addAttribute("songs", songsSearch);
        	model.addAttribute("term", term);
        	page = "search-result.jsp";	
        }
        return page;
    }
    
    @RequestMapping("/songs/{id}")
    public String viewSong(@PathVariable("id") Long id,Model model) {
    	Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "view-song.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "new-song.jsp";
    }
    
    @RequestMapping(value="/songs/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "new-song.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
        return "redirect:/dashboard";
    }
}
