package com.example.summerproject;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;

public class Map extends Pane {
    private final int UNIT=40;
    private int size;
    private int[][] map;
    private Position start;

    public Map(String s){
        String[] lines = s.split("\n");
        size=Integer.parseInt(String.valueOf(lines[0].charAt(lines[0].length()-1)));
        System.out.println(size);
        map = new int[size][size];
        //read from string and input to (int[][] map)
        for (int i = 0; i < size; i++) {
            String[] line = lines[i+1].split(" ");
            for (int j = 0; j < size; j++) {
               map[i][j]=Integer.parseInt(line[j]);
               if(map[i][j]==2){
                   start = new Position(j,i);
               }
            }
        }
        creatMapNode();
    }
    //method for add rectangles to map
    private void creatMapNode(){
        int height = size;
        for (int i = 0; i < height; i++) {
            int width = map[i].length;
            for (int j = 0; j < width; j++) {
                Rectangle rectangle = creatBlock(i, j, map[i][j]);
                getChildren().add(rectangle);
            }
        }
    }

    private Rectangle creatBlock(int i, int j, int x){
        Rectangle rectangle = new Rectangle(UNIT,UNIT);
        if(x==0 || x==2){
            rectangle.setFill(Color.WHITE);
        }
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);
        rectangle.setX(j*UNIT);
        rectangle.setY(i*UNIT);
        return rectangle;
    }

    public int getUNIT() {
        return UNIT;
    }

    public int getSize() {
        return size;
    }

    public int[][] getMap() {
        return map;
    }

    public int getValueAt(int x, int y){
        return map[y][x];
    }

    public Position getStartPosition(){
        return start;
    }
}
