package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Playlist;
import com.example.demo.respository.PlayListRespository;

@Service
public class PlayListServiceImplementation  implements PlayListService
{
	@Autowired
	PlayListRespository repo;

	@Override
	public void addPlaylist(Playlist playlist) 
	{
		repo.save(playlist);
	}

	@Override
	public List<Playlist> fetchAllPlaylists() 
	{
		return repo.findAll();
	}
  
}
