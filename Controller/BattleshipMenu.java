package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.BattleshipGameBoard;
import edu.neumont.oop.Model.BattleshipPlayer;

import java.util.Scanner;

public class BattleshipMenu{
    private static int shipCounter = 5;
    private static int shipCounter2 = 5;
    static MainMenu main = new MainMenu();

    BattleshipGameBoard bsgb = new BattleshipGameBoard();
    static int xPos;
    static int yPos;
    static int xDir;
    static int yDir;
    static int size;
    static BattleshipPlayer Player = new BattleshipPlayer(main.getPlayer1Name(), true);
    static BattleshipPlayer Player2 = new BattleshipPlayer(main.getPlayer2Name(), true);

    BattleshipPlayer bsp = new BattleshipPlayer(null, false);

    public static void BSIntroMenu(){
        System.out.println("Imagine. You're a naval commander in charge of your own fleet. Your enemy looms before you. Welcome to battleship." );
        System.out.println("///// \n" +
                "///// \n" +
                "///// ");
        BSMenuPlayer1();
    }


    public static void BSMenuPlayer1() {
        Scanner scanner = new Scanner(System.in);

        String[] ships = new String[5];



        //We would have to tweak this to run twice, once for each player.
        for (int i = 5; i > 0; i--) {

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

            //we could possibly show an empty board here

            if (pt1.contains("a")) {
                yPos = 0;
            } else if (pt1.contains("b")) {
                yPos = 1;
            } else if (pt1.contains("c")) {
                yPos = 2;
            } else if (pt1.contains("d")) {
                yPos = 3;
            } else if (pt1.contains("e")) {
                yPos = 4;
            } else if (pt1.contains("f")) {
                yPos = 5;
            } else if (pt1.contains("g")) {
                yPos = 6;
            } else if (pt1.contains("h")) {
                yPos = 7;
            } else if (pt1.contains("i")) {
                yPos = 8;
            } else if (pt1.contains("j")) {
                yPos = 9;
            }
            if (pt1.contains("1")) {
                xPos = 0;
            } else if (pt1.contains("2")) {
                xPos = 1;
            } else if (pt1.contains("3")) {
                xPos = 2;
            } else if (pt1.contains("4")) {
                xPos = 3;
            } else if (pt1.contains("5")) {
                xPos = 4;
            } else if (pt1.contains("6")) {
                xPos = 5;
            } else if (pt1.contains("7")) {
                xPos = 6;
            } else if (pt1.contains("8")) {
                xPos = 7;
            } else if (pt1.contains("9")) {
                xPos = 8;
            } else if (pt1.contains("10")) {
                xPos = 9;
            }
            if (pt2.equalsIgnoreCase("Left")) {
                xDir = -1;
                yDir = 0;
            } else if (pt2.equalsIgnoreCase("Right")) {
                xDir = 1;
                yDir = 0;
            } else if (pt2.equalsIgnoreCase("Down")) {
                yDir = 1;
                xDir = 0;
            } else if (pt2.equalsIgnoreCase("Up")) {
                yDir = -1;
                xDir = 0;
            }
            if (shipCounter == 5) {
                size = 5;
            } else if (shipCounter == 4) {
                size = 4;
            } else if (shipCounter == 3) {
                size = 3;
            } else if (shipCounter == 2) {
                size = 3;
            } else if (shipCounter == 1) {
                size = 2;
            }
            shipCounter--;
            Player.setShip(xPos, yPos, xDir, yDir, size, "Temp Name");
            System.out.println(Player.getShipBoard());
            BSMenuPlayer2();
        }
    }
        public static void BSMenuPlayer2(){
            Scanner scanner = new Scanner(System.in);

            //We would have to tweak this to run twice, once for each player.
            for (int i = 5; i > 0 ; i--) {

                System.out.println("You are now placing your ships. You have " + shipCounter2 + " ships left to place. \n" +
                        "Placement order: \n" +
                        "Carrier - 5 spots \n" +
                        "BattleShip - 4 spots \n" +
                        "Cruiser - 3 spots \n" +
                        "Submarine - 3 spots \n" +
                        "Destroyer - 2 spots");

                //we could possibly show an empty board here
                System.out.println("Where would you like to place your ship on the board, including direction \n" +
                        "Ex. A5, Left");
                String responseString = scanner.nextLine().toLowerCase().trim();
                String pt1 = responseString.substring(0, 3).toLowerCase();
                String pt2 = responseString.substring(4).toLowerCase();

                if (pt1.contains("a")) {
                    yPos = 0;
                } else if (pt1.contains("b")) {
                    yPos = 1;
                } else if (pt1.contains("c")) {
                    yPos = 2;
                } else if (pt1.contains("d")) {
                    yPos = 3;
                } else if (pt1.contains("e")) {
                    yPos = 4;
                } else if (pt1.contains("f")) {
                    yPos = 5;
                } else if (pt1.contains("g")) {
                    yPos = 6;
                } else if (pt1.contains("h")) {
                    yPos = 7;
                } else if (pt1.contains("i")) {
                    yPos = 8;
                } else if (pt1.contains("j")) {
                    yPos = 9;
                }
                if (pt1.contains("1")) {
                    xPos = 0;
                } else if (pt1.contains("2")) {
                    xPos = 1;
                } else if (pt1.contains("3")) {
                    xPos = 2;
                } else if (pt1.contains("4")) {
                    xPos = 3;
                } else if (pt1.contains("5")) {
                    xPos = 4;
                } else if (pt1.contains("6")) {
                    xPos = 5;
                } else if (pt1.contains("7")) {
                    xPos = 6;
                } else if (pt1.contains("8")) {
                    xPos = 7;
                } else if (pt1.contains("9")) {
                    xPos = 8;
                } else if (pt1.contains("10")){
                    xPos = 9;
                }
                if (pt2.equalsIgnoreCase("Left")){
                    xDir = -1;
                    yDir = 0;
                } else if (pt2.equalsIgnoreCase("Right")){
                    xDir = 1;
                    yDir = 0;
                } else if (pt2.equalsIgnoreCase("Down")){
                    yDir = 1;
                    xDir = 0;
                }else if (pt2.equalsIgnoreCase("Up")){
                    yDir = -1;
                    xDir = 0;
                }
                if(shipCounter2 == 5){
                    size = 5;
                } else if(shipCounter2 == 4){
                    size = 4;
                }else if(shipCounter2 == 3){
                    size = 3;
                }else if(shipCounter2 == 2){
                    size = 3;
                }else if(shipCounter2 == 1){
                    size = 2;
                }
                shipCounter2--;
                Player2.setShip(xPos,yPos,xDir,yDir,size, "TempName");
                System.out.println(Player2.getShipBoard());
                BSMenuPlayer1();
            }
        //from here the player is directed towards the integrated hit/miss menu, which checks for sunken ships, as well as accommodates for AIvsAI scenario
        new BattleshipGameplay(new BattleshipPlayer[]{Player, Player2}).gamePlayLoop();
    }
}
