package edu.neumont.oop.Controller;

import java.util.Scanner;

public class BattleshipMenu {
<<<<<<< HEAD

    public void BSmenu1(){
        //System.out.println("Welcome to battleship! what would you like to do? \n 1. Player vs. Player \n 2. Player vs. Ai \n 3. AI vs. AI \n 4. Exit");
=======
    private int shipCounter = 5;

    BattleshipPlayer bsp = new BattleshipPlayer(null, false);

    public void BSMenu1(){
        Scanner scanner = new Scanner(System.in);

        String[] ships = new String[5];



        for (int i = 5; i > 0 ; i--) {

            System.out.println("You are now placing your ships. You have " + shipCounter + " ships left to place. \n" +
                    "Placement order: \n" +
                    "Carrier - 5 spots \n" +
                    "BattleShip - 4 spots \n" +
                    "Cruiser - 3 spots \n" +
                    "Submarine - 3 spots \n" +
                    "Destroyer - 2 spots");
            shipCounter--;
            System.out.println("Where would you like to place your ship on the board, including direction \n" +
                    "Ex. A5, Left");
            String responseString = scanner.nextLine().toLowerCase().trim();
            String pt1 = responseString.substring(0,2).toLowerCase();
            String pt2 = responseString.substring(4).toLowerCase();




//            System.out.println(pt1);
//            System.out.println(pt2);



        }
//        if (scanner.nextLine().equalsIgnoreCase("A")){
//
//        }


>>>>>>> Updated_Checkers
    }
}
