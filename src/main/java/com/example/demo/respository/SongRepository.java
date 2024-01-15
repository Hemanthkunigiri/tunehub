package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Song;

public interface SongRepository extends JpaRepository<Song, Integer>
{

	public Song findByname(String name);

}
