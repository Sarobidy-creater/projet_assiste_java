import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne {
    private String passeport;
    private List<Reservation> reservations = new ArrayList<>();

    private static List<Passager> listePassagers = new ArrayList<>();

    public Passager(int identifiant, String nom, String adresse, String contact, String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
    }

    // Getters & Setters
    public String getPasseport() { return passeport; }
    public void setPasseport(String passeport) { this.passeport = passeport; }
    public List<Reservation> getReservations() { return reservations; }

    // Méthodes du diagramme
    public void reserverVol(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Vol réservé pour " + getNom() + " - Réservation : " + reservation.getNumeroReservation());
    }

    public void annulerReservation(String numeroReservation) {
        for (Reservation r : reservations) {
            if (r.getNumeroReservation().equals(numeroReservation)) {
                r.annulerReservation();
                reservations.remove(r);
                return;
            }
        }
        System.out.println("Réservation introuvable : " + numeroReservation);
    }

    public void obtenirReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation pour " + getNom());
            return;
        }
        System.out.println("=== Réservations de " + getNom() + " ===");
        for (Reservation r : reservations) {
            System.out.println(r.obtenirInfosReservation());
        }
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
               "\nPasseport      : " + passeport;
    }

    // CRUD
    public static void ajouter(Passager p) {
        listePassagers.add(p);
        System.out.println("Passager ajouté : " + p.getNom());
    }

    public static Passager chercher(int identifiant) {
        for (Passager p : listePassagers) {
            if (p.getIdentifiant() == identifiant) return p;
        }
        System.out.println("Passager introuvable : " + identifiant);
        return null;
    }

    public static boolean modifier(int identifiant, String nouveauPasseport) {
        Passager p = chercher(identifiant);
        if (p != null) {
            p.setPasseport(nouveauPasseport);
            System.out.println("Passager modifié : " + p.getNom());
            return true;
        }
        return false;
    }

    public static boolean supprimer(int identifiant) {
        Passager p = chercher(identifiant);
        if (p != null) {
            listePassagers.remove(p);
            System.out.println("Passager supprimé : " + p.getNom());
            return true;
        }
        return false;
    }

    public static List<Passager> getListePassagers() { return listePassagers; }
}
