package fr.iutlyon1.krakenbyte.blockbeard_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PossedeId implements Serializable {

    @Column(name = "\"idPossesseur\"")
    private Long idPossesseur;

    @Column(name = "\"idEquipement\"")
    private Long idEquipement;

    public PossedeId() {
    }

    public PossedeId(Long idPossesseur, Long idEquipement) {
        this.idPossesseur = idPossesseur;
        this.idEquipement = idEquipement;
    }

    public Long getIdPossesseur() {
        return idPossesseur;
    }

    public void setIdPossesseur(Long idPossesseur) {
        this.idPossesseur = idPossesseur;
    }

    public Long getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(Long idEquipement) {
        this.idEquipement = idEquipement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PossedeId possedeId = (PossedeId) o;
        return Objects.equals(idPossesseur, possedeId.idPossesseur)
                && Objects.equals(idEquipement, possedeId.idEquipement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPossesseur, idEquipement);
    }
}
