package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
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
    private Image murImage;
    private Image sortieImage;
    private Image sallesImage;
    private Image entreeImage;
    
   
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites)
    {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur()*unite);
        setHeight(labyrinthe.getHauteur()*unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
    }
    
     public void chargementImages(){
    	murImage = new Image("file:icons/mur0.gif");
        entreeImage = new Image("file:icons/groundP.gif");
        sortieImage = new Image("file:icons/sortie.gif");
        sallesImage = new Image("file:icons/ground.gif");
    }

    public void dessinFond() {
        //Dessin Mur
        for(int i = 0; i < labyrinthe.getLargeur(); i++){
            for(int j = 0; j < labyrinthe.getHauteur(); j++){
                tampon.drawImage(murImage,unite*i,unite*j);
            }
        }
        
        //Dessin Salles
        for(ISalle salles : labyrinthe){
            tampon.drawImage(sallesImage,unite*salles.getX(),unite*salles.getY());
        }
        
        //Dessin Entree
        ISalle entree = labyrinthe.getEntree();
        tampon.drawImage(entreeImage,unite*entree.getX(), unite*entree.getY());
        
        //Dessin Sortie
        ISalle sortie = labyrinthe.getSortie();
        tampon.drawImage(sortieImage,unite*sortie.getX(), unite*sortie.getY());
        
        
    }

}
