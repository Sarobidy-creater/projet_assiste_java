package fr.isep;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VolTest {

    private Vol vol;

    @Before
    public void setUp() {
        Aeroport paris = new Aeroport("CDG", "Paris", "CDG");
        Aeroport tana  = new Aeroport("TNR", "Tana", "Ivato");
        Avion avion    = new Avion("F-V01", "Boeing 737", 180);
        vol = new Vol("V001", paris, tana, "2026-04-10 08:00", "2026-04-10 20:00", "Planifie", avion);
    }

    @Test
    public void testNumeroVol() {
        assertEquals("V001", vol.getNumeroVol());
    }

    @Test
    public void testEtatInitial() {
        assertEquals("Planifie", vol.getEtat());
    }

    @Test
    public void testAnnulerVol() {
        vol.annulerVol();
        assertEquals("Annulé", vol.getEtat());
    }

    @Test
    public void testOrigine() {
        assertEquals("CDG", vol.getOrigine().getNom());
    }
}

