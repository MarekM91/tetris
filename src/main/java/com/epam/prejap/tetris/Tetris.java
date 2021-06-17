package com.epam.prejap.tetris;

import com.epam.prejap.tetris.block.BlockFeed;
import com.epam.prejap.tetris.game.*;
import com.epam.prejap.tetris.player.Player;
import com.epam.prejap.tetris.player.RandomPlayer;

class Tetris {

    private final Playfield playfield;
    private final Waiter waiter;
    private final Player player;
    private final CurrentScore currentScore;

    public Tetris(Playfield playfield, Waiter waiter, Player player, CurrentScore currentScore) {
        this.playfield = playfield;
        this.waiter = waiter;
        this.player = player;
        this.currentScore = currentScore;
    }

    public Score play() {
        boolean moved;
        int score = 0;
        do {
            moved = false;

            playfield.nextBlock();
            score++;
            boolean nextMove;
            do {
                waiter.waitForIt();
                Move move = player.nextMove().orElse(Move.NONE);
                moved |= (nextMove = playfield.move(move));
            } while (nextMove);

        } while (moved);

        return new Score(score);
    }

    public static void main(String[] args) {
        int rows = 10;
        int cols = 20;
        int delay = 500;

        var feed = new BlockFeed();
        var currentScore = new CurrentScore();
        var printer = new Printer(System.out, currentScore);
        var playfield = new Playfield(rows, cols, feed, printer, currentScore);
        var game = new Tetris(playfield, new Waiter(delay), new RandomPlayer(), new CurrentScore());

        var score = game.play();

        System.out.println("Total score: " + score.points());
    }

}
