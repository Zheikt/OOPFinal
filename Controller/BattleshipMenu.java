package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.BattleshipPlayer;
import edu.neumont.oop.View.ConsoleIO;

import java.util.Scanner;

public class BattleshipMenu{
    private ConsoleIO message = new ConsoleIO();

    private int shipCounter = 5;
    private int shipCounter2 = 5;


    private int xPos;
    private int yPos;
    private int xDir;
    private int yDir;
    private int size;
    private String name;
    BattleshipPlayer player;
    BattleshipPlayer player2;

    public BattleshipMenu(String player1Name, String player2Name, boolean player1IsHuman, boolean player2IsHuman){
        player = new BattleshipPlayer(player1Name, player1IsHuman);
        player2 = new BattleshipPlayer(player2Name, player2IsHuman);
        BSIntroMenu();
    }

    public void BSIntroMenu(){
        message.printMessage("Imagine. You're a naval commander in charge of your own fleet. Your enemy looms before you. Welcome to battleship. \n" );
        message.printMessage("///// \n" +
                "///// \n" +
                "///// \n ");
        BSMenuPlayer1();
    }


    public void BSMenuPlayer1() {
        Scanner scanner = new Scanner(System.in);

        //We would have to tweak this to run twice, once for each player.
        for (int i = 5; i > 0; i--) {

            message.printMessage("You are now placing your ships. You have " + shipCounter + " ships left to place. \n" +
                    "Placement order: \n" +
                    "Carrier - 5 spots \n" +
                    "BattleShip - 4 spots \n" +
                    "Cruiser - 3 spots \n" +
                    "Submarine - 3 spots \n" +
                    "Destroyer - 2 spots");
            shipCounter--;
            message.printMessage("Where would you like to place your ship on the board, including direction \n" +
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
                name = "Carrier";
            } else if (shipCounter == 4) {
                size = 4;
                name = "Battleship";
            } else if (shipCounter == 3) {
                size = 3;
                name = "Cruiser";
            } else if (shipCounter == 2) {
                size = 3;
                name = "Submarine";
            } else if (shipCounter == 1) {
                size = 2;
                name = "Destroyer";
            }
            shipCounter--;
            player.setShip(xPos, yPos, xDir, yDir, size, name);
            System.out.println(player.getShipBoard());
            BSMenuPlayer2();
        }
    }
        public void BSMenuPlayer2(){
            Scanner scanner = new Scanner(System.in);

            //We would have to tweak this to run twice, once for each player.
            for (int i = 5; i > 0 ; i--) {

                message.printMessage("You are now placing your ships. You have " + shipCounter2 + " ships left to place. \n" +
                        "Placement order: \n" +
                        "Carrier - 5 spots \n" +
                        "BattleShip - 4 spots \n" +
                        "Cruiser - 3 spots \n" +
                        "Submarine - 3 spots \n" +
                        "Destroyer - 2 spots");

                //we could possibly show an empty board here
                message.printMessage("Where would you like to place your ship on the board, including direction \n" +
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
                    name = "Carrier";
                } else if(shipCounter2 == 4){
                    size = 4;
                    name = "Battleship";
                }else if(shipCounter2 == 3){
                    size = 3;
                    name = "Cruiser";
                }else if(shipCounter2 == 2){
                    size = 3;
                    name = "Submarine";
                }else if(shipCounter2 == 1){
                    size = 2;
                    name = "Destroyer";
                }
                shipCounter2--;
                player2.setShip(xPos,yPos,xDir,yDir,size, name);
                System.out.println(player2.getShipBoard());
                BSMenuPlayer1();
            }
        //from here the player is directed towards the integrated hit/miss menu, which checks for sunken ships, as well as accommodates for AIvsAI scenario
        new BattleshipGameplay(new BattleshipPlayer[]{player, player2}).gamePlayLoop();
    }
}
