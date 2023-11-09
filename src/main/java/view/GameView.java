package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 * The GameView class represents the graphical user interface (GUI) for the Rock-Paper-Scissors game.
 */
public class GameView extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel tableModel;
    public JRadioButton humanVsComputerRadio;
    public JRadioButton computerVsComputerRadio;
    public JButton playButton;
    public JLabel resultLabel;
    private JPanel contentPanel;

    /**
     * The column headers for the table.
     */
    public static final String[] COLUMN_HEADERS = {"Element", "Rock", "Paper", "Scissors", "Optimal strategy"};

    /**
     * The initial data for populating the table.
     */
    public static final Object[][] INITIAL_DATA = {
            {"Rock", "0", "-", "+", "1/3"},
            {"Paper", "+", "0", "-", "1/3"},
            {"Scissors", "-", "+", "0", "1/3"}
    };

    /**
     * Creates the graphical user interface (GUI) for the game.
     */
    public void createVue() {
        setTitle("Rock-Paper-Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        contentPanel = new JPanel(new BorderLayout());

        this.tableModel = initializeTableView();

        // Create and populate the table
        table = new JTable(tableModel);

        // Set up table editors and renderers
        for (int i = 1; i <= 3; i++) {
            table.getColumnModel().getColumn(i).setCellEditor(new ValueCellEditor());
            table.getColumnModel().getColumn(i).setCellRenderer(new ValueCellRenderer());
        }

        // Create a panel for game controls
        JPanel controlPanel = new JPanel(new GridLayout(4, 1));
        humanVsComputerRadio = new JRadioButton("Player 1: Human vs Player 2: Bot");
        computerVsComputerRadio = new JRadioButton("Player 1: Bot A vs Player 2: Bot B");
        // Explicitly set the selected state of radio buttons for testing
        humanVsComputerRadio.setSelected(false);
        computerVsComputerRadio.setSelected(true);
        ButtonGroup gameModeGroup = new ButtonGroup();
        gameModeGroup.add(humanVsComputerRadio);
        gameModeGroup.add(computerVsComputerRadio);

        playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(150, 60));
        playButton.setBackground(new Color(0, 128, 0));
        playButton.setToolTipText("Click here to start the game");
        playButton.setFont(new Font("Arial", Font.BOLD, 28));
        playButton.setMargin(new Insets(5, 15, 5, 15));

        resultLabel = new JLabel("");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add controls to the control panel
        controlPanel.add(humanVsComputerRadio);
        controlPanel.add(computerVsComputerRadio);
        controlPanel.add(playButton);
        controlPanel.add(resultLabel);

        // Create a split pane for dividing the content into two columns
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(controlPanel);
        splitPane.setBottomComponent(createImagePanel());

        // Add the split pane to the center of the content panel
        contentPanel.add(splitPane, BorderLayout.SOUTH);

        // Add the table to the content panel
        contentPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Add the content panel to the main window
        add(contentPanel, BorderLayout.CENTER);
    }

    /**
     * Adds an ActionListener to the Play button.
     *
     * @param listener The ActionListener to add.
     */
    public void addPlayButtonListener(ActionListener listener) {
        playButton.addActionListener(listener);
    }

    /**
     * Sets the result message to display on the GUI.
     *
     * @param result The result message to set.
     */
    public void setResultLabel(String result) {
        resultLabel.setText(result);
    }

    /**
     * Checks if the "Player 1: Human vs Player 2: Bot" radio button is selected.
     *
     * @return true if the "Player 1: Human vs Player 2: Bot" radio button is selected, false otherwise.
     */
    public boolean isHumanVsComputerSelected() {
        return humanVsComputerRadio.isSelected();
    }

    /**
     * Checks if the "Player 1: Bot A vs Player 2: Bot B" radio button is selected.
     *
     * @return true if the "Player 1: Bot A vs Player 2: Bot B" radio button is selected, false otherwise.
     */
    public boolean isComputerVsComputerSelected() {
        return computerVsComputerRadio.isSelected();
    }

    /**
     * Creates a panel for displaying an image.
     *
     * @return The image panel.
     */
    private JPanel createImagePanel() {
        JPanel imagePanel = new JPanel(new BorderLayout());
        ImageIcon rpsImageIcon = new ImageIcon(getClass().getResource("/rps.png"));
        //ImageIcon rpsImageIcon = new ImageIcon(getClass().getResource("/rps.png"));
        JLabel rpsImageLabel = new JLabel(rpsImageIcon);
        imagePanel.add(rpsImageLabel, BorderLayout.CENTER);
        return imagePanel;
    }

    private class ValueCellEditor extends AbstractCellEditor implements TableCellEditor, Serializable {
        private static final long serialVersionUID = 1L;
        private JTextField textField;

        public ValueCellEditor() {
            textField = new JTextField();
            textField.setOpaque(true);
            textField.setEditable(false);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            textField.setText(value.toString());
            return textField;
        }

        @Override
        public Object getCellEditorValue() {
            return textField.getText();
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return false;
        }
    }

    private class ValueCellRenderer extends DefaultTableCellRenderer implements Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (value != null) {
                String cellValue = value.toString();
                if (cellValue.equals("+")) {
                    component.setBackground(Color.GREEN);
                } else if (cellValue.equals("-")) {
                    component.setBackground(Color.RED);
                } else if (cellValue.equals("0")) {
                    component.setBackground(Color.GRAY);
                } else {
                    component.setBackground(Color.WHITE);
                }
            } else {
                component.setBackground(Color.WHITE);
            }

            return component;
        }
    }

    public DefaultTableModel initializeTableView() {
        String[] columnHeaders = {"Element", "Rock", "Paper", "Scissors", "Optimal strategy"};

        // Initialize data for the table model
        List<Object[]> tableData = new ArrayList<Object[]>();
        tableData.add(new Object[]{"Rock", "0", "-", "+", "1/3"});
        tableData.add(new Object[]{"Paper", "+", "0", "-", "1/3"});
        tableData.add(new Object[]{"Scissors", "-", "+", "0", "1/3"});

        DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, 0);

        // Populate the table model with data
        for (Object[] rowData : tableData) {
            tableModel.addRow(rowData);
        }

        return tableModel;
    }
}
