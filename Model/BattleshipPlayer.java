package edu.neumont.oop.Model;

import edu.neumont.oop.View.ConsoleIO;

public class BattleshipPlayer extends Player{
    private BattleshipGameBoard shipBoard;
    private BattleshipGameBoard guessBoard;
    private Ship[] fleet; //Maybe use this to store their Ships?

    @Override
    public CheckersBoard getMove(CheckersBoard board) {
        return null; //This needs to get changed
    }

    public BattleshipPlayer(String name, boolean isHuman) {
        super(name, isHuman);
        shipBoard = new BattleshipGameBoard();
        guessBoard = new BattleshipGameBoard();
        fleet = new Ship[5];
    }

    //Maybe this should be in the class that sets up the Battleship Game
    public void setShip(int xPos, int yPos, int xDir, int yDir, int size, String name) throws IllegalArgumentException{ //Maybe this should be part of a Controller? Some error handling can be taken care of in a View when getting the info
        //Maybe change this to be recursive so that it checks each space as it goes to ensure it doesn't overlap with another ship
        if(xDir != 0 && yDir != 0){
            throw new IllegalArgumentException("Ship cannot be placed diagonally. X-Direction or Y-Direction must be 0. X-Dir: " + xDir + " Y-Dir: " + yDir);
        }

        if(yPos < 0 || yPos >= shipBoard.getBoard().length){
            throw new IllegalArgumentException("Illegal y-position. Must be between 0 and " + (shipBoard.getBoard().length - 1) + ". Y-Position: " + xPos);
        }

        if(xPos < 0 || xPos >= shipBoard.getBoard()[yPos].length){
            throw new IllegalArgumentException("Illegal x-position. Must be between 0 and " + (shipBoard.getBoard()[yPos].length - 1) + ". X-Position: " + xPos);
        }

        if(xPos + (xDir * size) < 0 || xPos + (xDir * size) > shipBoard.getBoard()[yPos].length){
            throw new IllegalArgumentException("Illegal x-position for given direction. Ship doesn't have space to be placed");
        }

        if(yPos + (yDir * size) < 0 || yPos + (yDir * size) > shipBoard.getBoard().length){
            throw new IllegalArgumentException("Illegal y-position for given direction. Ship doesn't have space to be placed");
        }

        int[][] locations = new int[size][2];

        for(int count = 0; count < size; count++){
            shipBoard.setCell(xPos, yPos, new Token("\u001B[38;5;240m"));
            locations[count][0] = xPos;
            locations[count][1] = yPos;
            xPos += xDir;
            yPos += yDir;
        }
        int loc = (name.length() == 10 ? 1 : (name.length() == 9 ? (name.contains("u") ? 3 : 4) : name.contains("a") ? 0 : 2));
        fleet[loc] = new Ship(name, size, locations);
    }

    public BattleshipGameBoard getShipBoard(){
        return shipBoard;
    }

    public BattleshipGameBoard getGuessBoard(){
        return guessBoard;
    }

    public Ship[] getFleet(){
        return fleet;
    }

}
