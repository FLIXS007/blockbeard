package fr.iutlyon1.krakenbyte.blockbeard_backend.dto;

public record InventaireItemResponse(
        Long idEquipement,
        String nomEquipement,
        String typeEquipement,
        String descriptionEquipement,
        Boolean estEquipe
) {
}
