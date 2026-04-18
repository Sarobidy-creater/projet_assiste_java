package fr.isep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {

    public static void exporterVols(List<Vol> vols, String chemin) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(chemin));
            bw.write("NumeroVol,Origine,Destination,DateDepart,Etat");
            bw.newLine();
            for (Vol v : vols) {
                bw.write(v.getNumeroVol() + ","
                        + v.getOrigine().getNom() + ","
                        + v.getDestination().getNom() + ","
                        + v.getDateHeureDepart() + ","
                        + v.getEtat());
                bw.newLine();
            }
            bw.close();
            System.out.println("Vols exportes dans : " + chemin);
        } catch (IOException e) {
            System.out.println("Erreur ecriture vols : " + e.getMessage());
        }
    }

    public static void exporterPassagers(List<Passager> passagers, String chemin) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(chemin));
            bw.write("ID,Nom,Adresse,Contact,Passeport");
            bw.newLine();
            for (Passager p : passagers) {
                bw.write(p.getIdentifiant() + ","
                        + p.getNom() + ","
                        + p.getAdresse() + ","
                        + p.getContact() + ","
                        + p.getPasseport());
                bw.newLine();
            }
            bw.close();
            System.out.println("Passagers exportes dans : " + chemin);
        } catch (IOException e) {
            System.out.println("Erreur ecriture passagers : " + e.getMessage());
        }
    }

    public static void exporterReservations(List<Reservation> reservations, String chemin) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(chemin));
            bw.write("NumeroReservation,DateReservation,Statut,Passager,Vol");
            bw.newLine();
            for (Reservation r : reservations) {
                bw.write(r.getNumeroReservation() + ","
                        + r.getDateReservation() + ","
                        + r.getStatut() + ","
                        + r.getPassager().getNom() + ","
                        + r.getVol().getNumeroVol());
                bw.newLine();
            }
            bw.close();
            System.out.println("Reservations exportees dans : " + chemin);
        } catch (IOException e) {
            System.out.println("Erreur ecriture reservations : " + e.getMessage());
        }
    }
}

