package fr.isep;

import fr.isep.Aeroport;

import java.util.ArrayList;
import java.util.List;

public class Vol {
    private String numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;
    private Avion avion;
    private List<Passager> passagers = new ArrayList<>();
    private Pilote pilote;
    private List<PersonnelCabine> equipeCabine = new ArrayList<>();

    private static List<Vol> listeVols = new ArrayList<>();

    public Vol(String numeroVol, Aeroport origine, Aeroport destination, String dateHeureDepart, String dateHeureArrivee, String etat, Avion avion) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = etat;
        this.avion = avion;
    }

    // Getters & Setters
    public String getNumeroVol() { return numeroVol; }
    public Aeroport getOrigine() { return origine; }
    public Aeroport getDestination() { return destination; }
    public String getDateHeureDepart() { return dateHeureDepart; }
    public String getDateHeureArrivee() { return dateHeureArrivee; }
    public String getEtat() { return etat; }
    public Avion getAvion() { return avion; }
    public Pilote getPilote() { return pilote; }
    public List<PersonnelCabine> getEquipeCabine() { return equipeCabine; }
    public List<Passager> getPassagers() { return passagers; }
    public void setEtat(String etat) { this.etat = etat; }
    public void setDateHeureDepart(String dateHeureDepart) { this.dateHeureDepart = dateHeureDepart; }
    public void setDateHeureArrivee(String dateHeureArrivee) { this.dateHeureArrivee = dateHeureArrivee; }

    // Méthodes du diagramme
    public void affecterVol(Pilote pilote, List<PersonnelCabine> cabine) {
        this.pilote = pilote;
        this.equipeCabine = cabine;
        System.out.println("Équipage affecté au vol " + numeroVol);
        System.out.println("Pilote : " + pilote.getNom());
        for (PersonnelCabine pc : cabine) {
            System.out.println("Personnel cabine : " + pc.getNom());
        }
    }

    public void planifierVol() {
        System.out.println("Vol " + numeroVol + " planifie.");
        afficherTableauVols();
    }

    public void annulerVol() {
        this.etat = "Annulé";
        if (avion != null) avion.setDisponible(true);
        System.out.println("Vol " + numeroVol + " annulé.");
    }

    public void modifierVol(String nouveauDepart, String nouvelleArrivee) {
        this.dateHeureDepart = nouveauDepart;
        this.dateHeureArrivee = nouvelleArrivee;
        System.out.println("Vol " + numeroVol + " modifié.");
    }

    public void listingPassager() {
        String line = "+----------------------------------------+------------------+";
        System.out.println("\n" + line);
        System.out.printf("| %-38s | %-16s |%n", "Passagers - Vol " + numeroVol, "Passeport");
        System.out.println(line);
        if (passagers.isEmpty()) {
            System.out.printf("| %-38s | %-16s |%n", "Aucun passager enregistre", "");
        } else {
            for (Passager p : passagers) {
                System.out.printf("| %-38s | %-16s |%n",
                    truncate(p.getNom(), 38),
                    truncate(p.getPasseport(), 16));
            }
        }
        System.out.println(line);
    }

    public void ajouterPassager(Passager p) {
        passagers.add(p);
    }

    public String obtenirInfosVol() {
        String line = "+---------------------------+------------------------------+";
        return line + "\n" +
               String.format("| %-25s | %-28s |%n", "Numero de vol", numeroVol) +
               String.format("| %-25s | %-28s |%n", "Origine", origine.getNom() + " - " + origine.getVille()) +
               String.format("| %-25s | %-28s |%n", "Destination", destination.getNom() + " - " + destination.getVille()) +
               String.format("| %-25s | %-28s |%n", "Depart", dateHeureDepart) +
               String.format("| %-25s | %-28s |%n", "Arrivee", dateHeureArrivee) +
               String.format("| %-25s | %-28s |%n", "Etat", etat) +
               String.format("| %-25s | %-28s |%n", "Avion", avion.getModele() + " (" + avion.getImmatriculation() + ")") +
               line;
    }

    public static void afficherTableauVols() {
        String line = "+--------+--------------------------+--------------------------+---------------------+---------------------+---------------+";
        System.out.println("\n" + line);
        System.out.printf("| %-6s | %-24s | %-24s | %-19s | %-19s | %-13s |%n",
            "Vol", "Origine", "Destination", "Depart", "Arrivee", "Etat");
        System.out.println(line);
        if (listeVols.isEmpty()) {
            System.out.printf("| %-6s | %-24s | %-24s | %-19s | %-19s | %-13s |%n",
                "-", "Aucun vol", "", "", "", "");
        } else {
            for (Vol v : listeVols) {
                System.out.printf("| %-6s | %-24s | %-24s | %-19s | %-19s | %-13s |%n",
                    truncate(v.numeroVol, 6),
                    truncate(v.origine.getNom() + " " + v.origine.getVille(), 24),
                    truncate(v.destination.getNom() + " " + v.destination.getVille(), 24),
                    truncate(v.dateHeureDepart, 19),
                    truncate(v.dateHeureArrivee, 19),
                    truncate(v.etat, 13));
            }
        }
        System.out.println(line);
    }

    private static String truncate(String s, int max) {
        if (s == null) return "";
        return s.length() <= max ? s : s.substring(0, max - 1) + "…";
    }

    // CRUD
    public static void ajouter(Vol v) {
        listeVols.add(v);
        System.out.println("Vol ajouté : " + v.getNumeroVol());
    }

    public static Vol chercher(String numeroVol) {
        for (Vol v : listeVols) {
            if (v.getNumeroVol().equals(numeroVol)) return v;
        }
        System.out.println("Vol introuvable : " + numeroVol);
        return null;
    }

    public static boolean modifier(String numeroVol, String nouveauDepart, String nouvelleArrivee) {
        Vol v = chercher(numeroVol);
        if (v != null) {
            v.modifierVol(nouveauDepart, nouvelleArrivee);
            return true;
        }
        return false;
    }

    public static boolean supprimer(String numeroVol) {
        Vol v = chercher(numeroVol);
        if (v != null) {
            listeVols.remove(v);
            System.out.println("Vol supprimé : " + numeroVol);
            return true;
        }
        return false;
    }

    public static List<Vol> getListeVols() { return listeVols; }
}
