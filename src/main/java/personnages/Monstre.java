/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import java.util.Random;
/**
 *
 * @author tduthil
 */
public class Monstre extends APersonnage{

    public ISalle salleAleatoire;
    Random rand = new Random();
    public Monstre(ISalle salle){
        this.position = salle;
 
    }
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
     return (ISalle)sallesAccessibles.toArray()[rand.nextInt(sallesAccessibles.size())];
    }
    
}
