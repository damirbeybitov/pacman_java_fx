package com.example.summerproject;

public class Position {
    private int x=0;
    private int y=0;
    public Position(int x, int y){
        setX(x); setY(y);
    }
    public Position() {

    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean equals(Position p){
        if(x==p.getX() && y==p.getY()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
}
