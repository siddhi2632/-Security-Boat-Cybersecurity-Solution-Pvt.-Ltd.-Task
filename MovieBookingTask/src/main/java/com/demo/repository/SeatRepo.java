package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Movie;
import com.demo.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Long>
{
	 List<Seat> findByMovie(Movie movie);
}
