package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.BattleshipPlayer;
import edu.neumont.oop.View.ConsoleIO;

import java.util.Scanner;

public class BattleshipMenu{
    private ConsoleIO message = new ConsoleIO();

    private int shipCounter = 5;
    private int shipCounter2 = 5;


    private int xPos = -1;
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
        //We would have to tweak this to run twice, once for each player.
        for (int i = 5; i > 0; i--) {

            message.printMessage(player.getName() + ", you are now placing your ships. You have " + shipCounter + " ships left to place. \n" +
                    "Placement order: \n" +
                    "Carrier - 5 spots \n" +
                    "BattleShip - 4 spots \n" +
                    "Cruiser - 3 spots \n" +
                    "Submarine - 3 spots \n" +
                    "Destroyer - 2 spots");
            //shipCounter--;
            String pt2 = "";
            while(xPos == -1) {
                message.printMessage("\nWhere would you like to place your ship on the board, including direction " +
                        "Ex. A5, Left\n");
                String responseString = message.getString().toLowerCase();
                String pt1 = responseString.substring(0, 2);
                pt2 = responseString.substring(responseString.indexOf(" ") + 1);

                //we could possibly show an empty board here

                int[] placementLoc = message.getAlphaNumericCoords('a', 'j', '1', '9', "10", true, pt1);
                yPos = placementLoc[1];
                xPos = placementLoc[0];
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

            player.setShip(xPos, yPos, xDir, yDir, size, name);
            message.printMessage(player.getShipBoard().toString());
            shipCounter--;
            xPos = -1;

        }
        BSMenuPlayer2();
    }
        public void BSMenuPlayer2(){

            //We would have to tweak this to run twice, once for each player.
            for (int i = 5; i > 0 ; i--) {

                message.printMessage(player2.getName() + ", you are now placing your ships. You have " + shipCounter2 + " ships left to place. \n" +
                        "Placement order: \n" +
                        "Carrier - 5 spots \n" +
                        "BattleShip - 4 spots \n" +
                        "Cruiser - 3 spots \n" +
                        "Submarine - 3 spots \n" +
                        "Destroyer - 2 spots");

                //we could possibly show an empty board here
                String pt2 = "";
                while(xPos == -1) {
                    message.printMessage("\nWhere would you like to place your ship on the board, including direction " +
                            "Ex. A5, Left\n");
                    String responseString = message.getString().toLowerCase();
                    String pt1 = responseString.substring(0, 2);
                    pt2 = responseString.substring(responseString.indexOf(" ") + 1);

                    int[] placementLoc = message.getAlphaNumericCoords('a', 'j', '1', '9', "10", true, pt1);
                    yPos = placementLoc[1];
                    xPos = placementLoc[0];
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

                player2.setShip(xPos,yPos,xDir,yDir,size, name);
                message.printMessage(player2.getShipBoard().toString());
                shipCounter2--;
                xPos = -1;
                //BSMenuPlayer1();
            }
        //from here the player is directed towards the integrated hit/miss menu, which checks for sunken ships, as well as accommodates for AIvsAI scenario
        new BattleshipGameplay(new BattleshipPlayer[]{player, player2}).gamePlayLoop();
    }
}
