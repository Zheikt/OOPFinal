package edu.neumont.oop.Model;

public class CheckersBoard extends GameBoard{

    public CheckersBoard(){
        super(8,8);
    }

    public void initializeCheckersBoard()
    {
        for (int row = 0; row < super.getBoard().length; row++) {
            for (int token = 0; token < super.getBoard()[row].length; token++) {
                if (row % 2 == 0){
                    super.getBoard()[row][token].setBackgroundColor(token % 2 == 1 ? ((row < 3) ? "\033[40m 0 \033[0m" : ((row == 6) ? "\033[40m \033[1;31m0\033[0m\033[40m \033[0m" : "\033[40m   \033[0m")) : "\033[41m   \033[0m");
                }
                if (row % 2 == 1)
                {
                    super.getBoard()[row][token].setBackgroundColor(token % 2 == 0 ? ((row > 4) ? "\033[40m \033[1;31m0\033[0m\033[40m \033[0m" : ((row == 1) ? "\033[40m 0 \033[0m" : "\033[40m   \033[0m")) : "\033[41m   \033[0m");
                }
            }
        }
    }

    @Override
    public String boardString() {
        String board = "";
        for (int row = 0; row < super.getBoard().length; row++) {
            for (int token = 0; token < super.getBoard()[row].length; token++) {
                board += super.getBoard()[row][token].getBackgroundColor();
               }
            board += "\n";
        }
        return board;
    }

}
