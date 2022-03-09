package edu.neumont.oop.Model;

public abstract class Player {
    private String name;

    public abstract CheckersBoard getMove(CheckersBoard board);

    private boolean isHuman;

    public Player(String name, boolean isHuman){
        this.name = name;
        this.isHuman = isHuman;
    }

    public boolean isHuman(){
        return isHuman;
    }

    public String getName(){
        return name;
    }

}
