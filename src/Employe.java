import java.util.ArrayList;
import java.util.List;

public class Employe extends Personne {
    private String numeroEmploye;
    private String dateEmbauche;

    private static List<Employe> listeEmployes = new ArrayList<>();

    public Employe(int identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    // Getters & Setters
    public String getNumeroEmploye() { return numeroEmploye; }
    public String getDateEmbauche() { return dateEmbauche; }
    public void setNumeroEmploye(String numeroEmploye) { this.numeroEmploye = numeroEmploye; }
    public void setDateEmbauche(String dateEmbauche) { this.dateEmbauche = dateEmbauche; }

    // Méthode du diagramme
    public String obtenirRole() {
        return "Employé";
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
               "\nNuméro Employé : " + numeroEmploye +
               "\nDate Embauche  : " + dateEmbauche +
               "\nRôle           : " + obtenirRole();
    }

    // CRUD
    public static void ajouter(Employe e) {
        listeEmployes.add(e);
        System.out.println("Employé ajouté : " + e.getNom());
    }

    public static Employe chercher(String numeroEmploye) {
        for (Employe e : listeEmployes) {
            if (e.getNumeroEmploye().equals(numeroEmploye)) return e;
        }
        System.out.println("Employé introuvable : " + numeroEmploye);
        return null;
    }

    public static boolean modifier(String numeroEmploye, String nouvelleDate) {
        Employe e = chercher(numeroEmploye);
        if (e != null) {
            e.setDateEmbauche(nouvelleDate);
            System.out.println("Employé modifié : " + e.getNom());
            return true;
        }
        return false;
    }

    public static boolean supprimer(String numeroEmploye) {
        Employe e = chercher(numeroEmploye);
        if (e != null) {
            listeEmployes.remove(e);
            System.out.println("Employé supprimé : " + e.getNom());
            return true;
        }
        return false;
    }

    public static List<Employe> getListeEmployes() { return listeEmployes; }
}
