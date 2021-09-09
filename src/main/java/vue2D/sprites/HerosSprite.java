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

/**
 *
 * @author tduthil
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {
    public ILabyrinthe labyrinthe;
    public IPersonnage Hsprite;
    private Image heros;
    
    public HerosSprite(IPersonnage Hsprite,ILabyrinthe labyrinthe ){
        super(Hsprite, labyrinthe);
        chargementImages();
    }

    public void chargementImages(){
    	heros = new Image("file:icons/link/LinkRunShieldL1.gif");
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

    @Override
    public void handle(KeyEvent arg0) {
        
    }
}
