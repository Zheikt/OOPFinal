package edu.neumont.oop.Controller;

import edu.neumont.oop.View.ConsoleIO;
import java.util.Scanner;


public class MainMenu{
    private ConsoleIO consoleIO = new ConsoleIO();
    BattleshipMenu bsMenu = new BattleshipMenu();
    private String Player1Name;
    private String Player2Name;

    public String getPlayer1Name() {
        return Player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        Player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return Player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        Player2Name = player2Name;
    }

    Scanner scanner = new Scanner(System.in);


    public void introduction(){
        consoleIO.printMessage("Welcome to the -VERY LARGE- Game collection! \n" +
                "We have plenty of games here, not limited to \n" +
                "Battleship and Checkers!");
        menu1();
    }
    public void menu1(){
        consoleIO.printMessage("First things first. Can I get your name?");
        String name1 = scanner.nextLine();
        setPlayer1Name(name1);
        consoleIO.printMessage("Thank you.");
        consoleIO.printMessage("////////////////////////////////////////////////////////////");
        consoleIO.printMessage("Next thing on the Agenda. How would you like to play today? We have a couple options for ya: \n" +
                "1. Player Vs Player \n" +
                "2. Player Vs AI \n" +
                "3. AI Vs AI \n");
        consoleIO.printMessage("You could also Exit by pressing 4, but that seems counterintuitive. Please respond with a Number 1 - 3 in regards to the above options.");
        int response = Integer.parseInt(scanner.nextLine());
        switch (response){
            case 1:
                consoleIO.printMessage("What is gonna be the name of player 2?");
                String name2 = scanner.nextLine();
                setPlayer2Name(name2);
                consoleIO.printMessage("Directing you to the game selection menu now...");
                menu2();
            case 2:
                consoleIO.printMessage("What do you want to call your computer opponent?");
                String AIName = scanner.nextLine();
                consoleIO.printMessage("Directing you to the game selection menu now...");
                menu2();
            case 3:
                consoleIO.printMessage("Since you will be spectating the coming game, what do you want to call the first AI?");
                String AI1Name = scanner.nextLine();
                consoleIO.printMessage("What will you call " + AI1Name + "'s opponent?");
                String AI2Name = scanner.nextLine();
                consoleIO.printMessage("Directing you to the game selection menu now...");
                menu2();
            case 4:
                consoleIO.printMessage("Okay buddy, whatever you want");
                break;

        }
    }

    public void menu2(){
        consoleIO.printMessage("////////////////////////////////////////////////////////////////////////////////////////////////////////////////// \n" +
                "WELCOME TO THE GAME SELECTION MENU!!! \n" +
                "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        consoleIO.printMessage("So, what would you like to choose? You can say 'Battleship' or 1 for Battleship and 'Checkers' or 2 for Checkers");
        consoleIO.printMessage("Please note, if you leave this space blank or put in anything else, we as the system will yell at you.");
        consoleIO.printMessage("You can also say exit, but that would exit the code without playing any games :(");
        String response = scanner.nextLine();
        if(response.equalsIgnoreCase("Battleship") || response.equalsIgnoreCase("1")) {
            bsMenu.BSIntroMenu();
        }
        else if(response.equalsIgnoreCase("Checkers") || response.equalsIgnoreCase("2")){
                //checkers menu goes here
        } else if(response.equalsIgnoreCase("")){
            consoleIO.printMessage("We told you not to leave that blank!");
            menu2();
        } else if(response.equalsIgnoreCase("Exit")){
            consoleIO.printMessage("Suit yourself. Goodbye!");
        } else {
            consoleIO.printMessage("We're not sure what you did, but it is wrong. Try again, bozo");
            menu2();
        }
    }
}
