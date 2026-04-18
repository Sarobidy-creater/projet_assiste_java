package fr.isep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvImporter {

    // Lit le fichier vols.csv et affiche les donnees
    public static List<String[]> importerVols(String chemin) {
        List<String[]> vols = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(chemin));
            String ligne;
            br.readLine(); // on saute la ligne d'en-tete
            while ((ligne = br.readLine()) != null) {
                String[] colonnes = ligne.split(",");
                vols.add(colonnes);
                System.out.println("Vol lu : " + colonnes[0] + " | " + colonnes[1] + " -> " + colonnes[2]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erreur lecture vols : " + e.getMessage());
        }
        return vols;
    }

    // Lit le fichier passagers.csv et affiche les donnees
    public static List<String[]> importerPassagers(String chemin) {
        List<String[]> passagers = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(chemin));
            String ligne;
            br.readLine(); // on saute la ligne d'en-tete
            while ((ligne = br.readLine()) != null) {
                String[] colonnes = ligne.split(",");
                passagers.add(colonnes);
                System.out.println("Passager lu : " + colonnes[1] + " | " + colonnes[4]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erreur lecture passagers : " + e.getMessage());
        }
        return passagers;
    }

    // Lit le fichier reservations.csv et affiche les donnees
    public static List<String[]> importerReservations(String chemin) {
        List<String[]> reservations = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(chemin));
            String ligne;
            br.readLine();
            while ((ligne = br.readLine()) != null) {
                String[] colonnes = ligne.split(",");
                reservations.add(colonnes);
                System.out.println("Reservation lue : " + colonnes[0] + " | " + colonnes[2]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erreur lecture reservations : " + e.getMessage());
        }
        return reservations;
    }
}

