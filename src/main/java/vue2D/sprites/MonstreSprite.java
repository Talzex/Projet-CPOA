/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import personnages.IPersonnage;
import personnages.Monstre;

/**
 *
 * @author tduthil
 */
public class MonstreSprite extends ASprite {

    public Monstre monstre;

    /**
     * Le Constructeur de la classe MonstreSprite
     * @param sprite, le sprite du monstre
     * @param labyrinthe, le labyrinthe
     */
    public MonstreSprite(IPersonnage sprite, ILabyrinthe labyrinthe) {
        super(sprite, labyrinthe);
        chargementImages();

    }

    /**
     * Méthode permettant de charger l'image du monstre
     */
    public void chargementImages() {
        spriteImg = new Image("file:icons/monstre0.gif");
    }
}
