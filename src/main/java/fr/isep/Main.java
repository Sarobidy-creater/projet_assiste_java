package fr.isep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ===== Aéroports =====
        Aeroport paris = new Aeroport("CDG", "Paris", "Aéroport Charles de Gaulle");
        Aeroport tana  = new Aeroport("TNR", "Antananarivo", "Aéroport International Ivato");
        Aeroport.ajouter(paris);
        Aeroport.ajouter(tana);

        // ===== Avions =====
        Avion avion1 = new Avion("F-ABCD", "Boeing 737", 180);
        Avion.ajouter(avion1);
        avion1.verifierDisponibilite();

        // ===== Vols =====
        Vol vol1 = new Vol("AF001", paris, tana, "2026-04-10 08:00", "2026-04-10 20:00", "Planifié", avion1);
        Vol.ajouter(vol1);
        vol1.planifierVol();

        // ===== Pilote & Personnel Cabine =====
        Pilote pilote1 = new Pilote(1, "Jean Dupont", "12 rue Paris", "0600000001", "EMP001", "2015-03-01", "LIC-2023", 5000);
        PersonnelCabine cabine1 = new PersonnelCabine(2, "Marie Martin", "5 av Lyon", "0600000002", "EMP002", "2018-06-15", "Hôtesse de l'air");
        Pilote.ajouter(pilote1);
        PersonnelCabine.ajouter(cabine1);

        // Affecter équipage au vol
        vol1.affecterVol(pilote1, Arrays.asList(cabine1));

        // ===== Passagers =====
        Passager passager1 = new Passager(3, "Sara Rakoto", "Antananarivo", "0340000001", "PP-123456");
        Passager.ajouter(passager1);

        // ===== Réservation =====
        Reservation resa1 = new Reservation("RES-001", "2026-04-01", "En attente", passager1, vol1);
        Reservation.ajouter(resa1);
        resa1.confirmerReservation();
        passager1.reserverVol(resa1);

        // ===== Affichages =====
        System.out.println("\n--- Liste des vols ---");
        Vol.afficherTableauVols();
        System.out.println("\n--- Informations vol " + vol1.getNumeroVol() + " ---");
        System.out.println(vol1.obtenirInfosVol());
        vol1.listingPassager();
        passager1.obtenirReservations();
        System.out.println("\n" + pilote1.obtenirInfos());
        System.out.println("\n" + avion1.obtenirInfosAvion());
    }
}

