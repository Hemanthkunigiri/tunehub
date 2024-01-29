package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.Playlist;
import com.example.demo.entites.Song;
import com.example.demo.service.PlayListService;
import com.example.demo.service.SongService;

@Controller
public class PlayListController 
{
	@Autowired
	  SongService songService;
	@Autowired
	PlayListService palylistService; 
	  @GetMapping("/createplaylist")
	  public String createPlaylist(Model model)
	  { 
		   List<Song>songList=songService.fetchAllSongs();
		   model.addAttribute("songs", songList);
		   return"CreatePlayList";
	  }
	  @PostMapping("/addplaylist")
	  public String addplaylist(@ModelAttribute Playlist playlist)
	  {
		  palylistService.addPlaylist(playlist);
		  //Updating song table
		  List<Song> songList=playlist.getSongs();
		  for(Song s:songList)
		  {
			  s.getPlayLists().add(playlist);
			  //Update song object in db
			  songService.updateSong(s);
		  }
		  return"adminHome";
	  }
	  @GetMapping("/viewPlaylists")
	  public String viewPlaylists(Model model)
	  {
		  List<Playlist> allPlaylists=palylistService.fetchAllPlaylists();
		  model.addAttribute("allPlaylists",allPlaylists);
		  return "displayplaylists";
	  }
	  
}
