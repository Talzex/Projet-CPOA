/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author tduthil
 */
public class Heros extends APersonnage {

    public ISalle salleChoisie;

    /**
     * Constructeur de la classe Heros
     * @param salle, la salle où se trouve le héros
     */
    public Heros(ISalle salle){
        this.position = salle;
 
    }

    /**
     * Méthode permettant de vérifier si la salle souhaitée par le joueur est
     * bien accessible
     * @param sallesAccessibles, la collection des sallesAccessibles pour le héros
     * @return la salleChoisie si elle est accessible, sinon la position du héros
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (sallesAccessibles.contains(salleChoisie)) {
            return salleChoisie;
        } else {
            return this.getPosition();
        }

    }
}
