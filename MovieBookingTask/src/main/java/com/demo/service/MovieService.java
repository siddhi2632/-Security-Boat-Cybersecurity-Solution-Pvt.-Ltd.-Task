package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.Movie;
import com.demo.repository.MovieRepo;

@Service
public class MovieService {

    private final MovieRepo movieRepository;

    public MovieService(MovieRepo movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }
}
