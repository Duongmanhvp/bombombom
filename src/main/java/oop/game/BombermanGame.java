package oop.game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;

import oop.game.graphics.Map;
import oop.game.Characters.Entity;
import oop.game.graphics.Sprite;
import oop.game.items.Bomb;
import oop.game.items.Flame;

import java.util.ArrayList;
import java.util.List;

import static oop.game.Characters.Bomber.bombs;


public class BombermanGame extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static List<Flame> flames = new ArrayList<>();

    private GraphicsContext gc;
    private Canvas canvas;
    public static  List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static Entity bomberman;
    public static Scene scene;
    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("BOMBERMAN");

        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        run();
    }

    public void run() {
        AnimationTimer gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                render();
                update();
            }
        };
        gameTimer.start();
        new Map("res/view/level1");
    }


    public void update() {
        entities.forEach(Entity::update);
        for(Bomb bomb : bombs  ) {
            bomb.update();
        }
        for(Flame flame : flames) {
            flame.update();
        }

    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        for(Bomb bomb : bombs  ) {
            bomb.render(gc);
        }
        bomberman.render(gc);
        flames.forEach(g -> g.render(gc));
    }
}
