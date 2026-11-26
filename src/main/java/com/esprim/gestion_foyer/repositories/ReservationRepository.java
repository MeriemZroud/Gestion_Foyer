package com.esprim.gestion_foyer.repositories;

import com.esprim.gestion_foyer.entities.Chambre;
import com.esprim.gestion_foyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
