package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(String reservationId);
    public Reservation addReservation(Reservation r);
    public void removeReservation(String reservationId);
    public Reservation modifyReservation(Reservation reservation);
}
