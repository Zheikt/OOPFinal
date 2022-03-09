package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.BattleshipGameBoard;
import edu.neumont.oop.Model.BattleshipPlayer;
import edu.neumont.oop.Model.Token;
import edu.neumont.oop.View.ConsoleIO;

import java.util.Random;
import java.util.Scanner;

public class BattleshipGameplay {
    private BattleshipPlayer[] players;
    private ConsoleIO consoleIO = new ConsoleIO();

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
            String sunkMessage = checkForSunkShip(currentPlayer);
            result.append(sunkMessage.isEmpty() ? "" : " " + sunkMessage + ".");
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
        consoleIO.printMessage(players[currentPlayer].getGuessBoard() + "\nIt is " + players[currentPlayer].getName() + " turn.");
        while(targetPosition[0] == -1) {
            targetPosition = validateTarget(players[currentPlayer]);
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
            targetPosition[0] = Integer.parseInt(targetStr.substring(1)) - 1;
            targetPosition[1] = Integer.parseInt("" + ((char)(targetStr.charAt(0) - 49)));
            if (players[currentPlayer].getGuessBoard().getCell(targetPosition[0], targetPosition[1]) != null) {
                targetPosition[0] = -1;
            }
        }
        boolean hitResult = checkForHit(targetPosition, players[(currentPlayer + 1) % 2]);
        players[currentPlayer].getGuessBoard().setCell(targetPosition[0], targetPosition[1], new Token(hitResult ? "\u001B[38;5;196m" : "\u001B[38;5;255m"));
        return players[currentPlayer].getName() + "'s shot was a " + (hitResult ? "Hit!" : "Miss.");
    }

    private int[] validateTarget(BattleshipPlayer currentPlayer){
        int[] targetPosition = new int[] {-1,-1};
        while(targetPosition[0] == -1) {
            targetPosition = consoleIO.getAlphaNumericCoords("\nWhere would you like to fire?", 'a', 'j',
                    '1', '9', "10", true); //always store in form (xPos, yPos) - (equivalent to column, row)

            if (currentPlayer.getGuessBoard().getCell(targetPosition[0], targetPosition[1]) != null) {
                consoleIO.printMessage("That area has already been targeted. Please choose a different spot.");
                targetPosition[0] = -1;
            }
        }

        return targetPosition;
    }

    private boolean checkForHit(int[] target, BattleshipPlayer nonCurrentPlayer){
        return nonCurrentPlayer.getShipBoard().getCell(target[0], target[1]) != null;
    }

    private String checkForSunkShip(int currentPlayer){
        int otherPlayer = (currentPlayer + 1) % 2;
        String message = "";
        for(int index = 0; index < players[otherPlayer].getFleet().length; index++) {
            Token[] markers = new Token[players[otherPlayer].getFleet()[index].getSize()];
            int hitAmount = 0;
            int placeInArray = 0;
            for (int[] locations : players[otherPlayer].getFleet()[index].getBoardLocations()) {
                markers[placeInArray] = players[currentPlayer].getGuessBoard().getCell(locations[0], locations[1]);
                if(markers[placeInArray] != null && markers[placeInArray].toString().equals("\u001B[38;5;196m0")){
                    hitAmount++;
                }
                placeInArray++;
            }
            if(hitAmount == players[otherPlayer].getFleet()[index].getSize()){
                for (Token marker : markers) {
                    marker.setSymbol("X");
                }
                message = players[currentPlayer].getName() + " sunk " + players[otherPlayer].getName() + "'s " + players[otherPlayer].getFleet()[index].getType();
            }
        }
        return message;
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
