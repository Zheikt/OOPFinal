package edu.neumont.oop.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckersPiece {
    private int x;
    private int y;
    private boolean isKing = false;
    public boolean isRed;

    public CheckersPiece(int x, int y, boolean isRed) {
        this.x = x;
        this.y = y;
        this.isRed = isRed;
    }

    public int[] getCoordinates() {
        int[] coordinates = new int[2];
        coordinates[0] = this.x;
        coordinates[1] = this.y;
        return coordinates;
    }

    public String getString() {
        String baseSymbol;

        if (isRed)
            baseSymbol = "R";
        else
            baseSymbol = "B";

        if (isKing)
            baseSymbol += "K";
        else
            baseSymbol += " ";

        return baseSymbol;
    }

    private void setKing() {
        isKing = true;
    }

    public void checkIfShouldBeKing(CheckersBoard board) {
        if (isRed && this.y == board.size - 1 ||
                !isRed && this.y == 0)
            this.setKing();
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Move[] getAllPossibleMoves(CheckersBoard board) {
        ArrayList<Move> moves = new ArrayList<Move>();

        int startingY, yIncrement;
        if (isRed) {
            startingY = this.y + 1;
            yIncrement = -2;
        } else {
            startingY = this.y - 1;
            yIncrement = 2;
        }

        int rowsToCheck = 1;
        if (this.isKing)
            rowsToCheck = 2;

        for (int x = this.x - 1; x <= this.x + 1; x += 2) {
            int y = startingY - yIncrement;
            for (int i = 0; i < rowsToCheck; i++) {
                y += yIncrement;

                if (board.isOverEdge(x, y))
                    continue;

                if (board.getValueAt(x, y) == null) {
                    moves.add(new Move(this.x, this.y, x, y, null, false));
                }
            }
        }

        Move[] possibleJumps = this.getAllPossibleJumps(board, null);
        if (possibleJumps != null)
            moves.addAll(Arrays.asList(possibleJumps));

        if (!moves.isEmpty()) {
            moves.trimToSize();
            return moves.toArray(new Move[1]);
        } else
            return null;
    }

    private Move[] getAllPossibleJumps(CheckersBoard board, Move precedingMove) {
        ArrayList<Move> moves = new ArrayList<Move>();

        int startingY, yIncrement;
        if (isRed) {
            startingY = this.y + 2;
            yIncrement = -4;
        } else {
            startingY = this.y - 2;
            yIncrement = 4;
        }
        int rowsToCheck = 1;
        if (this.isKing)
            rowsToCheck = 2;

        for (int x = this.x - 2; x <= this.x + 2; x += 4) {
            int y = startingY - yIncrement;
            for (int i = 0; i < rowsToCheck; i++) {
                y += yIncrement;

                if (board.isOverEdge(x, y))
                    continue;

                if (precedingMove != null &&
                        x == precedingMove.getStartingPosition()[0] &&
                        y == precedingMove.getStartingPosition()[1])
                    continue;

                CheckersPiece betweenPiece = board.getValueAt((this.x + x) / 2, (this.y + y) / 2);
                if (betweenPiece != null && betweenPiece.isRed != this.isRed && board.getValueAt(x, y) == null) {
                    Move jumpingMove = new Move(this.x, this.y, x, y, precedingMove, true);
                    moves.add(jumpingMove);

                    CheckersPiece imaginaryPiece = new CheckersPiece(x, y, this.isRed);

                    if (this.isKing) imaginaryPiece.setKing();

                    Move[] subsequentMoves = imaginaryPiece.getAllPossibleJumps(board, jumpingMove);

                    if (subsequentMoves != null)
                        moves.addAll(Arrays.asList(subsequentMoves));
                }
            }
        }

        if (!moves.isEmpty()) {
            moves.trimToSize();
            return moves.toArray(new Move[1]);
        } else
            return null;
    }
}