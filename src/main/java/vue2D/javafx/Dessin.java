package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private final int unite = 15;
    private GraphicsContext tampon;
    //private Image murImage;
    private Image sortieImage;
    private Image sallesImage;
    private Image entreeImage;
    private Image solImage;

    /**
     * Constructeur de la classe Dessin
     *
     * @param labyrinthe, le labyrinthe
     * @param sprites, la collection des sprites dans le labyrinthe
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur() * unite);
        setHeight(labyrinthe.getHauteur() * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
    }

    /**
     * Méthode permettant de charger les différentes images
     */
    public void chargementImages() {
        //murImage = new Image("file:icons/mur0.gif");
        entreeImage = new Image("file:icons/groundP.gif");
        sortieImage = new Image("file:icons/sortie.gif");
        sallesImage = new Image("file:icons/ground.gif");
        solImage = new Image("file:icons/pyramide.jpg");
    }

    /**
     * Méthode permettant d'associer les images à une position
     */
    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * labyrinthe.getLargeur(), unite * labyrinthe.getHauteur());

        //Dessin Salles
        ISprite heros = (ISprite) sprites.toArray()[0];
        int xHeros = heros.getPosition().getX();
        int yHeros = heros.getPosition().getY();
        int portee = 5;

        for (ISalle salles : labyrinthe) {
            if (salles.getX() + portee > xHeros && salles.getX() - portee < xHeros && salles.getY() + portee > yHeros && salles.getY() - portee < yHeros) {
                tampon.drawImage(sallesImage, unite * salles.getX(), unite * salles.getY());
            }

        }

        //Dessin Entree
        ISalle entree = labyrinthe.getEntree();
        tampon.drawImage(entreeImage, unite * entree.getX(), unite * entree.getY());

        //Dessin Sortie
        ISalle sortie = labyrinthe.getSortie();
        tampon.drawImage(sortieImage, unite * sortie.getX(), unite * sortie.getY());

    }

}
