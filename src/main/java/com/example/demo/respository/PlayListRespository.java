package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Playlist;

public interface PlayListRespository extends JpaRepository<Playlist, Integer>
{
  
}
