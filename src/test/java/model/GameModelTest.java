package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.GameModel;

/**
 * The GameModelTest class contains JUnit tests for the GameModel class.
 */
public class GameModelTest {
    private GameModel model;

    /**
     * Sets up the test environment by creating a new GameModel instance.
     */
    @Before
    public void setUp() {
        model = new GameModel();
    }

    /**
     * Tests the determineWinner method for a draw scenario.
     */
    @Test
    public void testDetermineWinnerDraw() {
        // Test a draw scenario
        String result = model.determineWinner("Rock", "Rock");
        assertEquals(GameModel.DRAW_MESSAGE, result);
    }

    /**
     * Tests the determineWinner method for scenarios where Player 1 wins.
     */
    @Test
    public void testDetermineWinnerPlayer1Wins() {
        // Test Player 1 wins scenario
        String result = model.determineWinner("Rock", "Scissors");
        assertEquals(GameModel.PLAYER_1_WINS_MESSAGE, result);

        result = model.determineWinner("Paper", "Rock");
        assertEquals(GameModel.PLAYER_1_WINS_MESSAGE, result);

        result = model.determineWinner("Scissors", "Paper");
        assertEquals(GameModel.PLAYER_1_WINS_MESSAGE, result);
    }

    /**
     * Tests the determineWinner method for scenarios where Player 2 wins.
     */
    @Test
    public void testDetermineWinnerPlayer2Wins() {
        // Test Player 2 wins scenario
        String result = model.determineWinner("Scissors", "Rock");
        assertEquals(GameModel.PLAYER_2_WINS_MESSAGE, result);

        result = model.determineWinner("Rock", "Paper");
        assertEquals(GameModel.PLAYER_2_WINS_MESSAGE, result);

        result = model.determineWinner("Paper", "Scissors");
        assertEquals(GameModel.PLAYER_2_WINS_MESSAGE, result);
    }

    /**
     * Tests the getRandomChoice method to ensure it returns values within the expected range.
     */
    @Test
    public void testGetRandomChoice() {
        // Test getRandomChoice to ensure it returns values within the expected range
        int randomChoice = model.getRandomChoice();
        assertTrue(randomChoice >= 0 && randomChoice <= 2);
    }
}
