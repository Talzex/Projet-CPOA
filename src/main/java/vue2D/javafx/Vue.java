package vue2D.javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {

    Dessin dessin;
    ILabyrinthe labyrinthe;
    public Scene scene;

    /**
     * Constructeur de la classe Vue
     * @param labyrinthe, le labyrinthe
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    /**
     * Méthode permettant de dessiner les différent éléments du labyrinthe
     */
    @Override
    public void dessiner() {
        // recopie du fond (image); murs + salles
        dessin.dessinLaby();
        for(ISprite s : this){
            s.dessiner(dessin.getGraphicsContext2D());
        }
    }

    /**
     * Méthode permettant d'associer le sprite avec la gestion de clavier
     * @param sprite, le sprite à associer
     * @return true quand c'est l'association est faite
     */
    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        // si le sprite est controle par le clavier
        if (sprite instanceof EventHandler) {
            System.out.println("registering keylistener");
            // association de l'ecouteur sur le clavier avec le composant graphique principal
            this.scene.setOnKeyPressed((EventHandler) sprite);
        }
        return true;
    }

}
