package fr.isep;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservationTest {

    private Reservation resa;

    @Before
    public void setUp() {
        Aeroport paris = new Aeroport("CDG", "Paris", "CDG Airport");
        Aeroport tana  = new Aeroport("TNR", "Tana", "Ivato");
        Avion avion    = new Avion("F-T01", "Boeing 737", 180);
        Vol vol        = new Vol("T001", paris, tana, "2026-04-10 08:00", "2026-04-10 20:00", "Planifie", avion);
        Passager p     = new Passager(99, "Test User", "Addr", "000", "PP-000");
        resa = new Reservation("RES-T", "2026-01-01", "En attente", p, vol);
    }

    @Test
    public void testNumeroReservation() {
        assertEquals("RES-T", resa.getNumeroReservation());
    }

    @Test
    public void testConfirmerReservation() {
        resa.confirmerReservation();
        assertEquals("Confirme", resa.getStatut());
    }

    @Test
    public void testAnnulerReservation() {
        resa.annulerReservation();
        assertEquals("Annule", resa.getStatut());
    }
}

