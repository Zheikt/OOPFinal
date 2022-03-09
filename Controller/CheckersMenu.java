package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.*;
import edu.neumont.oop.View.ConsoleIO;

import java.util.Scanner;

public class CheckersMenu {


        public final int SIZE = 8;
        private ConsoleIO consoleIO = new ConsoleIO();

        private Scanner input = new Scanner(System.in);
        boolean isPlayer1 = true;

        private boolean endGameNow = false;

        public void createBoard(){
            CheckersBoard board = new CheckersBoard(SIZE);

            Player player1;
            Player player2;

            if (CheckersMenu.askIfTwoPlayer()) {
                player1 = new HPlayer(true);
                player2 = new HPlayer(false);
            } else {
                player1 = new HPlayer(true);
                player2 = new AI(false);
            }

            while ( !CheckersMenu.endGame(board) ) {
                if (CheckersMenu.isPlayer1) {
                    board = player1.getMove(board);
                } else {
                    board = player2.getMove(board);
                }

                boolean isPlayer1 = !CheckersMenu.isPlayer1;
            }
        }

        boolean askIfTwoPlayer() {
            while (true) {
                consoleIO.printMessage("Welcome to checkers!\n");
                consoleIO.printMessage("Choose your mode!");
                consoleIO.printMessage("1: Player VS Computer");
                consoleIO.printMessage("2: Player VS Player");
                consoleIO.printMessage("\nWhich one would you like to play? Enter a number or choose to exit: ");

                String response = input.nextLine();
                switch (response.trim()) {
                    case "1":
                        return false;
                    case "2":
                        return true;
                    case "exit":
                        endGameNow();
                        return true;
                }
            }
        }

        boolean endGame(CheckersBoard board) {
            if (endGameNow) {
            } else {
                int movableWhiteNum = 0;
                int movableBlackNum = 0;
                for (int pos = 0; pos < board.size*board.size; pos++) {
                    CheckersPiece pieceHere = board.getValueAt(pos);
                    if (pieceHere != null) {
                        Move[] movesHere = pieceHere.getAllPossibleMoves(board);
                        if (movesHere != null && movesHere.length > 0) {
                            if (pieceHere.isRed)
                                movableWhiteNum++;
                            else movableBlackNum++;
                        }
                    }
                }

                if (movableWhiteNum + movableBlackNum == 0)
                    consoleIO.printMessage("The game was a stalemate");
                else if (movableWhiteNum == 0)
                    consoleIO.printMessage("Congratulations, Black, you won!");
                else if (movableBlackNum == 0)
                    consoleIO.printMessage("Congratulations, Red, you won!");
                else
                    return false;
            }
            return true;
        }

        public void endGameNow() {
            endGameNow = true;
        }
    }