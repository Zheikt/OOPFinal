package edu.neumont.oop.Model;

public class Token { //This class should just be Token, shared with Checkers (in final)
    private String color;

    public Token(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }
}
