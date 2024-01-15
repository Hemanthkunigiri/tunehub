package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Users;

public interface UserRespository  extends JpaRepository<Users, Integer>
{
 public Users findByEmail(String email);
}
