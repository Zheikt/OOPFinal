package edu.neumont.oop.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class AI extends Player{

        boolean isRed;

        public AI(boolean isRed) {
            super("Temp Name", false);
            this.isRed = isRed;
        }

        public CheckersBoard getMove(CheckersBoard board) {
            HashMap<CheckersPiece, Move[]> possibleChoices = new HashMap<>();

            for (int x = 0; x < board.size; x++) {
                for (int y = 0; y < board.size; y++) {
                    CheckersPiece piece = board.getValueAt(x, y);
                    if (piece != null && piece.isRed == this.isRed) {
                        Move[] possibleMoves = piece.getAllPossibleMoves(board);

                        if (possibleMoves != null)
                            possibleChoices.put(piece, possibleMoves);
                    }
                }
            }

            CheckersPiece furthestBackwardPiece = possibleChoices.keySet().toArray(new CheckersPiece[1])[0];
            CheckersPiece furthestForwardPiece = possibleChoices.keySet().toArray(new CheckersPiece[1])[0];

            HashMap<Move, CheckersPiece> bestMovesPerPiece = new HashMap<>();
            for (CheckersPiece piece : possibleChoices.keySet()) {
                int thisPieceY = piece.getCoordinates()[1];
                if (thisPieceY > furthestForwardPiece.getCoordinates()[1]) {
                    if (isRed)
                        furthestForwardPiece = piece;
                    else
                        furthestBackwardPiece = piece;
                }
                else if (thisPieceY < furthestBackwardPiece.getCoordinates()[1]) {
                    if (isRed)
                        furthestBackwardPiece = piece;
                    else
                        furthestForwardPiece = piece;
                }

                Move[] possibleMoves = possibleChoices.get(piece);
                Move maxJumpMove = possibleMoves[0];
                int maxJumpMoveLength = 0;
                for (Move possibleMove : possibleMoves) {
                    CheckersPiece[] jumpedPieces = possibleMove.getJumpedPieces(board);
                    if (jumpedPieces != null) {
                        int jumpLength = jumpedPieces.length;

                        if (jumpLength >= maxJumpMoveLength) {
                            maxJumpMoveLength = jumpLength;
                            maxJumpMove = possibleMove;
                        }
                    }
                }

                bestMovesPerPiece.put(maxJumpMove, piece);
            }

            Move absoluteBestMove = bestMovesPerPiece.keySet().toArray(new Move[1])[0];
            int absoluteBestMoveJumpLength = 0;
            for (Move move : bestMovesPerPiece.keySet()) {
                CheckersPiece[] jumpedPieces = move.getJumpedPieces(board);

                if (jumpedPieces != null) {
                    int thisBestMoveJumpLength = jumpedPieces.length;

                    if (thisBestMoveJumpLength >= absoluteBestMoveJumpLength) {
                        absoluteBestMoveJumpLength = thisBestMoveJumpLength;
                        absoluteBestMove = move;
                    }
                }
            }

            if (absoluteBestMoveJumpLength > 0) {
                board.applyMoveToBoard(absoluteBestMove, bestMovesPerPiece.get(absoluteBestMove));
            } else {
                int randomNum = new Random().nextInt(2);
                if (randomNum == 0) {
                    board.applyMoveToBoard(Objects.requireNonNull(getKeyByValue(bestMovesPerPiece, furthestBackwardPiece)), furthestBackwardPiece);
                } else {
                    board.applyMoveToBoard(Objects.requireNonNull(getKeyByValue(bestMovesPerPiece, furthestForwardPiece)), furthestForwardPiece);
                }
            }

            return board;
        }

        private <T, E> T getKeyByValue(HashMap<T, E> map, E value) {
            for (Map.Entry<T, E> entry : map.entrySet()) {
                if (Objects.equals(value, entry.getValue())) {
                    return entry.getKey();
                }
            }
            return null;
        }
    }