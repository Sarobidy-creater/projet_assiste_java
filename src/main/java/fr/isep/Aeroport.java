package fr.isep;

import java.util.ArrayList;
import java.util.List;

public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    private static List<Aeroport> listeAeroports = new ArrayList<>();

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
    }

    // Getters & Setters
    public String getNom() { return nom; }
    public String getVille() { return ville; }
    public String getDescription() { return description; }
    public void setNom(String nom) { this.nom = nom; }
    public void setVille(String ville) { this.ville = ville; }
    public void setDescription(String description) { this.description = description; }

    // Méthode du diagramme
    public void affecterVol(Vol vol) {
        System.out.println("Vol " + vol.getNumeroVol() + " affecté à l'aéroport " + nom + " (" + ville + ")");
    }

    public String obtenirInfosAeroport() {
        return "=== Informations Aéroport ===" +
               "\nNom         : " + nom +
               "\nVille       : " + ville +
               "\nDescription : " + description;
    }

    // CRUD
    public static void ajouter(Aeroport a) {
        listeAeroports.add(a);
        System.out.println("Aéroport ajouté : " + a.getNom());
    }

    public static Aeroport chercher(String nom) {
        for (Aeroport a : listeAeroports) {
            if (a.getNom().equals(nom)) return a;
        }
        System.out.println("Aéroport introuvable : " + nom);
        return null;
    }

    public static boolean modifier(String nom, String nouvelleVille, String nouvelleDescription) {
        Aeroport a = chercher(nom);
        if (a != null) {
            a.setVille(nouvelleVille);
            a.setDescription(nouvelleDescription);
            System.out.println("Aéroport modifié : " + nom);
            return true;
        }
        return false;
    }

    public static boolean supprimer(String nom) {
        Aeroport a = chercher(nom);
        if (a != null) {
            listeAeroports.remove(a);
            System.out.println("Aéroport supprimé : " + nom);
            return true;
        }
        return false;
    }

    public static List<Aeroport> getListeAeroports() { return listeAeroports; }
}
