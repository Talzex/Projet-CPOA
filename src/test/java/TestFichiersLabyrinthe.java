
import static org.junit.Assert.*;
import java.io.File;
import java.util.Scanner;
import labyrinthe.Salle;
import org.junit.Test;
import outils.Fichier;

/**
 *
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }

    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for (File f : fichiers) {
            if (!testCoordonneesSallesFichier(f)) {
                System.out.println(f.getName() + " est invalide");
            } else {
                System.out.println(f.getName() + " est valide");
            }
        }

    }

    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    public boolean testCoordonneesSallesFichier(File f) {
        Scanner sc=null;
        int largeur = 0;
        int hauteur = 0;
        
        try{
            sc = new Scanner(f);
        } catch (Exception e){
            System.out.println(e);
        }
        
        if(sc.hasNextLine()){
            largeur = sc.nextInt();
            hauteur = sc.nextInt();
        }
        
        while (sc.hasNextInt()){
            int nextInt = sc.nextInt();
            if(nextInt < 0 || nextInt >= largeur || nextInt >= hauteur){
                return false;
            }
        }
        return true;
        
        
    }

}
