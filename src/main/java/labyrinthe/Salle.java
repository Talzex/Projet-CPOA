/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

/**
 *
 * @author tduthil
 */
public class Salle implements ISalle{

    public int x;
    public int y;
    
    /**
     * Constructeur de Salle
     * @param x,abscisse
     * @param y,ordonnée
     */
    public Salle(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Retourne l'abscisse d'une Salle
     * @return x, l'abscisse
     */
    @Override
    public int getX() {
        return x;
    }
    
    /**
     * Retourne l'ordonnée d'une Salle
     * @return y, l'ordonnée
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Méthode permettant de vérifier si une ISalle est adjacente au personnage
     * @param autre, la salle a tester
     * @return true si autre est adjacente, faux sinon
     */
    @Override
    public boolean estAdjacente(ISalle autre) {
        return this.x == autre.getX() - 1 && this.y == autre.getY() ||
               this.x == autre.getX() + 1 && this.y == autre.getY() ||
               this.x == autre.getX() && this.y == autre.getY() - 1 ||
               this.x == autre.getX() && this.y == autre.getY() + 1;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
}
