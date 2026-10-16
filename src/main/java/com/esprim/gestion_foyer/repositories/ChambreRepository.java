package com.esprim.gestion_foyer.repositories;

import com.esprim.gestion_foyer.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
