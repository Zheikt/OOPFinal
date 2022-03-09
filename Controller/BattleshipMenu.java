package edu.neumont.oop.Controller;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import edu.neumont.oop.Model.BattleshipGameBoard;
import edu.neumont.oop.Model.BattleshipPlayer;

import java.lang.reflect.Array;
import java.util.Locale;
import java.util.Scanner;

public class BattleshipMenu  {
    private int shipCounter = 5;
    BattleshipGameBoard bsgb = new BattleshipGameBoard();
    int xPos;
    int yPos;
    int xDir;
    int yDir;
    int size;
    BattleshipPlayer testPlayer = new BattleshipPlayer("Tester");
    BattleshipPlayer testPlayer2 = new BattleshipPlayer("Tester 2");



    BattleshipPlayer bsp = new BattleshipPlayer("");

    public void BSIntroMenu(){
        System.out.println("Imagine. You're a naval commander in charge of your own fleet. Your enemy looms before you. Welcome to battleship." );
        System.out.println("///// \n" +
                "///// \n" +
                "///// ");
        BSMenu1();
    }


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

            //we could possibly show an empty board here
            System.out.println("Where would you like to place your ship on the board, including direction \n" +
                    "Ex. A5, Left");
            String responseString = scanner.nextLine().toLowerCase().trim();
            String pt1 = responseString.substring(0, 2).toLowerCase();
            String pt2 = responseString.substring(4).toLowerCase();

            if (pt1.contains("A")) {
                 yPos = 0;
            } else if (pt1.contains("B")) {
                 yPos = 1;
            } else if (pt1.contains("C")) {
                 yPos = 2;
            } else if (pt1.contains("D")) {
                 yPos = 3;
            } else if (pt1.contains("E")) {
                 yPos = 4;
            } else if (pt1.contains("F")) {
                 yPos = 5;
            } else if (pt1.contains("G")) {
                 yPos = 6;
            } else if (pt1.contains("H")) {
                 yPos = 7;
            } else if (pt1.contains("I")) {
                 yPos = 8;
            } else if (pt1.contains("J")) {
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
                if(shipCounter == 5){
                    size = 5;
                } else if(shipCounter == 4){
                    size = 4;
                }else if(shipCounter == 3){
                    size = 3;
                }else if(shipCounter == 2){
                    size = 3;
                }else if(shipCounter == 1){
                    size = 2;
                }
                shipCounter--;
                testPlayer.setShip(xPos,yPos,xDir,yDir,size);
                System.out.println(testPlayer.getShipBoard());




//            System.out.println(pt1);
//            System.out.println(pt2);



        }
        //from here the player is directed towards the integrated hit/miss menu, which checks for sunken ships, as well as accommodates for AIvsAI scenario
        new BattleshipGameplay(new BattleshipPlayer[]{testPlayer, testPlayer2}).gamePlayLoop();
//        if (scanner.nextLine().equalsIgnoreCase("A")){

//        }


    }
}
