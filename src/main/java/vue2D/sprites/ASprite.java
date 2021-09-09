/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import personnages.IPersonnage;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.Salle;

/**
 *
 * @author tduthil
 */
public abstract class ASprite implements ISprite {

    public IPersonnage sprite;
    public Image Isprite;
    public ILabyrinthe labyrinthe;
    private final int unite = 15;

    public ASprite(IPersonnage sprite, ILabyrinthe labyrinthe) {
        this.sprite = sprite;
        this.labyrinthe = labyrinthe;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(Isprite, unite * sprite.getPosition().getX(), unite * sprite.getPosition().getX());
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        sprite.setPosition(new Salle(xpix,ypix));
    }
}
