package com.esprim.gestion_foyer.repositories;

import com.esprim.gestion_foyer.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByNumeroChambreIn(List<Long> numChambres);

    List<Chambre> findAllByNumeroChambre(Long numeroChambre);

    List<Chambre> findAllByNumeroChambreIn(Collection<Long> numeroChambres);
}

