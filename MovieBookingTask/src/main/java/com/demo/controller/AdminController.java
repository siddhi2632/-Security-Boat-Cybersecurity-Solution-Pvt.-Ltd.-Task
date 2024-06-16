package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.MovieService;
import com.demo.service.SeatService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MovieService movieService;
    private final SeatService seatService;

    public AdminController(MovieService movieService, SeatService seatService) {
        this.movieService = movieService;
        this.seatService = seatService;
    }

    @GetMapping("/movies")
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "admin/movies";
    }

    @GetMapping("/seats/{movieId}")
    public String listSeats(@PathVariable Long movieId, Model model) {
        model.addAttribute("seats", seatService.getSeatsByMovie(movieService.getMovieById(movieId)));
        return "admin/seats";
    }
}
