package oop.game.Characters;

import javafx.scene.image.Image;
import oop.game.graphics.Sprite;

import java.util.Random;

public class Balloom extends Entity {

    private int animate;
    private int move;
    private boolean live = true;

    public Balloom(int x, int y, Image img) {
        super(x, y, img);
        setSpeed(5);
    }

    public void update() {
        MoveBalloom();
        animate++;
    }

    public void Move() {
        Random rand = new Random();
        while (live){
        move = rand.nextInt(4) + 1;
        }
    }
    public void MoveBalloom() {
        if(move == 1) {
            isUp();
        }
        if(move == 2) {
            isDown();
        }
        if(move == 3) {
            isLeft();
        }
        if(move == 4) {
            isRight();
        }
    }
    public void isUp() {
        y -= speed;
        img  = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, animate, 5).getFxImage();

    }

    public void isDown() {
        y += speed;
        img  = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, animate, 5).getFxImage();

    }

    public void isLeft() {
        x -= speed;
        img  = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, animate, 5).getFxImage();

    }

    public void isRight() {
        x += speed;
        img  = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, animate, 5).getFxImage();

    }
}