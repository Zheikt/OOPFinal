package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.BattleshipGameBoard;
import edu.neumont.oop.Model.BattleshipPlayer;
import edu.neumont.oop.Model.Token;

import java.util.Random;
import java.util.Scanner;

public class BattleshipGameplay {
    private BattleshipPlayer[] players;

    public BattleshipGameplay(BattleshipPlayer[] players){
        this.players = players;
    }

    public void gamePlayLoop(){
        int currentPlayer = -1; //For board coords, 0-9 char value 48 to 57, A-J char value 97 to 106 (lowercase)
        boolean gameOver = false;
        StringBuilder result = new StringBuilder();
        while(!gameOver) {
            result.delete(0, result.toString().length());
            currentPlayer = (currentPlayer == -1 ? (int)(Math.random() * 2) : (currentPlayer + 1) % 2);
            result.append(players[currentPlayer].isHuman() ? humanTurn(currentPlayer) : computerTurn(currentPlayer));
            checkForSunkShip(currentPlayer);
            result.append(players[currentPlayer].isHuman() ? "" : " Its board:\n" + players[currentPlayer].getGuessBoard());
            gameOver = checkForGameOver(players[currentPlayer]);

            System.out.println(result);
        }
        endGame(currentPlayer);
    }

    private void endGame(int winningPlayer){
        //most likely, do the PlayerIO stat updates here.
    }

    private String humanTurn(int currentPlayer){
        int[] targetPosition = {-1, -1};
        Scanner scanner = new Scanner(System.in);
        System.out.println(players[currentPlayer].getGuessBoard() + "\nIt is " + players[currentPlayer].getName() + " turn. Where would you like to fire? ");
        while(targetPosition[0] == -1) {
            String target = scanner.nextLine();
            targetPosition = validateTarget(target, players[currentPlayer]);
        }
        boolean hitResult = checkForHit(targetPosition, players[(currentPlayer + 1) % 2]);
        players[currentPlayer].getGuessBoard().setCell(targetPosition[0], targetPosition[1], new Token(hitResult ? "\u001B[38;5;196m" : "\u001B[38;5;255m"));
        return "Your shot was a " + (hitResult ? "Hit!" : "Miss.");

    }

    private String computerTurn(int currentPlayer){
        Random generator = new Random();
        int[] targetPosition = {-1, -1};
        while(targetPosition[0] == -1){
            String targetStr = "" + (char)(generator.nextInt(10) + 97) + (generator.nextInt(10) + 1);
            targetPosition = validateTarget(targetStr, players[currentPlayer]);
        }
        boolean hitResult = checkForHit(targetPosition, players[(currentPlayer + 1) % 2]);
        players[currentPlayer].getGuessBoard().setCell(targetPosition[0], targetPosition[1], new Token(hitResult ? "\u001B[38;5;196m" : "\u001B[38;5;255m"));
        return players[currentPlayer].getName() + "'s shot was a " + (hitResult ? "Hit!" : "Miss.");
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

    private boolean checkForHit(int[] target, BattleshipPlayer nonCurrentPlayer){
        return nonCurrentPlayer.getShipBoard().getCell(target[0], target[1]) != null;
    }

    private void checkForSunkShip(int currentPlayer){
        int otherPlayer = (currentPlayer + 1) % 2;
        for(int index = 0; index < players[otherPlayer].getFleet().length; index++) {
            Token[] markers = new Token[players[otherPlayer].getFleet()[index].getSize()];
            int hitAmount = 0;
            int placeInArray = 0;
            for (int[] locations : players[otherPlayer].getFleet()[index].getBoardLocations()) {
                markers[placeInArray] = players[currentPlayer].getGuessBoard().getCell(locations[0], locations[1]);
                if(markers[placeInArray] != null && markers[placeInArray].getColor().equals("\u001B[38;5;196m")){
                    hitAmount++;
                }
                placeInArray++;
            }
            if(hitAmount == players[otherPlayer].getFleet()[index].getSize()){
                for (Token marker : markers) {
                    try {
                        marker.setSymbol("X");
                    } catch (NullPointerException npe) {
                        System.out.println("wut");
                    }
                }
            }
        }
    }

    private boolean checkForGameOver(BattleshipPlayer currentPlayer){
        int amountOfHits = 0;
        Token[][] currentGuessBoard = currentPlayer.getGuessBoard().getBoard();
        for (Token[] row : currentGuessBoard) {
            for (Token piece : row) {
                if (piece != null && piece.getColor().equals("\u001B[38;5;196m")) {
                    amountOfHits++;
                }
            }
        }
        return amountOfHits == 17;
    }
}
