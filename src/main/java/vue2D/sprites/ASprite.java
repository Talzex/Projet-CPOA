/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import personnages.IPersonnage;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;

/**
 *
 * @author tduthil
 */
public abstract class ASprite implements ISprite {

    public IPersonnage sprite;
    public Image spriteImg;
    public ILabyrinthe labyrinthe;
    private final int unite = 15;
    public int x = 0;
    public int y = 0;
    public boolean enMouv;
    public ISalle destination;

    /**
     * Constructeur de la classe ASprite
     *
     * @param sprite, le sprite
     * @param labyrinthe, le labyrinthe
     */
    public ASprite(IPersonnage sprite, ILabyrinthe labyrinthe) {
        this.sprite = sprite;
        this.labyrinthe = labyrinthe;
        x = sprite.getPosition().getX() * unite;
        y = sprite.getPosition().getY() * unite;

    }

    /**
     * Méthode permettant de dessiner le sprite
     *
     * @param g, le GraphicsContext
     */
    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(spriteImg, x, y, unite, unite);
    }

    /**
     * Méthode permettant de définir les coordonnées graphique su sprite
     *
     * @param xpix, l'abscisse
     * @param ypix, l'ordonnée
     */
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        double xdiff = x - xpix;
        double ydiff = y - ypix;

        if (ydiff < 0) {
            y++;

        }
        if (ydiff > 0) {
            y--;

        }
        if (xdiff < 0) {
            x++;

        }
        if (xdiff > 0) {
            x--;

        }
        if (xdiff == 0 && ydiff == 0) {
            enMouv = false;
        }

    }

    @Override
    // renvoie sa position courante
    public ISalle getPosition() {
        return sprite.getPosition();
    }

    @Override
    // definit sa position courante
    public void setPosition(ISalle s) {
        
        if(!enMouv){
            enMouv = true;
            sprite.setPosition(s);
            destination = s;
        }
        if(enMouv){
            setCoordonnees(destination.getX()*unite, destination.getY()*unite);
        }
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return sprite.faitSonChoix(sallesAccessibles);
    }
}
