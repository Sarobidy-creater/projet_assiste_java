package fr.isep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ===== Aéroports =====
        Aeroport paris  = new Aeroport("CDG", "Paris", "Aeroport Charles de Gaulle");
        Aeroport tana   = new Aeroport("TNR", "Antananarivo", "Aeroport Ivato");
        Aeroport newYork= new Aeroport("JFK", "New York", "John F. Kennedy");
        Aeroport london = new Aeroport("LHR", "Londres", "Heathrow");
        Aeroport dubai  = new Aeroport("DXB", "Dubai", "Dubai International");
        Aeroport.ajouter(paris); Aeroport.ajouter(tana);
        Aeroport.ajouter(newYork); Aeroport.ajouter(london); Aeroport.ajouter(dubai);

        // ===== Avions =====
        Avion avion1 = new Avion("F-ABCD", "Boeing 737", 180);
        Avion avion2 = new Avion("F-EFGH", "Airbus A320", 150);
        Avion avion3 = new Avion("F-IJKL", "Boeing 777", 300);
        Avion avion4 = new Avion("F-MNOP", "Airbus A380", 500);
        Avion.ajouter(avion1); Avion.ajouter(avion2);
        Avion.ajouter(avion3); Avion.ajouter(avion4);
        avion1.verifierDisponibilite();

        // ===== Vols =====
        Vol vol1 = new Vol("AF001", paris,   tana,    "2026-04-10 08:00", "2026-04-10 20:00", "Planifie",  avion1);
        Vol vol2 = new Vol("AF002", tana,    paris,   "2026-04-15 10:00", "2026-04-15 22:00", "Planifie",  avion2);
        Vol vol3 = new Vol("AF003", paris,   newYork, "2026-04-20 14:00", "2026-04-20 23:00", "Planifie",  avion3);
        Vol vol4 = new Vol("AF004", newYork, paris,   "2026-04-25 22:00", "2026-04-26 11:00", "Planifie",  avion4);
        Vol vol5 = new Vol("AF005", paris,   london,  "2026-05-01 07:30", "2026-05-01 08:30", "Planifie",  avion1);
        Vol vol6 = new Vol("AF006", london,  dubai,   "2026-05-03 12:00", "2026-05-03 20:00", "Planifie",  avion2);
        Vol vol7 = new Vol("AF007", dubai,   tana,    "2026-05-05 09:00", "2026-05-05 19:00", "Annule",    avion3);
        Vol vol8 = new Vol("AF008", paris,   dubai,   "2026-05-10 06:00", "2026-05-10 14:00", "Planifie",  avion4);
        Vol vol9 = new Vol("AF009", tana,    london,  "2026-05-12 11:00", "2026-05-13 05:00", "Planifie",  avion1);
        Vol vol10= new Vol("AF010", newYork, dubai,   "2026-05-15 18:00", "2026-05-16 14:00", "Planifie",  avion2);
        Vol.ajouter(vol1); Vol.ajouter(vol2); Vol.ajouter(vol3); Vol.ajouter(vol4); Vol.ajouter(vol5);
        Vol.ajouter(vol6); Vol.ajouter(vol7); Vol.ajouter(vol8); Vol.ajouter(vol9); Vol.ajouter(vol10);
        vol1.planifierVol();

        // ===== Pilote & Personnel Cabine =====
        Pilote pilote1 = new Pilote(1, "Jean Dupont", "12 rue Paris", "0600000001", "EMP001", "2015-03-01", "LIC-2023", 5000);
        PersonnelCabine cabine1 = new PersonnelCabine(2, "Marie Martin", "5 av Lyon", "0600000002", "EMP002", "2018-06-15", "Hotesse de l'air");
        Pilote.ajouter(pilote1);
        PersonnelCabine.ajouter(cabine1);
        vol1.affecterVol(pilote1, Arrays.asList(cabine1));

        // ===== Passagers =====
        Passager passager1  = new Passager(3,  "Sara Rakoto",   "Antananarivo", "0340000001", "PP-123456");
        Passager passager2  = new Passager(4,  "Paul Rabe",     "Fianarantsoa", "0340000002", "PP-789012");
        Passager passager3  = new Passager(5,  "Hery Andria",   "Toamasina",   "0340000003", "PP-345678");
        Passager passager4  = new Passager(6,  "Lova Rasoa",    "Mahajanga",   "0340000004", "PP-111222");
        Passager passager5  = new Passager(7,  "Noro Raivo",    "Paris",       "0600000010", "PP-567890");
        Passager passager6  = new Passager(8,  "Aina Solo",     "Lyon",        "0600000011", "PP-998877");
        Passager passager7  = new Passager(9,  "Clara Morin",   "Marseille",   "0600000012", "PP-112233");
        Passager passager8  = new Passager(10, "Thomas Leroy",  "Bordeaux",    "0600000013", "PP-445566");
        Passager passager9  = new Passager(11, "Emma Blanc",    "Nice",        "0600000014", "PP-778899");
        Passager passager10 = new Passager(12, "Lucas Petit",   "Toulouse",    "0600000015", "PP-001122");
        Passager.ajouter(passager1); Passager.ajouter(passager2); Passager.ajouter(passager3);
        Passager.ajouter(passager4); Passager.ajouter(passager5); Passager.ajouter(passager6);
        Passager.ajouter(passager7); Passager.ajouter(passager8); Passager.ajouter(passager9);
        Passager.ajouter(passager10);

        // ===== Réservations =====
        Reservation resa1  = new Reservation("RES-001", "2026-04-01", "En attente", passager1,  vol1);
        Reservation resa2  = new Reservation("RES-002", "2026-04-02", "En attente", passager2,  vol2);
        Reservation resa3  = new Reservation("RES-003", "2026-04-03", "En attente", passager3,  vol3);
        Reservation resa4  = new Reservation("RES-004", "2026-04-04", "En attente", passager4,  vol4);
        Reservation resa5  = new Reservation("RES-005", "2026-04-05", "En attente", passager5,  vol1);
        Reservation resa6  = new Reservation("RES-006", "2026-04-06", "En attente", passager6,  vol5);
        Reservation resa7  = new Reservation("RES-007", "2026-04-07", "En attente", passager7,  vol6);
        Reservation resa8  = new Reservation("RES-008", "2026-04-08", "En attente", passager8,  vol8);
        Reservation resa9  = new Reservation("RES-009", "2026-04-09", "En attente", passager9,  vol9);
        Reservation resa10 = new Reservation("RES-010", "2026-04-10", "En attente", passager10, vol10);
        Reservation.ajouter(resa1); Reservation.ajouter(resa2); Reservation.ajouter(resa3);
        Reservation.ajouter(resa4); Reservation.ajouter(resa5); Reservation.ajouter(resa6);
        Reservation.ajouter(resa7); Reservation.ajouter(resa8); Reservation.ajouter(resa9);
        Reservation.ajouter(resa10);
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

        // ===== Base de données =====
        System.out.println("\n--- Connexion base de données ---");
        VolDao.initialiserTables();
        VolDao.sauvegarderVol(vol1);
        VolDao.sauvegarderPassager(passager1);
        VolDao.sauvegarderReservation(resa1);
        DatabaseConnection.fermer();

        // ===== Export CSV =====
        System.out.println("\n--- Export CSV ---");
        CsvExporter.exporterVols(Vol.getListeVols(), "vols_export.csv");
        CsvExporter.exporterPassagers(Passager.getListePassagers(), "passagers_export.csv");
        CsvExporter.exporterReservations(Reservation.getListeReservations(), "reservations_export.csv");

        // ===== Import CSV (lecture) =====
        System.out.println("\n--- Import CSV ---");
        CsvImporter.importerVols("src/main/resources/vols.csv");
        CsvImporter.importerPassagers("src/main/resources/passagers.csv");
        CsvImporter.importerReservations("src/main/resources/reservations.csv");
    }
}



