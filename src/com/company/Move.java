package com.company;

public class Move {
    private Pieces pieceMoved;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Pieces pieceCaptured;

    public Move(Pieces pieceMoved, int startX, int startY, int endX, int endY, Pieces pieceCaptured) {
        this.pieceMoved = pieceMoved;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.pieceCaptured = pieceCaptured;
    }

    public Pieces getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Pieces pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Pieces getPieceCaptured() {
        return pieceCaptured;
    }

    public void setPieceCaptured(Pieces pieceCaptured) {
        this.pieceCaptured = pieceCaptured;
    }
}
