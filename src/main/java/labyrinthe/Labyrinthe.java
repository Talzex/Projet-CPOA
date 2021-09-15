package labyrinthe;

import exception.ExceptionInvalidFile;
import java.util.ArrayList;
import java.util.Collection;

import outils.Fichier;
import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;

    /**
     * Méthode permettant de créer un labyrinthe
     * @param file, le fichier
     */
    @Override
    public void creerLabyrinthe(String file) {
        Fichier f = null;

        try {
            if(!Fichier.testValide(file)){
                throw new ExceptionInvalidFile("Le fichier n'est pas valide");
            } else {
                f = new Fichier(file);
            }
            
        } catch (ExceptionInvalidFile ex) {
            System.out.println("Utilisation du fichier de secours");
            f = new Fichier("labys/level7.txt");
            if (!Fichier.testValide("labys/level7.txt")) {
                System.out.println("Le fichier de secours est invalide, fermeture du programme");
                System.exit(1);
            }
        }

        // dimensions
        largeur = f.lireNombre();
        hauteur = f.lireNombre();
        entree = new Salle(f.lireNombre(), f.lireNombre());
        sortie = new Salle(f.lireNombre(), f.lireNombre());
        this.add(entree);
        this.add(sortie);

        int nextint = f.lireNombre();
        while (nextint != -1) {
            Salle s = new Salle(nextint, f.lireNombre());
            this.add(s);
            nextint = f.lireNombre();

        }
    }

    /**
     * Méthode permettant à partir de la position d'un personnage, de determiner
     * les salles qui sont à sa porter.
     * @param bob, un personnage
     * @return SallesAcc, une collection de ISalle accessibles au IPersonnage
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        ISalle coordbob = bob.getPosition();
        ArrayList<ISalle> SallesAcc = new ArrayList<>();
        for (ISalle sallesAcc : this) {
            if(coordbob.estAdjacente(sallesAcc)){
                SallesAcc.add(sallesAcc);
            }
        }
        return SallesAcc;
    }

    /**
     * Retourne la ISalle de l'entrée
     * @return entree,une ISalle de l'entrée
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * Retourne la ISalle de la sortie
     * @return sortie,la ISalle de la sortie
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    /**
     * Retourne la largeur du Labyrinthe
     * @return largeur,la valeur de la largeur
     */
    @Override
    public int getLargeur() {
        return largeur;
    }
    
    /**
     * Retourne la hauteur du Labyrinthe
     * @return hauteur,la valeur de la hauteur
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }

}
