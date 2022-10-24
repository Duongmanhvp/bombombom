package oop.game.items;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import oop.game.Characters.Bomber;
import oop.game.Characters.Entity;
import oop.game.graphics.Sprite;

import static oop.game.BombermanGame.bomberman;
import static oop.game.BombermanGame.scene;
import static oop.game.Characters.Bomber.bombs;
import static oop.game.graphics.Sprite.SCALED_SIZE;


public class Bomb extends Entity {

    private static int maxBomb = 1;
    public static boolean hasBomb ;
    private int animate = 0;
    private int radius ;
    public Bomb() {
    }
    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }
    public Bomb(int x, int y, Image img, int radius) {
        super(x,y,img);
        this.radius = radius;
    }

    public static void setBomb() {
        int xB = (bomberman.getX() + 8) / SCALED_SIZE;
        int yB = (bomberman.getY() + 8) / SCALED_SIZE ;

        for (Bomb bomb : bombs) {
            if (xB * SCALED_SIZE == bomb.getX() && yB * SCALED_SIZE == bomb.getY()) {
                return;
            }
        }
        if (bombs.size() < maxBomb ) {
            bombs.add(new Bomb(xB, yB, Sprite.bomb.getFxImage()));
        }

        System.out.println("B");
    }

    public void updateEx() {
        Flame f = new Flame(x, y);
        f.setRadius(radius);
        f.renderExplosion();
    }
    public void update() {
        img  = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, animate, 15).getFxImage();
        if (bombs.size() >= maxBomb ) {
            hasBomb = false;
        }
        if (animate++ == 120) {
             bombs.remove(this);
        }

        updateEx();
    }

}
