public class Vol {
    private String numeroVol;
    private Aeroport origine;       // aéroport de départ
    private Aeroport destination;   // aéroport d'arrivée
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;
    private Avion avion;

    public Vol(String numeroVol, Aeroport origine, Aeroport destination, String dateHeureDepart, String dateHeureArrivee, String etat, Avion avion) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = etat;
        this.avion = avion;
    }

    public String getNumeroVol() { return numeroVol; }
    public Aeroport getOrigine() { return origine; }
    public Aeroport getDestination() { return destination; }
    public String getDateHeureDepart() { return dateHeureDepart; }
    public String getDateHeureArrivee() { return dateHeureArrivee; }
    public String getEtat() { return etat; }
    public Avion getAvion() { return avion; }

    public void planifierVol() {
        System.out.println("Vol " + numeroVol + " planifié de " + origine.getNom() + " vers " + destination.getNom());
    }

    public void annulerVol() {
        this.etat = "Annulé";
        System.out.println("Vol " + numeroVol + " annulé.");
    }

    public void modifierVol() {
        System.out.println("Vol " + numeroVol + " modifié.");
    }

    public void listingPassager() {
        System.out.println("Liste des passagers du vol " + numeroVol);
    }
}

