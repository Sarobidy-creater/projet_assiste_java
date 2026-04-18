package fr.isep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VolDao {

    public static void initialiserTables() {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return;
        try {
            conn.createStatement().executeUpdate(
                "CREATE TABLE IF NOT EXISTS avion (" +
                "immatriculation VARCHAR(20) PRIMARY KEY," +
                "modele VARCHAR(100)," +
                "capacite INT," +
                "disponible BOOLEAN)"
            );
            conn.createStatement().executeUpdate(
                "CREATE TABLE IF NOT EXISTS vol (" +
                "numero_vol VARCHAR(20) PRIMARY KEY," +
                "origine VARCHAR(50)," +
                "destination VARCHAR(50)," +
                "date_depart VARCHAR(50)," +
                "date_arrivee VARCHAR(50)," +
                "etat VARCHAR(50)," +
                "avion VARCHAR(20))"
            );
            conn.createStatement().executeUpdate(
                "CREATE TABLE IF NOT EXISTS passager (" +
                "id INT PRIMARY KEY," +
                "nom VARCHAR(100)," +
                "adresse VARCHAR(200)," +
                "contact VARCHAR(50)," +
                "passeport VARCHAR(50))"
            );
            conn.createStatement().executeUpdate(
                "CREATE TABLE IF NOT EXISTS reservation (" +
                "numero VARCHAR(20) PRIMARY KEY," +
                "date_reservation VARCHAR(50)," +
                "statut VARCHAR(50)," +
                "passager_id INT," +
                "vol_id VARCHAR(20))"
            );
            System.out.println("Tables initialisees.");
        } catch (SQLException e) {
            System.out.println("Erreur initialisation tables : " + e.getMessage());
        }
    }

    public static void sauvegarderVol(Vol vol) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return;
        String sql = "INSERT IGNORE INTO vol (numero_vol, origine, destination, date_depart, date_arrivee, etat, avion) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vol.getNumeroVol());
            ps.setString(2, vol.getOrigine().getNom());
            ps.setString(3, vol.getDestination().getNom());
            ps.setString(4, vol.getDateHeureDepart());
            ps.setString(5, vol.getDateHeureArrivee());
            ps.setString(6, vol.getEtat());
            ps.setString(7, vol.getAvion().getImmatriculation());
            ps.executeUpdate();
            System.out.println("Vol " + vol.getNumeroVol() + " sauvegarde en BDD.");
        } catch (SQLException e) {
            System.out.println("Erreur sauvegarde vol : " + e.getMessage());
        }
    }

    public static void sauvegarderPassager(Passager p) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return;
        String sql = "INSERT IGNORE INTO passager (id, nom, adresse, contact, passeport) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getIdentifiant());
            ps.setString(2, p.getNom());
            ps.setString(3, p.getAdresse());
            ps.setString(4, p.getContact());
            ps.setString(5, p.getPasseport());
            ps.executeUpdate();
            System.out.println("Passager " + p.getNom() + " sauvegarde en BDD.");
        } catch (SQLException e) {
            System.out.println("Erreur sauvegarde passager : " + e.getMessage());
        }
    }

    public static void sauvegarderReservation(Reservation r) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return;
        String sql = "INSERT IGNORE INTO reservation (numero, date_reservation, statut, passager_id, vol_id) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, r.getNumeroReservation());
            ps.setString(2, r.getDateReservation());
            ps.setString(3, r.getStatut());
            ps.setInt(4, r.getPassager().getIdentifiant());
            ps.setString(5, r.getVol().getNumeroVol());
            ps.executeUpdate();
            System.out.println("Reservation " + r.getNumeroReservation() + " sauvegardee en BDD.");
        } catch (SQLException e) {
            System.out.println("Erreur sauvegarde reservation : " + e.getMessage());
        }
    }
}

