package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
}
