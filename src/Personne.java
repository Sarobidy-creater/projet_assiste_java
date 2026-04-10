import java.util.ArrayList;
import java.util.List;

public class Personne {
    private int identifiant;
    private String nom;
    private String adresse;
    private String contact;

    // Liste statique pour CRUD
    private static List<Personne> listePersonnes = new ArrayList<>();

    public Personne(int identifiant, String nom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }

    // Getters
    public int getIdentifiant() { return identifiant; }
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public String getContact() { return contact; }

    // Setters
    public void setNom(String nom) { this.nom = nom; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setContact(String contact) { this.contact = contact; }

    // Méthode du diagramme
    public String obtenirInfos() {
        return "=== Informations Personne ===" +
               "\nIdentifiant : " + identifiant +
               "\nNom         : " + nom +
               "\nAdresse     : " + adresse +
               "\nContact     : " + contact;
    }

    // CRUD
    public static void ajouter(Personne p) {
        listePersonnes.add(p);
        System.out.println("Personne ajoutée : " + p.getNom());
    }

    public static Personne chercher(int identifiant) {
        for (Personne p : listePersonnes) {
            if (p.getIdentifiant() == identifiant) return p;
        }
        System.out.println("Personne introuvable avec l'identifiant : " + identifiant);
        return null;
    }

    public static boolean modifier(int identifiant, String nouveauNom, String nouvelleAdresse, String nouveauContact) {
        Personne p = chercher(identifiant);
        if (p != null) {
            p.setNom(nouveauNom);
            p.setAdresse(nouvelleAdresse);
            p.setContact(nouveauContact);
            System.out.println("Personne modifiée : " + nouveauNom);
            return true;
        }
        return false;
    }

    public static boolean supprimer(int identifiant) {
        Personne p = chercher(identifiant);
        if (p != null) {
            listePersonnes.remove(p);
            System.out.println("Personne supprimée : " + p.getNom());
            return true;
        }
        return false;
    }

    public static List<Personne> getListePersonnes() { return listePersonnes; }
}
