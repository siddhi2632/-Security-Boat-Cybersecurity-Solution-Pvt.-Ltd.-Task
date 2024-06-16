package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.Seat;
import com.demo.service.MovieService;
import com.demo.service.SeatService;

@Controller
public class SeatController {

    private final SeatService seatService;
    private final MovieService movieService;

    public SeatController(SeatService seatService, MovieService movieService) {
        this.seatService = seatService;
        this.movieService = movieService;
    }

    @GetMapping("/seats/{movieId}")
    public String showSeats(@PathVariable Long movieId, Model model) {
        model.addAttribute("seats", seatService.getSeatsByMovie(movieService.getMovieById(movieId)));
        return "seats";
    }

    @PostMapping("/book-seat")
    public String bookSeat(@RequestParam Long seatId) {
        Seat seat = seatService.getSeatById(seatId);
        seatService.bookSeat(seat);
        return "redirect:/confirmation";
    }
}
