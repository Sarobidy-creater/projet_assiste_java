package fr.isep;

import java.util.ArrayList;
import java.util.List;

public class PersonnelCabine extends Employe {
    private String qualification;

    private static List<PersonnelCabine> listePersonnelCabine = new ArrayList<>();

    public PersonnelCabine(int identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    // Getters & Setters
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    // Méthodes du diagramme
    public void affecterVol(Vol vol) {
        System.out.println("Personnel cabine " + getNom() + " affecté au vol " + vol.getNumeroVol());
    }

    public void obtenirVol(Vol vol) {
        System.out.println("=== Vol du personnel cabine " + getNom() + " ===");
        System.out.println(vol.obtenirInfosVol());
    }

    @Override
    public String obtenirRole() {
        return "Personnel Cabine";
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
               "\nQualification  : " + qualification;
    }

    // CRUD
    public static void ajouter(PersonnelCabine pc) {
        listePersonnelCabine.add(pc);
        System.out.println("Personnel cabine ajouté : " + pc.getNom());
    }

    public static PersonnelCabine chercher(String numeroEmploye) {
        for (PersonnelCabine pc : listePersonnelCabine) {
            if (pc.getNumeroEmploye().equals(numeroEmploye)) return pc;
        }
        System.out.println("Personnel cabine introuvable : " + numeroEmploye);
        return null;
    }

    public static boolean modifier(String numeroEmploye, String nouvelleQualification) {
        PersonnelCabine pc = chercher(numeroEmploye);
        if (pc != null) {
            pc.setQualification(nouvelleQualification);
            System.out.println("Personnel cabine modifié : " + pc.getNom());
            return true;
        }
        return false;
    }

    public static boolean supprimer(String numeroEmploye) {
        PersonnelCabine pc = chercher(numeroEmploye);
        if (pc != null) {
            listePersonnelCabine.remove(pc);
            System.out.println("Personnel cabine supprimé : " + pc.getNom());
            return true;
        }
        return false;
    }

    public static List<PersonnelCabine> getListePersonnelCabine() { return listePersonnelCabine; }
}
