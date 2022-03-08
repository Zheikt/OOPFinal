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

    BattleshipPlayer bsp = new BattleshipPlayer(null, false);


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
            shipCounter--;
            //we could possibly show an empty board here
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


    }
}
