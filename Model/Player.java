package edu.neumont.oop.Model;

public abstract class Player {
    private String name;
    private Token token;

    public Player(String name){
        this.name = name;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getName(){
        return name;
    }
}
