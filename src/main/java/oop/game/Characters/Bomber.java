package oop.game.Characters;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import oop.game.graphics.Sprite;
import oop.game.items.Bomb;
import oop.game.items.Flame;

import java.util.ArrayList;
import java.util.List;

import static oop.game.BombermanGame.scene;
import static oop.game.items.Bomb.hasBomb;

public class Bomber extends Entity {

    public static List<Bomb> bombs = new ArrayList<>();
    public static List<Flame> flames = new ArrayList<>();
    private int animate = 0;
    private boolean move;

    private KeyCode Key;
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
        setSpeed(10);
    }

    public void update () {
        MoveBomber();
        //putBomb();
//        if (move) {
//            if(Key == KeyCode.UP) {
//                isUp();
//            }
//            if(Key == KeyCode.DOWN) {
//                isDown();
//            }
//            if(Key == KeyCode.LEFT) {
//                isLeft();
//            }
//            if(Key == KeyCode.RIGHT) {
//                isRight();
//            }
//        }
        if (hasBomb) {
            Bomb.setBomb();
        }
        if(animate++ < 100){
            MoveBomber();
        }
        else {
            animate = 0;
        }
    }

    public void isUp() {
        y -= speed;
        img  = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 5).getFxImage();

    }

    public void isDown() {
        y += speed;
        img  = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 5).getFxImage();

    }

    public void isLeft() {
        x -= speed;
        img  = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 5).getFxImage();

    }

    public void isRight() {
        x += speed;
        img  = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animate, 5).getFxImage();

    }



   /* public void putBomb() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.SPACE) {
                    Bomb.setBomb();
                }
            }
        });
    }


    */
    public void MoveBomber() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.UP){
                    isUp();
                } else if(event.getCode() == KeyCode.DOWN) {
                    isDown();
                } else if(event.getCode() == KeyCode.LEFT) {
                    isLeft();
                } else if(event.getCode() == KeyCode.RIGHT) {
                    isRight();
                } else if(event.getCode() == KeyCode.SPACE) {
                    hasBomb = true;
                }

        }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                 if(event.getCode() == KeyCode.UP){
                     //isUp();
                     move = false;
                     img = Sprite.player_up.getFxImage();
                 } else if(event.getCode() == KeyCode.DOWN) {
                     move = false;
                     img = Sprite.player_down.getFxImage();
                     //isDown();
                 } else if(event.getCode() == KeyCode.LEFT) {
                     move = false;
                     img = Sprite.player_left.getFxImage();
                     //isLeft();
                 } else if(event.getCode() == KeyCode.RIGHT) {
                     move = false;
                     img = Sprite.player_right.getFxImage();
                      //isRight();
                 } else if (event.getCode() == KeyCode.SPACE) {
                     hasBomb = false;
                 }
            }
        });
    }}

