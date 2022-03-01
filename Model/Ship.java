package edu.neumont.oop.Model;

public class Ship {
    private String type;
    private int hitPieces;
    private boolean[] hitMarkers;

    // This is all pseudocode, but we know the types are: Carrier(5), BattleShip(4), Cruiser(3), Submarine(3), and Destroyer(2).
    // In terms of placement, we'll be working with a starting point which will we can place like : *Prompt for Column* ShipBoard[i][], *Prompt for Row* ShipBoard[][i]
    // After That, the user will be prompted for Direction. How we could phrase it is *Prompt user for direction of placement* "Down" would subtract {Ship size} from the Column value, "Left" amd "right" would subtract or add from the row value respectively, and "up" would add to the column value.
    // This process would loop until all ships have been placed, making sure to alert the user if a ship goes out of bounds at any time.
    // After all ships get placed, the board would get finalized as ShipBoard(Player#) and we would then use that board for comparison to the GuessBoard.





}
