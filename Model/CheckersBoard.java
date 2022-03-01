package edu.neumont.oop.Model;

public class CheckersBoard extends GameBoard{

    public CheckersBoard(){
        super(8,4);
    }

    @Override
    public String boardString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < super.getBoard().length; row++) {
            for (Token token : super.getBoard()[row]) {
                if(row % 2 == 0){
                    builder.append("\u001B[48;5;196m   ");
                }
                builder.append("\u001B[48;5;0m   ").append(token == null ? "" : (token.getColor() + "0\u001B[0m\u001B[48;5;0m"));
                if(row % 2 != 0){
                    builder.append("\u001B[48;5;196m   ");
                }
            }
            builder.append("\u001B[0m\n");
        }

        return builder.toString();
    }
}
