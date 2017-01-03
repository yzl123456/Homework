package lab12.Q4;

import javax.swing.*;
import java.awt.*;

/**
 * The TableFormatter class displays a populated JTable.
 */

public class TableFormatter extends JFrame {

	private static final long serialVersionUID = 1L;
	// Constants for size.
	private final int WIDTH = 600;
	private final int HEIGHT = 550;

	/**
	 * Constructor
	 */
	public TableFormatter(Object[][] data, Object[] colNames) {
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(400, 200); //设置显示窗口的位置
		// Create a JTable with the results.
		JTable table = new JTable(data, colNames);

		// Put the table in a scroll pane.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the table to the content pane.
		add(scrollPane, BorderLayout.CENTER);

		// Set the size and display.
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
}