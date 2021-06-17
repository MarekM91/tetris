package com.epam.prejap.tetris.game;

public class CurrentScore {
    private int points;

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        points += 1;
    }

    @Override
    public String toString() {
        return "Current score: " + getPoints();
    }
}
