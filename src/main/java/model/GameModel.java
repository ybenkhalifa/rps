package model;

import java.util.Random;

/**
 * The GameModel class represents the game logic for Rock-Paper-Scissors.
 */
public class GameModel {
    private Random random;

    /**
     * The array of move options: {"Rock", "Paper", "Scissors"}.
     */
    public static final String[] MOVE_OPTIONS = {"Rock", "Paper", "Scissors"};

    /**
     * The message indicating a draw result.
     */
    public static final String DRAW_MESSAGE = "It's a draw!";

    /**
     * The message indicating that Player 1 wins.
     */
    public static final String PLAYER_1_WINS_MESSAGE = "Player 1 wins!";

    /**
     * The message indicating that Player 2 wins.
     */
    public static final String PLAYER_2_WINS_MESSAGE = "Player 2 wins!";

    /**
     * Constructs a GameModel instance and initializes the random number generator.
     */
    public GameModel() {
        random = new Random();
    }

    /**
     * Determines the winner of the game based on the moves of two players.
     *
     * @param move1 The move of the first player.
     * @param move2 The move of the second player.
     * @return A message indicating the game result (DRAW_MESSAGE, PLAYER_1_WINS_MESSAGE, or PLAYER_2_WINS_MESSAGE).
     */
    public String determineWinner(String move1, String move2) {
        if (move1.equals(move2)) {
            return DRAW_MESSAGE;
        } else if ((move1.equals(MOVE_OPTIONS[0]) && move2.equals(MOVE_OPTIONS[2]))
                || (move1.equals(MOVE_OPTIONS[1]) && move2.equals(MOVE_OPTIONS[0]))
                || (move1.equals(MOVE_OPTIONS[2]) && move2.equals(MOVE_OPTIONS[1]))) {
            return PLAYER_1_WINS_MESSAGE;
        } else {
            return PLAYER_2_WINS_MESSAGE;
        }
    }

    /**
     * Generates a random choice (0, 1, or 2) representing Rock, Paper, or Scissors.
     *
     * @return The random choice as an integer.
     */
    public int getRandomChoice() {
        return random.nextInt(3);
    }
}
