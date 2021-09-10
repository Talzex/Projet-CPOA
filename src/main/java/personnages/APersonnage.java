/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import labyrinthe.ISalle;



/**
 *
 * @author tduthil
 */
public abstract class APersonnage implements IPersonnage {
    
    public ISalle position;
   @Override
    // renvoie sa position courante
    public ISalle getPosition(){
        return position;
    }
    
    @Override
    // definit sa position courante
    public void setPosition( ISalle s){
        position = s;
    }
    
}
