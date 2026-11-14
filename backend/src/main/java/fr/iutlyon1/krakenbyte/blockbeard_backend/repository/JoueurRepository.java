package fr.iutlyon1.krakenbyte.blockbeard_backend.repository;

import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    
    Optional<Joueur> findByMailJoueur(String mailJoueur);
    Optional<Joueur> findByNomJoueur(String nomJoueur);
    boolean existsByMailJoueur(String mailJoueur);
    boolean existsByNomJoueur(String nomJoueur);

}
