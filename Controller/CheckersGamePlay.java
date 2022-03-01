package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.CheckersBoard;
import edu.neumont.oop.Model.CheckersPieces;

import java.util.ArrayList;

public class CheckersGamePlay {

    int x1, y1, x2, y2, currentX, currentY;
    boolean previousMove;
    boolean isJump;


   public int[] getStartingPosition() {

        int[] position = new int[2];
        position[0] = x1;
        position[1] = y1;
        return position;
    }

    public int[] getEndingPosition() {

        int[] position = new int[2];
        position[0] = x2;
        position[1] = y2;
        return position;
    }

    public int[] getCurrentPosition(){

        int[] currentPosition = new int[2];
        currentPosition[0] = currentX;
        currentPosition[1] = currentY;
        return currentPosition;
    }

    public void jump() {
        int[] moveStartingPos;
        int[] moveEndingPos;
    }

   public CheckersPieces[] getJumpedPieces(CheckersBoard board) {

        if (isJump) {

            ArrayList<CheckersPieces> pieces = new ArrayList<>();

            int pieceX = (x1 + x2) / 2;
            int pieceY = (y1 + y2) / 2;

            if (!previousMove) {
            }

            pieces.trimToSize();
            return pieces.toArray(new CheckersPieces[1]);
        } else
            return null;
    }
}