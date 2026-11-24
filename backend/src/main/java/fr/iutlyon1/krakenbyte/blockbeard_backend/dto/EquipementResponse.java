package fr.iutlyon1.krakenbyte.blockbeard_backend.dto;

public record EquipementResponse(
        Long idEquipement,
        String typeEquipement,
        Long prixEquipementPiece,
        Long prixEquipementGemmes,
        String nomEquipement,
        String descriptionEquipement
) {
}
