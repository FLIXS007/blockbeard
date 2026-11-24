package fr.iutlyon1.krakenbyte.blockbeard_backend.repository;

import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Possede;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.PossedeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PossedeRepository extends JpaRepository<Possede, PossedeId> {

    List<Possede> findByIdIdPossesseur(Long idPossesseur);
}
