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

    /**
     * Constructeur de la classe ASprite
     *
     * @param sprite, le sprite
     * @param labyrinthe, le labyrinthe
     */
    public ASprite(IPersonnage sprite, ILabyrinthe labyrinthe) {
        this.sprite = sprite;
        this.labyrinthe = labyrinthe;
        this.setCoordonnees(sprite.getPosition().getX() * unite, sprite.getPosition().getY() * unite);

    }

    /**
     * Méthode permettant de dessiner le sprite
     *
     * @param g, le GraphicsContext
     */
    @Override
    public void dessiner(GraphicsContext g) {

        int SalleChoisiex = sprite.getPosition().getX() * unite;
        int SalleChoisiey = sprite.getPosition().getY() * unite;
        int xdiff = x - SalleChoisiex;
        int ydiff = y - SalleChoisiey;

        if (ydiff < 0) {
            y++;
            enMouv = true;
        }
        if (ydiff > 0) {
            y--;
            enMouv = true;
        }
        if (xdiff < 0) {
            x++;
            enMouv = true;
        }
        if (xdiff > 0) {
            x--;
            enMouv = true;

        }
        if (xdiff == 0 && ydiff == 0) {
            enMouv = false;
        }

        g.drawImage(spriteImg, x, y - (spriteImg.getHeight() / 2));
    }

    /**
     * Méthode permettant de définir les coordonnées graphique su sprite
     *
     * @param xpix, l'abscisse
     * @param ypix, l'ordonnée
     */
    @Override
    public void setCoordonnees(int xpix, int ypix
    ) {
        x = xpix;
        y = ypix;
    }

    @Override
    // renvoie sa position courante
    public ISalle getPosition() {
        return sprite.getPosition();
    }

    @Override
    // definit sa position courante
    public void setPosition(ISalle s
    ) {
        sprite.setPosition(s);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles
    ) {
        return sprite.faitSonChoix(sallesAccessibles);
    }
}
