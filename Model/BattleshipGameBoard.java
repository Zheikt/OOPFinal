package edu.neumont.oop.Model;

public class BattleshipGameBoard extends GameBoard{

    public BattleshipGameBoard(){
        super(10,10);
    }

    @Override
    public String boardString() {
        StringBuilder builder = new StringBuilder("   1  2  3  4  5  6  7  8  9  10\n");

        for (int row = 0; row < super.getBoard().length; row++) {
            builder.append((char)(row + 65)).append(" "); //Appends capital letter A through J based on their char value (65 to 74)
            for (Token token : super.getBoard()[row]) {
                builder.append("\u001B[48;5;18m").append(token == null ? "\u001B[38;5;27m ~ " : (" " + token + " \u001B[0m"));
            }
            builder.append("\u001B[0m\n");
        }

        return builder.toString();
    }
}
