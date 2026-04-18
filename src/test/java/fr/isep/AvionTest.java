package fr.isep;

import org.junit.Test;
import static org.junit.Assert.*;

public class AvionTest {

    @Test
    public void testCreationAvion() {
        Avion avion = new Avion("F-TEST", "Boeing 737", 180);
        assertEquals("F-TEST", avion.getImmatriculation());
        assertEquals(180, avion.getCapacite());
        assertEquals("Boeing 737", avion.getModele());
    }

    @Test
    public void testDisponibiliteInitiale() {
        Avion avion = new Avion("F-TEST2", "Airbus A320", 150);
        assertTrue(avion.isDisponible());
    }

    @Test
    public void testSetDisponible() {
        Avion avion = new Avion("F-TEST3", "Boeing 777", 300);
        avion.setDisponible(false);
        assertFalse(avion.isDisponible());
    }
}

