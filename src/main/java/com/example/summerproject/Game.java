package com.example.summerproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Game extends Application {
    private Map map;
    private MyPlayer player;
    private Food food;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Scan from cmd
        Scanner sc = new Scanner(System.in);
//        String name = sc.nextLine(); // Map.txt


        readFromTxt("Map.txt");

        // Main pane
        Pane pane = new Pane();

        // add map to main pane
        pane.getChildren().add(map);

        // creat a new player
        player = new MyPlayer(map);

        //move player to start position
        playerMoveTo();

        // creat Food class
        food = new Food(map, player);

        // input a player to main pane
        pane.getChildren().add(player.getBall());

        Scene scene = new Scene(pane,500,500);

        // key listener for player
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case UP: player.moveUp();playerMoveTo();break;
                    case DOWN: player.moveDown();playerMoveTo();break;
                    case RIGHT: player.moveRight();playerMoveTo();break;
                    case LEFT: player.moveLeft();playerMoveTo();break;
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("PacMan");
        primaryStage.show();
    }
    // method for move player
    private void playerMoveTo(){
        player.getBall().setCenterX(20+(40*player.getPosition().getX()));
        player.getBall().setCenterY(20+(40*player.getPosition().getY()));
    }
    //methid for read from txt and convert it to String
    private void readFromTxt(String name) throws IOException {
        BufferedReader br = null;
        String stringMap = name;
        int height = 0;
        int width = 0;
        try {
            br = new BufferedReader(new FileReader(name));
            String line;
            while ((line = br.readLine()) != null) {
                stringMap += line + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
        }
        map = new Map(stringMap);
    }
}
