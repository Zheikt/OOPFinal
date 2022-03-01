package edu.neumont.oop.Model;

public class BattleshipGameBoard extends GameBoard{

    public BattleshipGameBoard(){
        super(10,10);
        //getBoard()[2][9] = new Token("\u001B[38;5;196m");
        //getBoard()[4][6] = new Token("\u001B[38;5;255m");
    }

    @Override
    public String boardString() {
        StringBuilder builder = new StringBuilder();

        for (Token[] row: super.getBoard()) {
            for (Token token : row) {
                builder.append("\u001B[48;5;18m").append(token == null ? " ~ " : (token.getColor() + " 0 \u001B[0m"));
            }
            builder.append("\u001B[0m\n");
        }

        return builder.toString();
    }
}
