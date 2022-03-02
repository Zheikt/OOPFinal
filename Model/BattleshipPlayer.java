package edu.neumont.oop.Model;

public class BattleshipPlayer extends Player{
    private BattleshipGameBoard shipBoard;
    private BattleshipGameBoard guessBoard;
    //private Ship[] fleet; //Maybe use this to store their Ships?

    public BattleshipPlayer(String name) {
        super(name);
        shipBoard = new BattleshipGameBoard();
        guessBoard = new BattleshipGameBoard();
    }

    //Maybe this should be in the class that sets up the Battleship Game
    public void setShip(int xPos, int yPos, int xDir, int yDir, int size) throws IllegalArgumentException{ //Maybe this should be part of a Controller? Some error handling can be taken care of in a View when getting the info
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

        for(int count = size; count > 0; count--){
            shipBoard.setCell(xPos, yPos, new Token("\u001B[38;5;240m"));
            xPos += xDir;
            yPos += yDir;
        }
    }

    public BattleshipGameBoard getShipBoard(){
        return shipBoard;
    }

    public BattleshipGameBoard getGuessBoard(){
        return guessBoard;
    }

}
