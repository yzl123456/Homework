package test;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * 创建窗体类
 */
public class UpdateResultSet extends JFrame {
	/**
     * 
     */
	private static final long serialVersionUID = -6462158531496637367L;
	private DefaultTableModel tableModel; // 定义表格模型对象
	private JTable table; // 定义表格对象
	private JScrollPane scrollPane;

	private JTextField aTextField;
	private JTextField bTextField;
	private JTextField cTextField;

	private JButton addButton;
	private JButton updButton;
	private JButton delButton;

	private ResultSet rs;

	private String[] columnNames; // 定义表格列名数组
	private String[][] tableValues; // 定义表格数据数组

	/**
	 * 构造方法，用于初始化组件
	 */
	public UpdateResultSet() {
		super();
		setTitle("Address Book");
		setBounds(100, 100, 700, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体的默认关闭模式

		// 连接数据库获取数据
		AccessDB accessDB = new AccessDB();
		accessDB.Connection();
		accessDB.queryInDB("select * from contactList");
		columnNames = accessDB.getNameColumns();
		tableValues = accessDB.getTableData();
		rs = accessDB.getResultSet();

		tableModel = new DefaultTableModel(tableValues, columnNames); // 创建表格模型
		table = new JTable(tableModel); // 创建指定表格模型的表格
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 设置表格的选择模式为单选
		table.addMouseListener(new ClickOnTable());

		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		JPanel insertPanel = new JPanel();
		insertPanel.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Name："));
		aTextField = new JTextField(12);
		panel.add(aTextField);
		panel.add(new JLabel("Telephone："));
		bTextField = new JTextField(12);
		panel.add(bTextField);
		panel.add(new JLabel("Address: "));
		cTextField = new JTextField(12);
		panel.add(cTextField);
		insertPanel.add(panel, BorderLayout.NORTH);
		

		JPanel buttonPanel = new JPanel();
		addButton = new JButton("添加");
		addButton.addActionListener(new AddListener());
		buttonPanel.add(addButton);

		updButton = new JButton("修改");
		updButton.addActionListener(new UpdateListener());
		buttonPanel.add(updButton);

		delButton = new JButton("删除");
		delButton.addActionListener(new DeleteListener());
		buttonPanel.add(delButton);
		insertPanel.add(buttonPanel, BorderLayout.CENTER);

		add(insertPanel, BorderLayout.SOUTH); // 把面板添加到窗体下面
	}

	// ****************下面为事件监听器，即事件响应***********************
	public class ClickOnTable extends MouseAdapter {
		public void mouseClicked(MouseEvent e) { // 发生了点击事件
			int selectedRow = table.getSelectedRow(); // 获得被选中行的索引
			// 把table中的行号转换成table model中的行号
			int tableModelRow = table.convertRowIndexToModel(selectedRow);
			Object oa = tableModel.getValueAt(tableModelRow, 0); // 从表格模型中获得指定值
			Object ob = tableModel.getValueAt(tableModelRow, 1); // 从表格模型中获得指定值
			Object oc = tableModel.getValueAt(tableModelRow, 2); // 从表格模型中获得指定值
			aTextField.setText(oa.toString()); // 将获得的值赋值给文本框
			bTextField.setText(ob.toString()); // 将获得的值赋值给文本框
			cTextField.setText(oc.toString()); // 将获得的值赋值给文本框
			
		}
	}

	public class AddListener implements ActionListener {
		//@Override
		public void actionPerformed(ActionEvent arg0) {
			// 创建表格行数组
			String[] rowValues = {aTextField.getText(), bTextField.getText(),
					cTextField.getText()};
			// 向表格模型中添加一行
			tableModel.addRow(rowValues); 
			try {
				// 修改结果集数据
				rs.moveToInsertRow();
				for (int i = 0; i <tableModel.getColumnCount(); i++) {
					rs.updateString(i+2, rowValues[i]);
				}
				rs.insertRow();
				JOptionPane.showMessageDialog(null, "成功插入记录");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
		}
	}

	public class UpdateListener implements ActionListener {
		//@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = table.getSelectedRow(); // 获得被选中行的索引 (table，table
														// model索引从0开始)
			
			if (selectedRow != -1) { // 判断是否存在被选中行
				try {
					rs.absolute(selectedRow + 1);
					
					// 修改结果集数据
					rs.updateString(2, (String) tableModel.getValueAt(selectedRow, 0));							
					rs.updateString(3, (String) tableModel.getValueAt(selectedRow, 1));
					rs.updateString(4, (String) tableModel.getValueAt(selectedRow, 2));					
					rs.updateRow();
					// 更新textField
					aTextField.setText((String) tableModel.getValueAt(selectedRow, 0));
					bTextField.setText((String) tableModel.getValueAt(selectedRow, 1));
					cTextField.setText((String) tableModel.getValueAt(selectedRow, 2));
					JOptionPane.showMessageDialog(null, "更新成功");

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	public class DeleteListener implements ActionListener {
		//@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = table.getSelectedRow(); // 获得被选中行的索引
			try {
				rs.absolute(selectedRow + 1);
				if (selectedRow != -1){ // 判断是否存在被选中行
					tableModel.removeRow(selectedRow); // 从表格模型当中删除指定行
				}
				rs.deleteRow();
				JOptionPane.showMessageDialog(null, "记录成功删除");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// *******************应用程序入口函数************************
	public static void main(String args[]) {
		UpdateResultSet frame = new UpdateResultSet();
		frame.setVisible(true);
	}

}
