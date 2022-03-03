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
}
