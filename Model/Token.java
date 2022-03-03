package edu.neumont.oop.Model;

public class Token { //This class should just be Token, shared with Checkers (in final)
    private String backgroundColor = "";
    private String tokenColor = "";

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTokenColor() {
        return tokenColor;
    }

    public void setTokenColor(String tokenColor) {
        this.tokenColor = tokenColor;
        setBackgroundColor(getBackgroundColor().substring(9,10).replace(" ", tokenColor));
    }

    public Token(String color){
        this.backgroundColor = color;
    }
    }

