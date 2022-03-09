package edu.neumont.oop.Model;

public class Ship{
    private String type;










    private int size;
    private int[][] boardLocations; //Store each location

    public Ship(String type, int size, int[][] boardLocations){
        this.type = type;
        this.size = size;
        this.boardLocations = boardLocations;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getBoardLocations() {
        return boardLocations;
    }

    public void setBoardLocations(int[][] boardLocations) {
        this.boardLocations = boardLocations;
    }

}
