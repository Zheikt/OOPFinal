package edu.neumont.oop.Model;

public class CheckersBoard {

    public CheckersPiece[][] boardArray;
    public int size;


    public CheckersBoard(int size) {
        this.boardArray = new CheckersPiece[size][size];
        this.size = size;

        setupBoard();
    }

    public void setupBoard() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (y < 3 && isCheckerboardSpace(x, y)) {
                    this.boardArray[y][x] = new CheckersPiece(x, y, true);
                } else if (y >= size - 3 && isCheckerboardSpace(x, y)) {
                    this.boardArray[y][x] = new CheckersPiece(x, y, false);
                }
            }
        }
    }

    public void applyMoveToBoard(Move move, CheckersPiece piece) {
        int[] moveStartingPos = piece.getCoordinates();
        int[] moveEndingPos = move.getEndingPosition();

        CheckersPiece[] jumpedPieces = move.getJumpedPieces(this);
        if (jumpedPieces != null) {
            for (CheckersPiece jumpedPiece : jumpedPieces) {
                if (jumpedPiece != null) {
                    this.setValueAt(jumpedPiece.getCoordinates()[0], jumpedPiece.getCoordinates()[1], null);
                }
            }
        }

        this.setValueAt(moveStartingPos[0], moveStartingPos[1], null);
        piece.moveTo(moveEndingPos[0], moveEndingPos[1]);

        piece.checkIfShouldBeKing(this);

        this.setValueAt(moveEndingPos[0], moveEndingPos[1], piece);
    }

    private void setValueAt(int x, int y, CheckersPiece piece) {
        this.boardArray[y][x] = piece;
    }

    public CheckersPiece getValueAt(int x, int y) {
        return this.boardArray[y][x];
    }

    public CheckersPiece getValueAt(int position) {
        int[] coords = getCoordinatesFromPosition(position);
        return this.getValueAt(coords[0], coords[1]);
    }

    public int[] getCoordinatesFromPosition(int position) {
        int[] coords = new int[2];

        coords[0] = position % this.size;
        coords[1] = position / this.size;
        return coords;
    }

    public boolean isCheckerboardSpace(int x, int y) {
        return x % 2 == y % 2;
    }

    public boolean isOverEdge(int x, int y) {
        return (x < 0 || x >= this.size ||
                y < 0 || y >= this.size);
    }

}