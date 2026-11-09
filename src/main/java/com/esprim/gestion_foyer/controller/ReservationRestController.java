package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.entities.Reservation;
import com.esprim.gestion_foyer.service.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion Reservation")
@RestController
@RequestMapping("/reservation")
public class ReservationRestController {
    @Autowired
    private IReservationService reservationService;

    @Operation(description = "récupérer toutes les réservations de la base de données")
    // http://localhost:8085/foyer/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }

    @Operation(description = "récupérer une réservation par son id")
    // http://localhost:8085/foyer/reservation/retrieve-reservation/2025-2026-B1-101
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    @Operation(description = "ajouter une réservation")
    // http://localhost:8085/foyer/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }

    @Operation(description = "supprimer une réservation par son id")
    // http://localhost:8085/foyer/reservation/remove-reservation/2025-2026-B1-101
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @Operation(description = "modifier une réservation")
    // http://localhost:8085/foyer/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return reservationService.modifyReservation(reservation);
    }
}
