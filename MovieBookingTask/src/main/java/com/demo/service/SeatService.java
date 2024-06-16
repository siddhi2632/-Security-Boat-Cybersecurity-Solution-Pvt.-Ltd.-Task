package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.Movie;
import com.demo.entity.Seat;
import com.demo.repository.SeatRepo;

@Service
public class SeatService {

    private final SeatRepo seatRepository;

    public SeatService(SeatRepo seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeatsByMovie(Movie movie) {
        return seatRepository.findByMovie(movie);
    }

    public Seat bookSeat(Seat seat) {
        seat.setBooked(true);
        return seatRepository.save(seat);
    }

    public Seat getSeatById(Long id) {
        return seatRepository.findById(id).orElseThrow(() -> new RuntimeException("Seat not found"));
    }
}
