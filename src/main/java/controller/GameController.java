package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.GameModel;
import view.GameView;

/**
 * The GameController class controls the game logic and user interactions in the Rock-Paper-Scissors game.
 */
public class GameController {
    private GameModel model;
    private GameView view;

    // Define constants for choices
    public static final String[] MOVE_OPTIONS = {"Rock", "Paper", "Scissors"};
    public static final String HUMAN_VS_COMPUTER_TITLE = "Human vs Computer";
    public static final String COMPUTER_VS_COMPUTER_TITLE = "Computer vs Computer";

    /**
     * Constructs a GameController instance.
     */
    public GameController() {
        model = new GameModel();
        view = new GameView();
        view.createVue();

        view.addPlayButtonListener(new PlayButtonListener());
    }

    /**
     * Gets the GameModel associated with this GameController.
     *
     * @return The GameModel instance.
     */
    public GameModel getModel() {
        return model;
    }

    /**
     * Sets the GameModel for this GameController.
     *
     * @param model The GameModel instance to set.
     */
    public void setModel(GameModel model) {
        this.model = model;
    }

    /**
     * Gets the GameView associated with this GameController.
     *
     * @return The GameView instance.
     */
    public GameView getView() {
        return view;
    }

    /**
     * Sets the GameView for this GameController.
     *
     * @param view The GameView instance to set.
     */
    public void setView(GameView view) {
        this.view = view;
    }

    /**
     * Starts the game based on the selected game mode.
     */
    public void startGame() {
        if (view.isHumanVsComputerSelected()) {
            int userChoice = JOptionPane.showOptionDialog(
                view,
                "Select your move:",
                HUMAN_VS_COMPUTER_TITLE,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                MOVE_OPTIONS,
                MOVE_OPTIONS[0]
            );

            if (userChoice == -1) {
                // User closed the dialog, do nothing
                return;
            }

            int computerChoice = model.getRandomChoice();

            String userMove = MOVE_OPTIONS[userChoice];
            String computerMove = MOVE_OPTIONS[computerChoice];

            String result = model.determineWinner(userMove, computerMove);

            view.setResultLabel("Human chose " + userMove + ". Bot chose " + computerMove + ". Result: " + result);
        } else if (view.isComputerVsComputerSelected()) {
            int computer1Choice = model.getRandomChoice();
            int computer2Choice = model.getRandomChoice();

            String computer1Move = MOVE_OPTIONS[computer1Choice];
            String computer2Move = MOVE_OPTIONS[computer2Choice];

            String result = model.determineWinner(computer1Move, computer2Move);

            view.setResultLabel("Bot A chose " + computer1Move + ". Bot B chose " + computer2Move + ". Result: " + result);
        } else {
            view.setResultLabel("Please select a game mode.");
        }
    }

    /**
     * Private inner class that implements the ActionListener interface to handle the Play button click event.
     */
    private class PlayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
    }
}
