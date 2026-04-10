public class Avion {
    private String immatriculation;
    private String modele;
    private int capacite;

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
    }

    public String getImmatriculation() { return immatriculation; }
    public String getModele() { return modele; }
    public int getCapacite() { return capacite; }

    public void affecterVol() {
        System.out.println("Avion " + immatriculation + " affecté au vol.");
    }

    public boolean verifierDisponibilite() {
        System.out.println("Vérification de la disponibilité de l'avion " + immatriculation);
        return true;
    }
}

