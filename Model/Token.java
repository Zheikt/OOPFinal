package edu.neumont.oop.Model;

public class Token { //This class should just be Token, shared with Checkers (in final)
    private String color;
    private String symbol;

    public Token(String color, String symbol){
        this.color = color;
        this.symbol = symbol;
    }

    public Token(String color){
        this(color, "0");
    }

    public String getColor(){
        return this.color;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return color + symbol;
    }
}
