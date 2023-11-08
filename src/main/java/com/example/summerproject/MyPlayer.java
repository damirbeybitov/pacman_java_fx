package com.example.summerproject;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyPlayer implements Player {
    private Circle ball;
    private Map map;
    private Position position;

    public MyPlayer(Map map){
        this.map=map;
        ball = new Circle(20);
        ball.setFill(Color.RED);
        position=map.getStartPosition();
    }

    public Circle getBall() {
        return ball;
    }

    @Override
    public void moveRight(){
        int maxSize=map.getMap()[position.getY()].length;
        if(position.getX()<maxSize-1 && map.getValueAt(position.getX()+1, position.getY())!=1){
            position.setX(position.getX()+1);
        }else {
            System.out.println("Invalid position!");
        }
    }

    @Override
    public void moveLeft() {
        if(position.getX()>0 && map.getValueAt(position.getX()-1, position.getY())!=1){
            position.setX(position.getX()-1);
        }else {
            System.out.println("Invalid position!");
        }
    }

    @Override
    public void moveUp() {
        if(position.getY()>0 && map.getValueAt(position.getX(), position.getY()-1)!=1){
            position.setY(position.getY()-1);
        }else {
            System.out.println("Invalid position!");
        }
    }

    @Override
    public void moveDown() {
        int maxSize=map.getMap().length;
        if(position.getY()<maxSize-1 && map.getValueAt(position.getX(), position.getY()+1)!=1){
            position.setY(position.getY()+1);
        }else {
            System.out.println("Invalid position!");
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

}
