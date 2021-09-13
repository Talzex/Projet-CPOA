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
import labyrinthe.Salle;

/**
 *
 * @author tduthil
 */
public abstract class ASprite implements ISprite {

    public IPersonnage sprite;
    public Image spriteImg;
    public ILabyrinthe labyrinthe;
    private final int unite = 15;

    public ASprite(IPersonnage sprite, ILabyrinthe labyrinthe) {
        this.sprite = sprite;
        this.labyrinthe = labyrinthe;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(spriteImg, unite * sprite.getPosition().getX(), unite * sprite.getPosition().getY() - (spriteImg.getHeight() / 2));
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        sprite.setPosition(new Salle(xpix, ypix));
    }

    @Override
    public ISalle getPosition() {
        return sprite.getPosition();
    }

    @Override
    // definit sa position courante
    public void setPosition(ISalle s) {
        sprite.setPosition(s);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return sprite.faitSonChoix(sallesAccessibles);
    }
}
