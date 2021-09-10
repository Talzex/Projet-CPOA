/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import personnages.Monstre;

/**
 *
 * @author tduthil
 */
public class MonstreSprite extends ASprite {

    public Monstre monstre;

    public MonstreSprite(IPersonnage sprite, ILabyrinthe labyrinthe) {
        super(sprite, labyrinthe);
        chargementImages();

    }

    public void chargementImages() {
        IMonstresprite = new Image("file:icons/monstre0.gif");
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISalle getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(ISalle s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
