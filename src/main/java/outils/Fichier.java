package outils;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author INFO Professors team
 */
public class Fichier {
    Scanner sc=null;
    
    public Fichier(String nomFichier){
        try{
	    sc = new Scanner(new File(nomFichier));
	}
	catch(Exception e){ System.out.println(e); }     
    }
    
  // retourne le prochain entier dans le fichier
  // retourne -1 s'il n'y en a pas
    public int lireNombre(){
        if (sc.hasNextInt()){
            return sc.nextInt();
        }
        return -1;
    }
    
    public static boolean testValide(String nomFichier){
        File f = new File(nomFichier);
        return testCoordonneesSallesFichier(f) && testPasDeDoublonFichier(f);
    }
    
    public static boolean testPasDeDoublonFichier(File f) {

        Scanner sc = null;
        int largeur = 0;
        int hauteur = 0;
        try {
            sc = new Scanner(f);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (sc.hasNextLine()) {
            largeur = sc.nextInt();
            hauteur = sc.nextInt();
        }
        boolean[][] tab = new boolean[largeur][hauteur];
        for (boolean[] row : tab) {
            Arrays.fill(row, false);
        }

        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            if (sc.hasNextInt()) {
                int y = sc.nextInt();
                if (!(x < 0 || y < 0 || x >= largeur || y >= largeur || x >= hauteur || y >= hauteur)) {
                    if (!tab[x][y]) {
                        tab[x][y] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public static boolean testCoordonneesSallesFichier(File f) {
         Scanner sc = null;
        int largeur = 0;
        int hauteur = 0;
        try {
            sc = new Scanner(f);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (sc.hasNextLine()) {
            largeur = sc.nextInt();
            hauteur = sc.nextInt();
        }

        while (sc.hasNextInt()) {
            int nextInt = sc.nextInt();
            if (nextInt < 0 || nextInt >= largeur || nextInt >= hauteur) {
                return false;
            }
        }
        return true;

    }
}

