package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import vue2D.IVue;
import vue2D.sprites.HerosSprite;
import vue2D.sprites.ISprite;
import vue2D.sprites.MonstreSprite;

/**
 *
 * @author INFO Professors team
 */
public class Core {

    ISprite heros;
    ISprite monstre;
    ArrayList<ISprite> personnages = new ArrayList<>();
    ILabyrinthe labyrinthe;

    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
        chargementLaby("labys/level3.txt");
    }

    protected void initSprites(IVue vue) {
        // creation du heros 
        IPersonnage h = new personnages.Heros(labyrinthe.getEntree());
        this.heros = new HerosSprite(h, labyrinthe);
        vue.add(this.heros);
        personnages.add(heros);
        for (int i = 0; i < 10; i++) {
            IPersonnage m = new personnages.Monstre(labyrinthe.getSortie());
            this.monstre = new MonstreSprite(m, labyrinthe);
            personnages.add(monstre);
            vue.add(this.monstre);
        }

    }

    protected void jeu(IVue vue) {
        // boucle principale
        ISalle destination = null;
        int nbTour = 0;
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // choix et deplacement
            for (IPersonnage p : vue) {
                ISprite p2 = (ISprite) p;
                boolean enMouv = false;
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(p);
                destination = p.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                
                if(!destination.equals(p.getPosition())){
                    enMouv = true;
                }
                if (enMouv) {
                    int unite = 15;
                    int xdiff = p.getPosition().getX() - destination.getX();
                    int ydiff = p.getPosition().getY() - destination.getY();
                    
                    if (ydiff < 0) {
                        p2.setCoordonnees(0, 1);
                        nbTour++;
                    }
                    
                    if (ydiff > 0) {
                        p2.setCoordonnees(0, -1);
                        nbTour++;
                    }
                    
                    if (xdiff < 0){
                        p2.setCoordonnees(1, 0);
                        nbTour++;
                    }
                    
                    if (xdiff > 0){
                        p2.setCoordonnees(-1, 0);
                        nbTour++;
                    }
                    
                    if (nbTour >= unite) {
                        enMouv = false;
                        p.setPosition(destination);
                        nbTour = 0;
                    }
                }
            }
            // detection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite p : vue) {
                if (p != heros) {
                    if (p.getPosition() == heros.getPosition()) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = p;
                    }
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
            }

            temporisation(50);
        }
        System.out.println("Gagné!");
    }

    private void chargementLaby(String fic) {
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
}
