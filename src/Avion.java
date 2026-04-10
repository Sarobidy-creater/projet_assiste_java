import java.util.ArrayList;
import java.util.List;

public class Avion {
    private String immatriculation;
    private String modele;
    private int capacite;
    private boolean disponible;

    private static List<Avion> listeAvions = new ArrayList<>();

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
        this.disponible = true;
    }

    // Getters & Setters
    public String getImmatriculation() { return immatriculation; }
    public String getModele() { return modele; }
    public int getCapacite() { return capacite; }
    public boolean isDisponible() { return disponible; }
    public void setModele(String modele) { this.modele = modele; }
    public void setCapacite(int capacite) { this.capacite = capacite; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // Méthodes du diagramme
    public void affecterVol(Vol vol) {
        if (verifierDisponibilite()) {
            this.disponible = false;
            System.out.println("Avion " + immatriculation + " affecté au vol " + vol.getNumeroVol());
        } else {
            System.out.println("Avion " + immatriculation + " non disponible.");
        }
    }

    public boolean verifierDisponibilite() {
        if (disponible) {
            System.out.println("Avion " + immatriculation + " est disponible.");
        } else {
            System.out.println("Avion " + immatriculation + " n'est pas disponible.");
        }
        return disponible;
    }

    public String obtenirInfosAvion() {
        return "=== Informations Avion ===" +
               "\nImmatriculation : " + immatriculation +
               "\nModèle          : " + modele +
               "\nCapacité        : " + capacite +
               "\nDisponible      : " + (disponible ? "Oui" : "Non");
    }

    // CRUD
    public static void ajouter(Avion a) {
        listeAvions.add(a);
        System.out.println("Avion ajouté : " + a.getImmatriculation());
    }

    public static Avion chercher(String immatriculation) {
        for (Avion a : listeAvions) {
            if (a.getImmatriculation().equals(immatriculation)) return a;
        }
        System.out.println("Avion introuvable : " + immatriculation);
        return null;
    }

    public static boolean modifier(String immatriculation, String nouveauModele, int nouvelleCapacite) {
        Avion a = chercher(immatriculation);
        if (a != null) {
            a.setModele(nouveauModele);
            a.setCapacite(nouvelleCapacite);
            System.out.println("Avion modifié : " + immatriculation);
            return true;
        }
        return false;
    }

    public static boolean supprimer(String immatriculation) {
        Avion a = chercher(immatriculation);
        if (a != null) {
            listeAvions.remove(a);
            System.out.println("Avion supprimé : " + immatriculation);
            return true;
        }
        return false;
    }

    public static List<Avion> getListeAvions() { return listeAvions; }
}
