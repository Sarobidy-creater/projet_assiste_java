public class Reservation {
    private String numeroReservation;
    private String dateReservation;
    private String statut;
    private Passager passager;  // 1 passager par réservation
    private Vol vol;            // 1 vol par réservation

    public Reservation(String numeroReservation, String dateReservation, String statut, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.passager = passager;
        this.vol = vol;
    }

    public String getNumeroReservation() { return numeroReservation; }
    public String getDateReservation() { return dateReservation; }
    public String getStatut() { return statut; }
    public Passager getPassager() { return passager; }
    public Vol getVol() { return vol; }

    public void confirmerReservation() {
        this.statut = "Confirmé";
        System.out.println("Réservation " + numeroReservation + " confirmée.");
    }

    public void annulerReservation() {
        this.statut = "Annulé";
        System.out.println("Réservation " + numeroReservation + " annulée.");
    }

    public void modifierReservation() {
        System.out.println("Réservation " + numeroReservation + " modifiée.");
    }
}

