package edu.neumont.oop;

import edu.neumont.oop.Model.BattleshipGameBoard;
import edu.neumont.oop.Model.CheckersBoard;

public class Main {

    public static void main(String[] args) {
        CheckersBoard board = new CheckersBoard();
        board.initializeCheckersBoard();
        System.out.println(new BattleshipGameBoard());
        System.out.println(board);
        System.out.println("\033[41m \033[1;30m0\033[0m\033[41m \033[0m");
    }
}
