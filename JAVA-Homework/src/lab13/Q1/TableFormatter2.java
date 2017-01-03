package lab13.Q1;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;

/**
 * The TableFormatter class displays a populated JTable.
 */

public class TableFormatter2 extends JFrame {

	private static final long serialVersionUID = 1L;
	// Constants for size.
	private final int WIDTH = 600;
	private final int HEIGHT = 300;
	
	JPanel textPanel;
	JPanel buttonPanel;
	JLabel[] jLabels=new JLabel[3];
	JTextField[] jTextField=new JTextField[3];
	JButton[] jButtons=new JButton[3];
	/**
	 * Constructor
	 */
	public TableFormatter2(Object[][] data, Object[] colNames) {
		// 设置窗体大小
		setSize(WIDTH, HEIGHT);
		setTitle("学生信息");

		// 设置窗体布局
		setLayout(new FlowLayout());

		// 设置点击关闭按钮时触发的操作
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 建立table对象
		JTable table = new JTable(data, colNames);

		// 设置table的滚动视口大小
		table.setPreferredScrollableViewportSize(new Dimension(400, 120));

		// 设置列宽
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.getColumnModel().getColumn(0).setPreferredWidth(60);
//		table.getColumnModel().getColumn(1).setPreferredWidth(170);
//		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		
		// 设置行高
		table.setRowHeight(28);
		
		// 设置所选择行的背景色
		table.setSelectionBackground(Color.LIGHT_GRAY);
		
		// 设置所选择行的前景色
		table.setSelectionForeground(Color.RED);
		
		// 为列设置组合框
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Indiana");
		comboBox.addItem("Washington");
		comboBox.addItem("California");
//		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBox));
		
		// 把table添加滚动面板
		JScrollPane scrollPane = new JScrollPane(table);

		// 把滚动面板添加到窗体
		add(scrollPane);

		buildTextPanel();
		buildButtonPanel();
		
		add(textPanel);
		add(buttonPanel);
		
		// 显示窗体
		setVisible(true);
	}
	
	public void buildTextPanel(){
		textPanel=new JPanel();
		jLabels[0]=new JLabel("Name:");
		jLabels[1]=new JLabel("Telephone:");
		jLabels[2]=new JLabel("Address:");
		jTextField[0]=new JTextField(8);
		jTextField[1]=new JTextField(8);
		jTextField[2]=new JTextField(8);
		for(int i=0;i<3;i++){
			textPanel.add(jLabels[i]);
			textPanel.add(jTextField[i]);
		}
	}
	public void buildButtonPanel(){
		buttonPanel=new JPanel(new BorderLayout());
		JPanel jPanel=new JPanel();
		jButtons[0]=new JButton("添加");
		jButtons[1]=new JButton("修改");
		jButtons[2]=new JButton("删除");
		for(int i=0;i<3;i++){
			jPanel.add(jButtons[i]);
		}
		buttonPanel.add(jPanel,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		String[] colNames = { "A", "B", "C","D","E","F","G" };
		String[][] rowData =new String[12][7];
		new TableFormatter2(rowData, colNames);

	}

}