package com.rahioui.youssef.assurance;

import com.rahioui.youssef.assurance.entities.*;
import com.rahioui.youssef.assurance.enums.*;
import com.rahioui.youssef.assurance.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AssuranceApplication implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ContratAssuranceRepository contratRepository;
    private final PaiementRepository paiementRepository;
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(AssuranceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        seedRolesAndUsers();
        seedClients();
    }

    private void seedRolesAndUsers() {
        AppRole roleAdmin   = appRoleRepository.save(new AppRole(null, "ROLE_ADMIN", "Administrateur"));
        AppRole roleEmploye = appRoleRepository.save(new AppRole(null, "ROLE_EMPLOYE", "Employé"));
        AppRole roleClient  = appRoleRepository.save(new AppRole(null, "ROLE_CLIENT", "Client"));

        AppUser admin = new AppUser();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin1234"));
        admin.setEmail("admin@assurance.ma");
        admin.setRoles(List.of(roleAdmin, roleEmploye, roleClient));
        appUserRepository.save(admin);

        AppUser employe = new AppUser();
        employe.setUsername("employe");
        employe.setPassword(passwordEncoder.encode("employe1234"));
        employe.setEmail("employe@assurance.ma");
        employe.setRoles(List.of(roleEmploye, roleClient));
        appUserRepository.save(employe);

        AppUser client = new AppUser();
        client.setUsername("client1");
        client.setPassword(passwordEncoder.encode("client1234"));
        client.setEmail("client1@gmail.com");
        client.setRoles(List.of(roleClient));
        appUserRepository.save(client);
    }

    private void seedClients() {
        Client c1 = clientRepository.save(Client.builder().nom("Youssef Rahioui").email("youssef@gmail.com").build());
        Client c2 = clientRepository.save(Client.builder().nom("Fatima Zahra").email("fatima@gmail.com").build());
        Client c3 = clientRepository.save(Client.builder().nom("Mohamed Alami").email("alami@gmail.com").build());
        Client c4 = clientRepository.save(Client.builder().nom("Aicha Benali").email("aicha@gmail.com").build());
        Client c5 = clientRepository.save(Client.builder().nom("Karim Idrissi").email("karim@gmail.com").build());

        ContratAssuranceAutomobile ca1 = new ContratAssuranceAutomobile();
        setCommon(ca1, c1, LocalDate.of(2024, 1, 15), 250.0, 12, 80.0);
        ca1.setNumeroImmatriculation("A-12345-B");
        ca1.setMarqueVehicule("Toyota");
        ca1.setModeleVehicule("Corolla");
        contratRepository.save(ca1);

        ContratAssuranceAutomobile ca2 = new ContratAssuranceAutomobile();
        setCommon(ca2, c2, LocalDate.of(2024, 3, 10), 320.0, 24, 90.0);
        ca2.setNumeroImmatriculation("B-67890-C");
        ca2.setMarqueVehicule("Renault");
        ca2.setModeleVehicule("Clio");
        contratRepository.save(ca2);

        ContratAssuranceAutomobile ca3 = new ContratAssuranceAutomobile();
        setCommon(ca3, c3, LocalDate.of(2023, 6, 1), 180.0, 12, 70.0);
        ca3.setNumeroImmatriculation("C-11111-D");
        ca3.setMarqueVehicule("Dacia");
        ca3.setModeleVehicule("Logan");
        ca3.setStatut(StatutContrat.VALIDE);
        ca3.setDateValidation(LocalDate.of(2023, 6, 5));
        contratRepository.save(ca3);

        ContratAssuranceHabitation ch1 = new ContratAssuranceHabitation();
        setCommon(ch1, c1, LocalDate.of(2024, 2, 1), 150.0, 12, 85.0);
        ch1.setTypeLogement(TypeLogement.APPARTEMENT);
        ch1.setAdresse("12 Rue Hassan II, Casablanca");
        ch1.setSuperficie(85.0);
        contratRepository.save(ch1);

        ContratAssuranceHabitation ch2 = new ContratAssuranceHabitation();
        setCommon(ch2, c4, LocalDate.of(2023, 11, 20), 200.0, 24, 75.0);
        ch2.setTypeLogement(TypeLogement.MAISON);
        ch2.setAdresse("5 Avenue Mohammed V, Rabat");
        ch2.setSuperficie(150.0);
        ch2.setStatut(StatutContrat.VALIDE);
        ch2.setDateValidation(LocalDate.of(2023, 11, 25));
        contratRepository.save(ch2);

        ContratAssuranceHabitation ch3 = new ContratAssuranceHabitation();
        setCommon(ch3, c5, LocalDate.of(2022, 5, 10), 300.0, 36, 90.0);
        ch3.setTypeLogement(TypeLogement.LOCAL_COMMERCIAL);
        ch3.setAdresse("Rue Zerktouni, Marrakech");
        ch3.setSuperficie(200.0);
        ch3.setStatut(StatutContrat.RESILIE);
        contratRepository.save(ch3);

        ContratAssuranceSante cs1 = new ContratAssuranceSante();
        setCommon(cs1, c2, LocalDate.of(2024, 4, 1), 400.0, 12, 95.0);
        cs1.setNiveauCouverture(NiveauCouverture.PREMIUM);
        cs1.setNombrePersonnesCouvertes(4);
        contratRepository.save(cs1);

        ContratAssuranceSante cs2 = new ContratAssuranceSante();
        setCommon(cs2, c3, LocalDate.of(2024, 1, 1), 200.0, 12, 70.0);
        cs2.setNiveauCouverture(NiveauCouverture.BASIQUE);
        cs2.setNombrePersonnesCouvertes(1);
        cs2.setStatut(StatutContrat.VALIDE);
        cs2.setDateValidation(LocalDate.of(2024, 1, 3));
        contratRepository.save(cs2);

        ContratAssuranceSante cs3 = new ContratAssuranceSante();
        setCommon(cs3, c5, LocalDate.of(2023, 8, 15), 300.0, 24, 80.0);
        cs3.setNiveauCouverture(NiveauCouverture.INTERMEDIAIRE);
        cs3.setNombrePersonnesCouvertes(2);
        contratRepository.save(cs3);

        seedPaiements(ca1, ch1, cs1);
    }

    private void setCommon(ContratAssurance c, Client client, LocalDate date,
                            double montant, int duree, double taux) {
        c.setClient(client);
        c.setDateSouscription(date);
        c.setStatut(StatutContrat.EN_COURS);
        c.setMontantCotisation(montant);
        c.setDureeContrat(duree);
        c.setTauxCouverture(taux);
    }

    private void seedPaiements(ContratAssurance... contrats) {
        for (ContratAssurance contrat : contrats) {
            for (int i = 1; i <= 4; i++) {
                Paiement p = Paiement.builder()
                        .date(LocalDate.now().minusMonths(i))
                        .montant(contrat.getMontantCotisation())
                        .type(TypePaiement.MENSUALITE)
                        .contrat(contrat)
                        .build();
                paiementRepository.save(p);
            }
            Paiement extra = Paiement.builder()
                    .date(LocalDate.now().minusDays(5))
                    .montant(50.0)
                    .type(TypePaiement.PAIEMENT_EXCEPTIONNEL)
                    .contrat(contrat)
                    .build();
            paiementRepository.save(extra);
        }
    }
}
