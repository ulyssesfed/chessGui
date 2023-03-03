package com.company;

public class Player {
    private String name;
    private String color;
    private boolean isComputerPlayer;

    public Player(String name, String color, boolean isComputerPlayer) {
        this.name = name;
        this.color = color;
        this.isComputerPlayer = isComputerPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isComputerPlayer() {
        return isComputerPlayer;
    }

    public void setComputerPlayer(boolean isComputerPlayer) {
        this.isComputerPlayer = isComputerPlayer;
    }
}
