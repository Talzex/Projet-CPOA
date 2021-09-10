/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;


import java.util.Collection;
import javafx.event.EventHandler;

import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.Salle;
import personnages.Heros;

/**
 *
 * @author tduthil
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {
    
    public Heros heros;
    public HerosSprite(IPersonnage sprite,ILabyrinthe labyrinthe ){
        super(sprite, labyrinthe);
        chargementImages();
        heros = (Heros) sprite;
    }

    public void chargementImages(){
    	Isprite = new Image("file:icons/link/LinkRunShieldD1.gif");
    }
    
    @Override
    public void handle(KeyEvent event) {
        
        switch(event.getCode()){
            case LEFT:
                heros.setPosition(new Salle(sprite.getPosition().getX()-1,sprite.getPosition().getY()));
                break;
            case RIGHT:
                heros.setPosition(new Salle(sprite.getPosition().getX()+1,sprite.getPosition().getY()));
                break;
            case UP:
                heros.setPosition(new Salle(sprite.getPosition().getX(),sprite.getPosition().getY()-1));
                break;
            case DOWN:
                heros.setPosition(new Salle(sprite.getPosition().getX(),sprite.getPosition().getY()+1));
                break;
            
        }
        heros.faitSonChoix(labyrinthe);
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
