package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.BattleshipPlayer;

import java.util.Scanner;

public class BattleshipGameplay {
    private BattleshipPlayer[] players;

    public BattleshipGameplay(BattleshipPlayer[] players){
        this.players = players;
    }

    public void gamePlayLoop(){
        Scanner scanner = new Scanner(System.in);
        int currentPlayer = 0; //For board coords, 0-9 char value 48 to 57, A-J char value 97 to 106 (lowercase)
        int[] targetPosition;
        boolean loopKey = true;
        while(loopKey) {
            System.out.println( players[currentPlayer].getGuessBoard() + "\nIt is " + players[currentPlayer].getName() + " turn. Where would you like to fire? ");
            String target = scanner.nextLine();
            targetPosition = validateTarget(target, players[currentPlayer]);
            if (targetPosition[0] > -1) {
                String hitResult = checkForHit(targetPosition, players[(currentPlayer + 1) % 2]);
                System.out.println("Your shot was a " + hitResult);
                loopKey = false;
            }
        }
    }

    private int[] validateTarget(String targetStr, BattleshipPlayer currentPlayer){
        int[] targetPosition = new int[] {-1,-1}; //always store in form (xPos, yPos) - (equivalent to column, row)
        if(targetStr == null || targetStr.trim().isEmpty()){
            System.out.println("Target string cannot be null, empty, or all whitespaces.");
            return targetPosition;
        }
        char targetLetter = targetStr.toLowerCase().trim().charAt(0);
        String targetNumberStr = targetStr.trim().substring(1);
        //Check to make sure there is a number in the string
        if((!targetNumberStr.equals("10") && targetNumberStr.length() > 1) || targetNumberStr.charAt(0) < '1' || targetNumberStr.charAt(0) > '9' || (targetLetter < 'a' || targetLetter > 'j')){
            System.out.println("Invalid target string. Must only contain a letter a-j and a number 1-10");
            return targetPosition;
        }

        char rowNum = (char) (targetLetter - 49);

        targetPosition[0] = Integer.parseInt(targetNumberStr) - 1;
        targetPosition[1] = Integer.parseInt("" + rowNum);

        if(currentPlayer.getGuessBoard().getCell(targetPosition[0], targetPosition[1]) != null){
            System.out.println("That area has already been targeted. Please choose a different spot.");
            targetPosition[0] = -1;
            return targetPosition;
        }

        return targetPosition;
    }

    private String checkForHit(int[] target, BattleshipPlayer nonCurrentPlayer){
        return nonCurrentPlayer.getShipBoard().getCell(target[0], target[1]) != null ? "Hit!" : "Miss.";
    }
}
