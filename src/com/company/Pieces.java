package com.company;
import javax.swing.ImageIcon;

public abstract class Pieces {

    private String color;
    private ImageIcon icon;
    private int xPosition;
    private int yPosition;

    public Pieces(String color, String imagePath, int xPosition, int yPosition) {
        this.color = color;
        this.icon = new ImageIcon(imagePath);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public abstract boolean canMove(int x, int y);

    public abstract void move(int x, int y);

}
