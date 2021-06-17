package com.epam.prejap.tetris.game;

import java.io.PrintStream;

public class Printer {

    final PrintStream out;
    private final CurrentScore currentScore;

    public Printer(PrintStream out, CurrentScore currentScore) {
        this.out = out;
        this.currentScore = currentScore;
    }

    void draw(byte[][] grid) {
        clear();
        border(grid[0].length);
        for (byte[] bytes : grid) {
            startRow();
            for (byte aByte : bytes) {
                print(aByte);
            }
            endRow();
        }
        border(grid[0].length);
    }

    void clear() {
        out.print("\u001b[2J\u001b[H");
    }

    void print(byte dot) {
        out.format(dot == 0 ? " " :"#");
    }

    void startRow() {
        out.print("|");
    }

    void endRow() {
        out.println("|");
    }

    void border(int width) {
        out.println("+" + "-".repeat(width) + "+");
    }

    void printCurrentScore() { out.println("Current score:" + currentScore.getPoints()); }
}
