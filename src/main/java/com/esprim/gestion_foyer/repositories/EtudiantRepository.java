package com.esprim.gestion_foyer.repositories;

import com.esprim.gestion_foyer.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
   List<Etudiant> findByDateNaissanceBetween(Date startDate, Date endDate);
   List<Etudiant> findByEcole(String ecole);

}
