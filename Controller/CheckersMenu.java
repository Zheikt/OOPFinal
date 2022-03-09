package edu.neumont.oop.Controller;

import edu.neumont.oop.Model.*;
import edu.neumont.oop.View.ConsoleIO;

import java.util.Scanner;

public class CheckersMenu {


        public static final int SIZE = 8;
        private static ConsoleIO message = new ConsoleIO();

        private static Scanner input = new Scanner(System.in);
        static boolean isPlayer1 = true;
        private static boolean askIfPlayer2;

        private static boolean endGameNow = false;

        public void createBoard(){
            CheckersBoard board = new CheckersBoard(SIZE);

            Player player1;
            Player player2;

            if (isAskIfPlayer2()) {
                player1 = new HPlayer(true);
                player2 = new HPlayer(false);
            } else {
                player1 = new HPlayer(true);
                player2 = new AI(false);
            }
            CheckersMenu.clearScreen();

            while ( !CheckersMenu.endGame(board) ) {
                if (CheckersMenu.isPlayer1) {
                    board = player1.getMove(board);
                } else {
                    board = player2.getMove(board);
                }

                boolean isPlayer1 = !CheckersMenu.isPlayer1;
            }
        }

    public static boolean isAskIfPlayer2() {
        return askIfPlayer2;
    }

    public static void setAskIfPlayer2(boolean askIfPlayer2) {
        CheckersMenu.askIfPlayer2 = askIfPlayer2;
    }

    static boolean askIfTwoPlayer() {
            while (true) {
                clearScreen();
                message.printMessage("Welcome to checkers!\n");
                message.printMessage("Choose your mode!");
                message.printMessage("1: Player VS Computer");
                message.printMessage("2: Player VS Player");
                message.printMessage("\nWhich one would you like to play? Enter a number or choose to exit: ");

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

        static boolean endGame(CheckersBoard board) {
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
                    message.printMessage("The game was a stalemate");
                else if (movableWhiteNum == 0)
                    message.printMessage("Congratulations, Black, you won!");
                else if (movableBlackNum == 0)
                    message.printMessage("Congratulations, Red, you won!");
                else
                    return false;
            }
            return true;
        }

        public static void endGameNow() {
            endGameNow = true;
        }

        public static void clearScreen(){
            System.out.print("\033[2J\033[1;1H");
        }
    }