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
 * ����������
 */
public class UpdateResultSet extends JFrame {
	/**
     * 
     */
	private static final long serialVersionUID = -6462158531496637367L;
	private DefaultTableModel tableModel; // ������ģ�Ͷ���
	private JTable table; // ���������
	private JScrollPane scrollPane;

	private JTextField aTextField;
	private JTextField bTextField;
	private JTextField cTextField;

	private JButton addButton;
	private JButton updButton;
	private JButton delButton;

	private ResultSet rs;

	private String[] columnNames; // ��������������
	private String[][] tableValues; // ��������������

	/**
	 * ���췽�������ڳ�ʼ�����
	 */
	public UpdateResultSet() {
		super();
		setTitle("Address Book");
		setBounds(100, 100, 700, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô����Ĭ�Ϲر�ģʽ

		// �������ݿ��ȡ����
		AccessDB accessDB = new AccessDB();
		accessDB.Connection();
		accessDB.queryInDB("select * from contactList");
		columnNames = accessDB.getNameColumns();
		tableValues = accessDB.getTableData();
		rs = accessDB.getResultSet();

		tableModel = new DefaultTableModel(tableValues, columnNames); // �������ģ��
		table = new JTable(tableModel); // ����ָ�����ģ�͵ı��
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ���ñ���ѡ��ģʽΪ��ѡ
		table.addMouseListener(new ClickOnTable());

		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		JPanel insertPanel = new JPanel();
		insertPanel.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Name��"));
		aTextField = new JTextField(12);
		panel.add(aTextField);
		panel.add(new JLabel("Telephone��"));
		bTextField = new JTextField(12);
		panel.add(bTextField);
		panel.add(new JLabel("Address: "));
		cTextField = new JTextField(12);
		panel.add(cTextField);
		insertPanel.add(panel, BorderLayout.NORTH);
		

		JPanel buttonPanel = new JPanel();
		addButton = new JButton("���");
		addButton.addActionListener(new AddListener());
		buttonPanel.add(addButton);

		updButton = new JButton("�޸�");
		updButton.addActionListener(new UpdateListener());
		buttonPanel.add(updButton);

		delButton = new JButton("ɾ��");
		delButton.addActionListener(new DeleteListener());
		buttonPanel.add(delButton);
		insertPanel.add(buttonPanel, BorderLayout.CENTER);

		add(insertPanel, BorderLayout.SOUTH); // �������ӵ���������
	}

	// ****************����Ϊ�¼������������¼���Ӧ***********************
	public class ClickOnTable extends MouseAdapter {
		public void mouseClicked(MouseEvent e) { // �����˵���¼�
			int selectedRow = table.getSelectedRow(); // ��ñ�ѡ���е�����
			// ��table�е��к�ת����table model�е��к�
			int tableModelRow = table.convertRowIndexToModel(selectedRow);
			Object oa = tableModel.getValueAt(tableModelRow, 0); // �ӱ��ģ���л��ָ��ֵ
			Object ob = tableModel.getValueAt(tableModelRow, 1); // �ӱ��ģ���л��ָ��ֵ
			Object oc = tableModel.getValueAt(tableModelRow, 2); // �ӱ��ģ���л��ָ��ֵ
			aTextField.setText(oa.toString()); // ����õ�ֵ��ֵ���ı���
			bTextField.setText(ob.toString()); // ����õ�ֵ��ֵ���ı���
			cTextField.setText(oc.toString()); // ����õ�ֵ��ֵ���ı���
			
		}
	}

	public class AddListener implements ActionListener {
		//@Override
		public void actionPerformed(ActionEvent arg0) {
			// �������������
			String[] rowValues = {aTextField.getText(), bTextField.getText(),
					cTextField.getText()};
			// ����ģ�������һ��
			tableModel.addRow(rowValues); 
			try {
				// �޸Ľ��������
				rs.moveToInsertRow();
				for (int i = 0; i <tableModel.getColumnCount(); i++) {
					rs.updateString(i+2, rowValues[i]);
				}
				rs.insertRow();
				JOptionPane.showMessageDialog(null, "�ɹ������¼");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
		}
	}

	public class UpdateListener implements ActionListener {
		//@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = table.getSelectedRow(); // ��ñ�ѡ���е����� (table��table
														// model������0��ʼ)
			
			if (selectedRow != -1) { // �ж��Ƿ���ڱ�ѡ����
				try {
					rs.absolute(selectedRow + 1);
					
					// �޸Ľ��������
					rs.updateString(2, (String) tableModel.getValueAt(selectedRow, 0));							
					rs.updateString(3, (String) tableModel.getValueAt(selectedRow, 1));
					rs.updateString(4, (String) tableModel.getValueAt(selectedRow, 2));					
					rs.updateRow();
					// ����textField
					aTextField.setText((String) tableModel.getValueAt(selectedRow, 0));
					bTextField.setText((String) tableModel.getValueAt(selectedRow, 1));
					cTextField.setText((String) tableModel.getValueAt(selectedRow, 2));
					JOptionPane.showMessageDialog(null, "���³ɹ�");

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
			int selectedRow = table.getSelectedRow(); // ��ñ�ѡ���е�����
			try {
				rs.absolute(selectedRow + 1);
				if (selectedRow != -1){ // �ж��Ƿ���ڱ�ѡ����
					tableModel.removeRow(selectedRow); // �ӱ��ģ�͵���ɾ��ָ����
				}
				rs.deleteRow();
				JOptionPane.showMessageDialog(null, "��¼�ɹ�ɾ��");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// *******************Ӧ�ó�����ں���************************
	public static void main(String args[]) {
		UpdateResultSet frame = new UpdateResultSet();
		frame.setVisible(true);
	}

}
