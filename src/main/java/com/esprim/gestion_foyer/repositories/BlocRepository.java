package com.esprim.gestion_foyer.repositories;

import com.esprim.gestion_foyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface BlocRepository extends JpaRepository<Bloc, Long> {
}
