package edu.neumont.oop.Controller;


public class CheckersGamePlay {
    int x1, y1, x2, y2;
    boolean isJump;

    public void movePiece(int x1, int y1, int x2, int y2, boolean isJump) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.isJump = isJump;
    }

    public int[] getStartPosition() {

        int[] sPosition = new int[2];
        sPosition[0] = x1;
        sPosition[1] = y1;
        return sPosition;
    }

    public int[] getEndPosition() {

        int[] ePosition = new int[2];
        ePosition[0] = x2;
        ePosition[1] = y2;
        return ePosition;
    }


}