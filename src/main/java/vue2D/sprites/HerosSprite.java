/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;


import javafx.event.EventHandler;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import personnages.Heros;

/**
 *
 * @author tduthil
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {
    
    public Heros heros;

    /**
     * Constructeur de classe HerosSprite
     * @param sprite, le sprite du heros
     * @param labyrinthe, le labyrinthe
     */
    public HerosSprite(IPersonnage sprite,ILabyrinthe labyrinthe ){
        super(sprite, labyrinthe);
        chargementImages();
        heros = (Heros) sprite;
    }

    /**
     * Méthode permettant de charger l'image du héros
     */
    public void chargementImages(){
    	spriteImg = new Image("file:icons/link/LinkRunShieldD1.gif");
    }
    
    /**
     * Méthode permettant d'associer un déplacement en fonction du clavier
     * @param event, la touche appuyer
     */
    @Override
    public void handle(KeyEvent event) {
        
        int x = heros.getPosition().getX();
        int y = heros.getPosition().getY();
        switch(event.getCode()){
            case LEFT:
                x--;
                spriteImg = new Image("file:icons/link/LinkRunShieldL1.gif");
                break;
            case RIGHT:
                x++;
                spriteImg = new Image("file:icons/link/LinkRunR1.gif");
                break;
            case UP:
                y--;
                spriteImg = new Image("file:icons/link/LinkRunU1.gif");
                break;
            case DOWN:
                y++;
                spriteImg = new Image("file:icons/link/LinkRunShieldD1.gif");
                break;
            
        }
        for(ISalle s : labyrinthe.sallesAccessibles(heros)){
            if(s.getX() == x && s.getY() == y){
                heros.salleChoisie = s;
            }
        }
    }
}
