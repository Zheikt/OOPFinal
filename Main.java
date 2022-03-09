package edu.neumont.oop;

import edu.neumont.oop.Controller.CheckersMenu;
import edu.neumont.oop.Model.BattleshipGameBoard;
import edu.neumont.oop.Controller.BattleshipGameplay;
import edu.neumont.oop.Controller.MainMenu;
import edu.neumont.oop.Model.BattleshipPlayer;

public class Main {

    public static void main(String[] args) {

	CheckersMenu checkerStart = new CheckersMenu();
        //checkerStart.createBoard();
        //System.out.println(new BattleshipGameBoard());
        //System.out.println();
        //System.out.println("\033[41m \033[1;30m0\033[0m\033[41m \033[0m");
        //System.out.println(new BattleshipGameBoard());
        //System.out.println(new CheckersBoard());
        //Test Code for ship Placement
        MainMenu mMenu = new MainMenu();
        mMenu.introduction();
//        BattleshipPlayer testPlayer = new BattleshipPlayer("Tester", false);
//
//        testPlayer.setShip(0, 0, 0, 1, 5, "Carrier");
//        testPlayer.setShip(1, 1, 0, 1, 4, "Battleship");
//        testPlayer.setShip(2, 2, 0, 1, 3, "Cruiser");
//        testPlayer.setShip(3, 3, 0, 1, 3, "Submarine");
//        testPlayer.setShip(4, 4, 0, 1, 2, "Destroyer");
//
//        System.out.println(testPlayer.getShipBoard());
//
//        BattleshipPlayer testPlayer2 = new BattleshipPlayer("Test Subject 2", false);
//
//        testPlayer2.setShip(8, 2, 0, 1, 5, "Carrier");
//        testPlayer2.setShip(1, 1, 1, 0, 4, "Battleship");
//        testPlayer2.setShip(2, 2, 0, 1, 3, "Cruiser");
//        testPlayer2.setShip(9, 9, 0, -1, 3, "Submarine");
//        testPlayer2.setShip(4, 4, -1, 0, 2, "Destroyer");
//
//        System.out.println(testPlayer2.getShipBoard());
//
//        new BattleshipGameplay(new BattleshipPlayer[]{testPlayer, testPlayer2}).gamePlayLoop();
    }

}
