package edu.neumont.oop.Controller;

import java.util.Scanner;

public class MainMenu {
    BattleshipMenu baShipMenu = new BattleshipMenu();

    public void introduction(){
        System.out.println("Welcome to the -VERY LARGE- Game collection! \n" +
                "We have plenty of games here, not limited to \n" +
                "Battleship!.... \n" +
                "and Checkers!");
        menu();
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("So, what would you like to choose? You can say 'Battleship' or 1 for Battleship, or 'Checkers' or 2 for Checkers");
        System.out.println("Please note, if you leave this space blank or put in anything else, we as the system will yell at you.");
        System.out.println("You can also say exit, but that would exit the code without playing any games :(");
        String response = scanner.nextLine();
        if(response.equalsIgnoreCase("Battleship") || response.equalsIgnoreCase("1")) {
            baShipMenu.BSMenu1();
        }
        else if(response.equalsIgnoreCase("Checkers") || response.equalsIgnoreCase("2")){
                //checkers menu goes here
        } else if(response.equalsIgnoreCase("")){
            System.out.println("We told you not to leave that blank!");
            menu();
        } else if(response.equalsIgnoreCase("Exit")){
            System.out.println("Suit yourself. Goodbye!");
            return;
        }
    }
}
