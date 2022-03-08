package edu.neumont.oop.Model;

public abstract class Player {
    private String name;
    public abstract CheckersBoard getMove(CheckersBoard board);
}
