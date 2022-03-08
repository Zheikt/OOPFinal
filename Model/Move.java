package edu.neumont.oop.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Move {
    int x1, y1, x2, y2;
    Move precedingMove;
    boolean isJump;

    public Move(int x1, int y1, int x2, int y2, Move precedingMove, boolean isJump) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.precedingMove = precedingMove;
        this.isJump = isJump;
    }

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

    public CheckersPiece[] getJumpedPieces(CheckersBoard board) {
        if (isJump)
        {
            ArrayList<CheckersPiece> pieces = new ArrayList<CheckersPiece>();
            int pieceX = (x1 + x2)/2;
            int pieceY = (y1 + y2)/2;

            pieces.add(board.getValueAt(pieceX, pieceY));

            if (precedingMove != null) {
                pieces.addAll(Arrays.asList(precedingMove.getJumpedPieces(board)));
            }

            pieces.trimToSize();
            return pieces.toArray(new CheckersPiece[1]);
        }
        else
            return null;
    }
}