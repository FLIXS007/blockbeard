package fr.iutlyon1.krakenbyte.blockbeard_backend.dto;

import java.time.OffsetDateTime;

public record PartieArcadeResponse(Long idPartieModeArcade, Long score, OffsetDateTime datePartie) {
}
