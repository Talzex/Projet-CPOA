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
    Random rand = new Random();
    
    /**
     * Constructeur de la classe Monstre
     * @param salle, la salle où se trouve le héros
     */
    public Monstre(ISalle salle){
        this.position = salle;
 
    }

    /**
     * Méthode permettant de tirer aléatoirement une ISalle pour un monstre,
     * elle représente le "choix" du monstre
     * @param sallesAccessibles, la collection des salles Accessibles
     * @return une ISalle aléatoire accessible pour le monstre
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
     return (ISalle)sallesAccessibles.toArray()[rand.nextInt(sallesAccessibles.size())];
    }
    
}
