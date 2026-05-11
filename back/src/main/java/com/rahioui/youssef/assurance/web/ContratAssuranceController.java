package com.rahioui.youssef.assurance.web;

import com.rahioui.youssef.assurance.dtos.*;
import com.rahioui.youssef.assurance.enums.StatutContrat;
import com.rahioui.youssef.assurance.services.IContratAssuranceService;
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
@RequestMapping("/api/contrats")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Tag(name = "Contrats d'assurance", description = "Gestion des contrats (automobile, habitation, santé)")
public class ContratAssuranceController {

    private final IContratAssuranceService contratService;

    @GetMapping
    @Operation(summary = "Lister tous les contrats")
    public ResponseEntity<List<ContratAssuranceResponseDTO>> getAllContrats() {
        return ResponseEntity.ok(contratService.getAllContrats());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un contrat par ID")
    @ApiResponse(responseCode = "404", description = "Contrat non trouvé")
    public ResponseEntity<ContratAssuranceResponseDTO> getContratById(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getContratById(id));
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Lister les contrats d'un client")
    public ResponseEntity<List<ContratAssuranceResponseDTO>> getContratsByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(contratService.getContratsByClient(clientId));
    }

    @GetMapping("/statut/{statut}")
    @Operation(summary = "Filtrer les contrats par statut")
    public ResponseEntity<List<ContratAssuranceResponseDTO>> getContratsByStatut(@PathVariable StatutContrat statut) {
        return ResponseEntity.ok(contratService.getContratsByStatut(statut));
    }

    @PostMapping("/automobile")
    @Operation(summary = "Créer un contrat d'assurance automobile")
    @ApiResponse(responseCode = "201", description = "Contrat automobile créé")
    public ResponseEntity<ContratAutomobileResponseDTO> createAutomobile(
            @Valid @RequestBody ContratAutomobileRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.createContratAutomobile(dto));
    }

    @PostMapping("/habitation")
    @Operation(summary = "Créer un contrat d'assurance habitation")
    @ApiResponse(responseCode = "201", description = "Contrat habitation créé")
    public ResponseEntity<ContratHabitationResponseDTO> createHabitation(
            @Valid @RequestBody ContratHabitationRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.createContratHabitation(dto));
    }

    @PostMapping("/sante")
    @Operation(summary = "Créer un contrat d'assurance santé")
    @ApiResponse(responseCode = "201", description = "Contrat santé créé")
    public ResponseEntity<ContratSanteResponseDTO> createSante(
            @Valid @RequestBody ContratSanteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.createContratSante(dto));
    }

    @PatchMapping("/{id}/valider")
    @Operation(summary = "Valider un contrat (statut → VALIDE)")
    public ResponseEntity<ContratAssuranceResponseDTO> valider(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.validerContrat(id));
    }

    @PatchMapping("/{id}/resilier")
    @Operation(summary = "Résilier un contrat (statut → RESILIE)")
    public ResponseEntity<ContratAssuranceResponseDTO> resilier(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.resilierContrat(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un contrat")
    @ApiResponse(responseCode = "204", description = "Contrat supprimé")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}
