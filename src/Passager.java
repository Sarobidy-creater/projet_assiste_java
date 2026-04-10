public class Passager extends Personne {
    private String passeport;

    public Passager(int identifiant, String nom, String adresse, String contact, String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
    }

    public String getPasseport() { return passeport; }

    public void reserverVol() {
        System.out.println("Vol réservé pour " + getNom());
    }

    public void annulerReservation() {
        System.out.println("Réservation annulée pour " + getNom());
    }

    public void obtenirReservations() {
        System.out.println("Réservations de " + getNom());
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
               "\nPasseport : " + passeport;
    }
}

