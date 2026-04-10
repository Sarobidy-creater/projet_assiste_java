public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
    }

    public String getNom() { return nom; }
    public String getVille() { return ville; }
    public String getDescription() { return description; }

    public void affecterVol() {
        System.out.println("Vol affecté à l'aéroport " + nom);
    }
}

