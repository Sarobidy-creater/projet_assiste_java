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
        System.out.println("Vol " + numeroVol + " planifié :" +
               "\nDépart : " + origine.getNom() + " (" + dateHeureDepart + ")" +
               "\nArrivée : " + destination.getNom() + " (" + dateHeureArrivee + ")");
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
        if (passagers.isEmpty()) {
            System.out.println("Aucun passager pour le vol " + numeroVol);
            return;
        }
        System.out.println("=== Passagers du vol " + numeroVol + " ===");
        for (Passager p : passagers) {
            System.out.println("- " + p.getNom() + " | Passeport : " + p.getPasseport());
        }
    }

    public void ajouterPassager(Passager p) {
        passagers.add(p);
    }

    public String obtenirInfosVol() {
        return "=== Informations Vol ===" +
               "\nNuméro de vol   : " + numeroVol +
               "\nOrigine         : " + origine.getNom() + " (" + origine.getVille() + ")" +
               "\nDestination     : " + destination.getNom() + " (" + destination.getVille() + ")" +
               "\nDépart          : " + dateHeureDepart +
               "\nArrivée         : " + dateHeureArrivee +
               "\nÉtat            : " + etat +
               "\nAvion           : " + avion.getModele() + " (" + avion.getImmatriculation() + ")";
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
