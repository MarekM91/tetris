package com.epam.prejap.tetris.block;

/**
 * class containing J block
 */
final class JBlock extends Block {

    private static final byte[][] IMAGE = {
            {0, 1},
            {0, 1},
            {1, 1},
    };

    public JBlock() {
        super(IMAGE);
    }
}
