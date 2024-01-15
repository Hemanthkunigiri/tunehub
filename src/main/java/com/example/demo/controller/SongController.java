package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.Song;
import com.example.demo.service.SongService;

@Controller
public class SongController 
{
  @Autowired
  SongService service;
  @PostMapping("/addSong")
  public String addSong(@ModelAttribute Song song)
  {
	  boolean songStatus=service.songExists(song.getName());
	  if(songStatus==false)
	  {
		  service.addSong(song);
		  System.out.println("Song added successfully");
	  }
	  else
	  {
		  System.out.println("Song already exists");
	  }
       return "Adminhome";
  }
  @GetMapping("/viewSongs")
  public String viewSongs(Model model)
  {
	  List<Song> songList=service.fetchAllSongs();
	  model.addAttribute("Songs",songList);
	  return"displaySong";
  }
  
  @GetMapping("/playSongs")
  public String playSongs(Model model)
  {
	  boolean premiumUser =false;
	  if(premiumUser==true)
	  {  
	  List<Song>songsList=service.fetchAllSongs();
	  System.out.println(songsList);
	  model.addAttribute("Songs",songsList);
	  return "displaySong";
	  }
	  else
	  {
		  return "makePayment";
	  }
  }
}
