package com.esprim.gestion_foyer.repositories;

import com.esprim.gestion_foyer.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {

    Optional<Universite> findByNomUniversite(String nomUniversite);
}
