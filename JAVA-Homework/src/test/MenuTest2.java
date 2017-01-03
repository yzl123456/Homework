package test;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;


public class MenuTest2 extends JFrame {
	final int WINDOW_WIDTH = 500;
	final int WINDOW_HEIGHT = 200;

	private JMenuBar menuBar;
	private JMenu fileMenu, textMenu;
	private JMenuItem exitItem;
	private JRadioButtonMenuItem blackItem;
	private JRadioButtonMenuItem redItem;
	private JRadioButtonMenuItem blueItem;
	private JLabel label;
	private JCheckBoxMenuItem visible;
	
	private ButtonGroup group;

	public MenuTest2() {
		// set title for the window
		setTitle("Menu Test");

		// set size and location for the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// specify the action for the close button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		// build a menu bar
		buildMenuBar();

		// add the menu bar to the window
		setJMenuBar(menuBar);
		
		// add a label
		label = new JLabel("Give me some color see see", SwingConstants.CENTER);
		label.setFont(new Font("ËÎÌו", Font.BOLD, 24));
		add(label);
		
		// show the window
		setVisible(true);
	}

	public void buildMenuBar() {
		// create a menu bar
		menuBar = new JMenuBar();
		
		// create a File menu
		buildFileMenu();
		
		// create a Text menu
		buildTextMenu();
		
		// add the file menu and text menu to the menu bar
		menuBar.add(fileMenu);
		menuBar.add(textMenu);
	}

	public void buildFileMenu() {
		// create file menu
		fileMenu = new JMenu("File");
		
		// create exit menu item
		exitItem = new JMenuItem("exit");
		
		// add the exit menu item to the file menu
		fileMenu.add(exitItem);	
		
		// add register action listener for exitItem
		exitItem.addActionListener(new ExitItemListener());
	}

	public void buildTextMenu() {
		// create text menu
		textMenu = new JMenu("Text");
		
		// create the black, red, and blue menu items
		blackItem = new JRadioButtonMenuItem("black", true);
		redItem = new JRadioButtonMenuItem("red");
		blueItem = new JRadioButtonMenuItem("blue");
		
		// group the radio button items
		group = new ButtonGroup();
		group.add(blackItem);
		group.add(redItem);
		group.add(blueItem);
		
		// create visible item
		visible = new JCheckBoxMenuItem("visible", true);
		visible.addActionListener(new VisibleItemListener());
		
		// put the menu items in the text menu
		textMenu.add(blackItem);
		textMenu.add(redItem);
		textMenu.add(blueItem);
		textMenu.addSeparator();
		textMenu.add(visible);
		
		// register action listener for the items
		blackItem.addActionListener(new ColorItemsListener());
		redItem.addActionListener(new ColorItemsListener());
		blueItem.addActionListener(new ColorItemsListener());
	}

	public class ExitItemListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);			
		}
		
	}
	
	public class ColorItemsListener implements ActionListener{
		//@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == blackItem){
				label.setForeground(Color.BLACK);
			}
			else if(e.getSource()== redItem){
				label.setForeground(Color.RED);
			}
			else if(e.getSource() == blueItem){
				label.setForeground(Color.BLUE);
			}
			
		}
		
	}
	
	public class VisibleItemListener implements ActionListener{
		//@Override
		public void actionPerformed(ActionEvent arg0) {
			if(visible.isSelected()){
				label.setVisible(true);
			}
			else{
				label.setVisible(false);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new MenuTest2();

	}

}
