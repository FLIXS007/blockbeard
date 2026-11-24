package fr.iutlyon1.krakenbyte.blockbeard_backend.repository;

import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {

    List<Equipement> findByTypeEquipement(String typeEquipement);
}
