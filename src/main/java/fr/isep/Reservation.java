package fr.isep;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private String numeroReservation;
    private String dateReservation;
    private String statut;
    private Passager passager;
    private Vol vol;

    private static List<Reservation> listeReservations = new ArrayList<>();

    public Reservation(String numeroReservation, String dateReservation, String statut, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.passager = passager;
        this.vol = vol;
    }

    // Getters & Setters
    public String getNumeroReservation() { return numeroReservation; }
    public String getDateReservation() { return dateReservation; }
    public String getStatut() { return statut; }
    public Passager getPassager() { return passager; }
    public Vol getVol() { return vol; }
    public void setStatut(String statut) { this.statut = statut; }
    public void setDateReservation(String dateReservation) { this.dateReservation = dateReservation; }

    // Méthodes du diagramme
    public void confirmerReservation() {
        this.statut = "Confirmé";
        vol.ajouterPassager(passager);
        System.out.println("Réservation " + numeroReservation + " confirmée pour " + passager.getNom());
    }

    public void annulerReservation() {
        this.statut = "Annulé";
        System.out.println("Réservation " + numeroReservation + " annulée pour " + passager.getNom());
    }

    public void modifierReservation(String nouvelleDateReservation) {
        this.dateReservation = nouvelleDateReservation;
        System.out.println("Réservation " + numeroReservation + " modifiée.");
    }

    public String obtenirInfosReservation() {
        return "=== Informations Réservation ===" +
               "\nNuméro          : " + numeroReservation +
               "\nDate            : " + dateReservation +
               "\nStatut          : " + statut +
               "\nPassager        : " + passager.getNom() +
               "\nVol             : " + vol.getNumeroVol() +
               "\nDe              : " + vol.getOrigine().getNom() +
               "\nVers            : " + vol.getDestination().getNom();
    }

    // CRUD
    public static void ajouter(Reservation r) {
        listeReservations.add(r);
        System.out.println("Réservation ajoutée : " + r.getNumeroReservation());
    }

    public static Reservation chercher(String numeroReservation) {
        for (Reservation r : listeReservations) {
            if (r.getNumeroReservation().equals(numeroReservation)) return r;
        }
        System.out.println("Réservation introuvable : " + numeroReservation);
        return null;
    }

    public static boolean modifier(String numeroReservation, String nouvelleDateReservation) {
        Reservation r = chercher(numeroReservation);
        if (r != null) {
            r.modifierReservation(nouvelleDateReservation);
            return true;
        }
        return false;
    }

    public static boolean supprimer(String numeroReservation) {
        Reservation r = chercher(numeroReservation);
        if (r != null) {
            listeReservations.remove(r);
            System.out.println("Réservation supprimée : " + numeroReservation);
            return true;
        }
        return false;
    }

    public static List<Reservation> getListeReservations() { return listeReservations; }
}
