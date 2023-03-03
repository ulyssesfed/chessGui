package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private ChessBoard board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    private List<Move> moveList;

    public Game(Player whitePlayer, Player blackPlayer) {
        this.board = new ChessBoard();
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.currentPlayer = whitePlayer;
        this.moveList = new ArrayList<>();
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(Player blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public void makeMove(Move move) {
        // Get the piece being moved
        Pieces movingPiece = board.getPiece(move.getFromRow(), move.getFromCol());

        // Get the piece being captured (if any)
        Pieces capturedPiece = board.getPiece(move.getToRow(), move.getToCol());

        // Make the move on the board
        board.movePiece(move.getFromRow(), move.getFromCol(), move.getToRow(), move.getToCol());

        // Update the player's captured pieces and move count
        if (capturedPiece != null) {
            currentPlayer.addCapturedPiece(capturedPiece);
        }
        currentPlayer.incrementMoveCount();

        // Add the move to the move list
        moveList.add(move);

        // Check if the move resulted in a player winning
        if (board.isCheckmate(currentPlayer.getOpponent())) {
            System.out.println(currentPlayer.getName() + " wins!");
        } else if (board.isStalemate(currentPlayer.getOpponent())) {
            System.out.println("Stalemate!");
        } else {
            // Switch the current player to the other player
            currentPlayer = currentPlayer.getOpponent();
        }
    }


    public void undoLastMove() {
        // Get the last move made in the game
        Move lastMove = moveList.get(moveList.size() - 1);

        // Undo the move on the board
        board.movePiece(lastMove.getToRow(), lastMove.getToCol(), lastMove.getFromRow(), lastMove.getFromCol());

        // Update the player's captured pieces and move count
        currentPlayer.decrementMoveCount();
        Piece capturedPiece = currentPlayer.removeLastCapturedPiece();
        if (capturedPiece != null) {
            board.setPiece(lastMove.getToRow(), lastMove.getToCol(), capturedPiece);
        }

        // Remove the last move from the move list
        moveList.remove(moveList.size() - 1);

        // Switch the current player to the other player
        currentPlayer = currentPlayer.getOpponent();
    }


    public void resetGame() {
        // Reset the board to its initial state
        board.initialize();

        // Reset the players to their initial states
        whitePlayer.initialize();
        blackPlayer.initialize();

        // Set the current player to white
        currentPlayer = whitePlayer;

        // Clear the move list
        moveList.clear();
    }

}
