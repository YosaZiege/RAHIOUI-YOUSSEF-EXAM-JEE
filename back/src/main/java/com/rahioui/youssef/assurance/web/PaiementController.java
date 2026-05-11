package com.rahioui.youssef.assurance.web;

import com.rahioui.youssef.assurance.dtos.PaiementRequestDTO;
import com.rahioui.youssef.assurance.dtos.PaiementResponseDTO;
import com.rahioui.youssef.assurance.services.IPaiementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Tag(name = "Paiements", description = "Gestion des paiements de contrats")
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping
    @Operation(summary = "Lister tous les paiements")
    public ResponseEntity<List<PaiementResponseDTO>> getAllPaiements() {
        return ResponseEntity.ok(paiementService.getAllPaiements());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un paiement par ID")
    @ApiResponse(responseCode = "404", description = "Paiement non trouvé")
    public ResponseEntity<PaiementResponseDTO> getPaiementById(@PathVariable Long id) {
        return ResponseEntity.ok(paiementService.getPaiementById(id));
    }

    @GetMapping("/contrat/{contratId}")
    @Operation(summary = "Lister les paiements d'un contrat")
    public ResponseEntity<List<PaiementResponseDTO>> getPaiementsByContrat(@PathVariable Long contratId) {
        return ResponseEntity.ok(paiementService.getPaiementsByContrat(contratId));
    }

    @PostMapping
    @Operation(summary = "Enregistrer un nouveau paiement")
    @ApiResponse(responseCode = "201", description = "Paiement enregistré")
    public ResponseEntity<PaiementResponseDTO> createPaiement(@Valid @RequestBody PaiementRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paiementService.createPaiement(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un paiement")
    @ApiResponse(responseCode = "204", description = "Paiement supprimé")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
