package fr.isep;

import org.junit.Test;
import static org.junit.Assert.*;

public class PiloteTest {

    @Test
    public void testCreationPilote() {
        Pilote p = new Pilote(1, "Jean Dupont", "Paris", "0600000001", "EMP001", "2015-03-01", "LIC-2023", 5000);
        assertEquals("Jean Dupont", p.getNom());
        assertEquals("LIC-2023", p.getLicence());
        assertEquals(5000, p.getHeuresDeVol());
    }

    @Test
    public void testObtenirRole() {
        Pilote p = new Pilote(2, "Marie Durand", "Lyon", "0600000002", "EMP002", "2018-01-01", "LIC-2019", 3000);
        assertEquals("Pilote", p.obtenirRole());
    }
}

