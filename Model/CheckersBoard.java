package edu.neumont.oop.Model;

public class CheckersBoard extends GameBoard{

    public CheckersBoard(){
        super(8,8);
    }

    @Override
    public String boardString() {
        StringBuilder builder = new StringBuilder();

        String[] backgroundColors  = new String [] {"\u001B[48;5;196m", "\u001B[48;5;0m"};
        String color;

        for (int row = 0; row < super.getBoard().length; row++) {
            for (int token = 0; token < super.getBoard()[row].length; token++) {
                color = backgroundColors[(token + row) % 2];

                builder.append(color).append(super.getBoard()[row][token] == null ? "   " : (super.getBoard()[row][token].getColor() + " 0 \u001B[0m"));
            }
            builder.append("\u001B[0m\n");
        }

        return builder.toString();
    }
}
