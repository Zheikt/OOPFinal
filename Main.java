package edu.neumont.oop;

import edu.neumont.oop.Controller.CheckersMenu;
import edu.neumont.oop.Model.BattleshipGameBoard;

public class Main {

    public static void main(String[] args) {
        CheckersMenu checkerStart = new CheckersMenu();
        checkerStart.createBoard();
        System.out.println(new BattleshipGameBoard());
        System.out.println();
        System.out.println("\033[41m \033[1;30m0\033[0m\033[41m \033[0m");
    }
}
