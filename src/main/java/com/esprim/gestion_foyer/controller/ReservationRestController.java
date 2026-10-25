package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.entities.Reservation;
import com.esprim.gestion_foyer.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {
    @Autowired
    private IReservationService reservationService;

    // http://localhost:8085/foyer/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }

    // http://localhost:8085/foyer/reservation/retrieve-reservation/2025-2026-B1-101
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    // http://localhost:8085/foyer/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }

    // http://localhost:8085/foyer/reservation/remove-reservation/2025-2026-B1-101
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String reservationId) {
        reservationService.removeReservation(reservationId);
    }

    // http://localhost:8085/foyer/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return reservationService.modifyReservation(reservation);
    }
}
