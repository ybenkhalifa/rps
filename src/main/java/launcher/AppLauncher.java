package launcher;

import javax.swing.SwingUtilities;
import controller.GameController;

/**
 * The AppLauncher class serves as the entry point for starting the Rock-Paper-Scissors game application.
 */
public class AppLauncher {
    /**
     * The main method for launching the game application.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the controller and initialize the game
            GameController controller = new GameController();
            controller.getView().setVisible(true);
        });
    }
}
