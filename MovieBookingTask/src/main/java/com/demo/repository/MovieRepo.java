package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>{

}
