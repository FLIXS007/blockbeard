package fr.iutlyon1.krakenbyte.blockbeard_backend.repository;

import fr.iutlyon1.krakenbyte.blockbeard_backend.model.PartieModeArcade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartieModeArcadeRepository extends JpaRepository<PartieModeArcade, Long> {

    List<PartieModeArcade> findByJoueursIdJoueurOrderByDatePartieDesc(Long idJoueur);
}
