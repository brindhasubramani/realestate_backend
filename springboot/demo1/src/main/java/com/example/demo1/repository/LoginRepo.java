package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.model.Login;

public interface LoginRepo extends JpaRepository<Login,Integer>{
    
}
