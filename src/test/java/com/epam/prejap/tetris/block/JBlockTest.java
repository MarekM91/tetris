package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = {"blockShapes", "blocks"})
public class JBlockTest {

    JBlock jBlock = new JBlock();

    public void numberOfRowsShouldEqualThree() {
        int actual = jBlock.rows();
        int expected = 3;
        assertEquals(actual, expected, "Number of rows is incorrect. Expected: " + expected + " rows, actual number of rows is " + actual);
    }

    public void numberOfColsShouldEqualThree() {
        int actual = jBlock.cols();
        int expected = 2;
        assertEquals(actual, expected, "Number of cols is incorrect. Expected: " + expected + " cols, actual number of cols is " + actual);
    }

    @Test(dataProvider = "dotsPositions")
    public void dotAtCorrectPosition(int row, int col, int expected, String message) {
        int actual = jBlock.dotAt(row, col);
        assertEquals(actual, expected, message);
    }

    @DataProvider
    public static Object[][] dotsPositions() {
        return new Object[][]{
                {0, 0, 0, "Incorrect dot at (0,0)"},
                {0, 1, 1, "Incorrect dot at (0,1)"},
                {1, 0, 0, "Incorrect dot at (1,0)"},
                {1, 1, 1, "Incorrect dot at (1,1)"},
                {2, 0, 1, "Incorrect dot at (2,0)"},
                {2, 1, 1, "Incorrect dot at (2,1)"},
        };
    }
}
