import java.util.ArrayList;
import java.util.List;

public class Pilote extends Employe {
    private String licence;
    private int heuresDeVol;

    private static List<Pilote> listePilotes = new ArrayList<>();

    public Pilote(int identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    // Getters & Setters
    public String getLicence() { return licence; }
    public int getHeuresDeVol() { return heuresDeVol; }
    public void setLicence(String licence) { this.licence = licence; }
    public void setHeuresDeVol(int heuresDeVol) { this.heuresDeVol = heuresDeVol; }

    // Méthodes du diagramme
    public void affecterVol(Vol vol) {
        System.out.println("Pilote " + getNom() + " affecté au vol " + vol.getNumeroVol());
    }

    public void obtenirVol(Vol vol) {
        System.out.println("=== Vol du pilote " + getNom() + " ===");
        System.out.println(vol.obtenirInfosVol());
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
               "\nLicence        : " + licence +
               "\nHeures de vol  : " + heuresDeVol;
    }

    // CRUD
    public static void ajouter(Pilote p) {
        listePilotes.add(p);
        System.out.println("Pilote ajouté : " + p.getNom());
    }

    public static Pilote chercher(String numeroEmploye) {
        for (Pilote p : listePilotes) {
            if (p.getNumeroEmploye().equals(numeroEmploye)) return p;
        }
        System.out.println("Pilote introuvable : " + numeroEmploye);
        return null;
    }

    public static boolean modifier(String numeroEmploye, String nouvelleLicence, int nouvellesHeures) {
        Pilote p = chercher(numeroEmploye);
        if (p != null) {
            p.setLicence(nouvelleLicence);
            p.setHeuresDeVol(nouvellesHeures);
            System.out.println("Pilote modifié : " + p.getNom());
            return true;
        }
        return false;
    }

    public static boolean supprimer(String numeroEmploye) {
        Pilote p = chercher(numeroEmploye);
        if (p != null) {
            listePilotes.remove(p);
            System.out.println("Pilote supprimé : " + p.getNom());
            return true;
        }
        return false;
    }

    public static List<Pilote> getListePilotes() { return listePilotes; }
}
