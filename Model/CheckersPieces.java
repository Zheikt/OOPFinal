package edu.neumont.oop.Model;
import java.awt.Color;

public class CheckersPieces extends Token {

    private int x;
    private int y;
    private boolean isKing = false;
    public boolean isWhite;

    /**
     * x - The x position of this piece.
     * y - The y position of this piece.
     * isWhite Whether this piece is white or black.
     */

    public void setPiece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    /**
     * Returns an array representing the position of the piece's position.
     */
    public int[] getPlace() {
        int[] position = new int[2];
        position[0] = this.x;
        position[1] = this.y;
        return position;
    }

    //public void setPieceColor(String color){
    //  Color redPiece = new Color(200, 0, 0);
    //  Color blackPiece = new Color(0, 0, 0);
    //}

    public CheckersPieces(String color) {
        super(color);
    }

}