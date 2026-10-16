package com.esprim.gestion_foyer.repositories;

import com.esprim.gestion_foyer.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
