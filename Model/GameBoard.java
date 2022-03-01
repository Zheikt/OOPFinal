package edu.neumont.oop.Model;

public abstract class GameBoard {
    private Token[][] board;
    private final int ROWS;
    private final int COLUMNS;

    protected Token[][] getBoard(){
        return board;
    }

    public GameBoard(int rows, int columns){
        this.ROWS = rows;
        this.COLUMNS = columns;
        board = new Token[ROWS][COLUMNS];
        initializeBoard();
    }

    protected void initializeBoard(){
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                board[row][column] = null;
            }
        }
    }

    public void setCell(int xPos, int yPos, Token newToken){
        this.board[yPos][xPos] = newToken;
    }

    public Token getCell(int xPos, int yPos){
        return this.board[yPos][xPos];
    }

    public abstract String boardString();

    @Override
    public String toString() {
        return boardString();
    }
}
