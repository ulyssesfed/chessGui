package com.company;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame {

    private JPanel boardPanel;
    private JLabel[][] boardSquares;
    private final int BOARD_SIZE = 8;

    public ChessBoard() {
        // Set up the main window
        super("Chess Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        // Create the board panel and set its layout
        boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE, 0, 0));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(boardPanel, BorderLayout.CENTER);

        // Create the board squares and add them to the board panel
        boardSquares = new JLabel[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                boardSquares[row][col] = new JLabel();
                boardSquares[row][col].setOpaque(true);
                if ((row + col) % 2 == 0) {
                    boardSquares[row][col].setBackground(Color.WHITE);
                } else {
                    boardSquares[row][col].setBackground(Color.GRAY);
                }
                boardPanel.add(boardSquares[row][col]);
            }
        }

        // Make the main window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
    }
}
