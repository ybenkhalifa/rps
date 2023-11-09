package test.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import org.junit.Before;
import org.junit.Test;

import view.GameView;

public class GameViewTest {
    private GameView gameView;

    @Before
    public void setUp() {
        gameView = new GameView();
        gameView.createVue(); // Create the GUI for testing

   



    }

    @Test
    public void testAddPlayButtonListener() {
        ActionListener listener = e -> {
            // Your action to be performed when the Play button is clicked
        };
        gameView.addPlayButtonListener(listener);
        ActionListener[] listeners = gameView.playButton.getActionListeners();
        assertTrue(listeners.length > 0);
    }

    @Test
    public void testSetResultLabel() {
        String expectedResult = "Player 1 wins!";
        gameView.setResultLabel(expectedResult);
        assertEquals(expectedResult, gameView.resultLabel.getText());
    }

    @Test
    public void testIsHumanVsComputerSelected() {
        // Simulate selecting the "Player 1: Human vs Player 2: Bot" radio button
        gameView.humanVsComputerRadio.setSelected(true);
        assertTrue(gameView.isHumanVsComputerSelected());


    }

    @Test
    public void testIsComputerVsComputerSelected() {
        // Simulate selecting the "Player 1: Bot A vs Player 2: Bot B" radio button
        gameView.computerVsComputerRadio.setSelected(true);
        assertTrue(gameView.isComputerVsComputerSelected());


    }

    @Test
    public void testInitializeTableView() {
        DefaultTableModel tableModel = gameView.initializeTableView();
        assertNotNull(tableModel);
        assertEquals(GameView.COLUMN_HEADERS.length, tableModel.getColumnCount());
        assertEquals(GameView.INITIAL_DATA.length, tableModel.getRowCount());

        // You can add more assertions to check the content of the table model if needed
    }
}
