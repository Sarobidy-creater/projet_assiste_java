package fr.isep;

import org.junit.Test;
import static org.junit.Assert.*;

public class PassagerTest {

    @Test
    public void testCreationPassager() {
        Passager p = new Passager(1, "Sara Rakoto", "Tana", "034000", "PP-123");
        assertEquals("Sara Rakoto", p.getNom());
        assertEquals("PP-123", p.getPasseport());
        assertEquals(1, p.getIdentifiant());
    }

    @Test
    public void testReserverVol() {
        Aeroport a1 = new Aeroport("CDG", "Paris", "CDG");
        Aeroport a2 = new Aeroport("TNR", "Tana", "Ivato");
        Avion avion = new Avion("F-P01", "Boeing 737", 180);
        Vol vol     = new Vol("P001", a1, a2, "2026-04-10 08:00", "2026-04-10 20:00", "Planifie", avion);
        Passager p  = new Passager(2, "Paul Rabe", "Fiana", "034001", "PP-456");
        Reservation r = new Reservation("RES-P1", "2026-04-01", "En attente", p, vol);
        p.reserverVol(r);
        assertEquals(1, p.getReservations().size());
    }
}

