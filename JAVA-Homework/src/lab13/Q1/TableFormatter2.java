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
		// ���ô����С
		setSize(WIDTH, HEIGHT);
		setTitle("ѧ����Ϣ");

		// ���ô��岼��
		setLayout(new FlowLayout());

		// ���õ���رհ�ťʱ�����Ĳ���
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// ����table����
		JTable table = new JTable(data, colNames);

		// ����table�Ĺ����ӿڴ�С
		table.setPreferredScrollableViewportSize(new Dimension(400, 120));

		// �����п�
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.getColumnModel().getColumn(0).setPreferredWidth(60);
//		table.getColumnModel().getColumn(1).setPreferredWidth(170);
//		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		
		// �����и�
		table.setRowHeight(28);
		
		// ������ѡ���еı���ɫ
		table.setSelectionBackground(Color.LIGHT_GRAY);
		
		// ������ѡ���е�ǰ��ɫ
		table.setSelectionForeground(Color.RED);
		
		// Ϊ��������Ͽ�
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Indiana");
		comboBox.addItem("Washington");
		comboBox.addItem("California");
//		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBox));
		
		// ��table��ӹ������
		JScrollPane scrollPane = new JScrollPane(table);

		// �ѹ��������ӵ�����
		add(scrollPane);

		buildTextPanel();
		buildButtonPanel();
		
		add(textPanel);
		add(buttonPanel);
		
		// ��ʾ����
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
		jButtons[0]=new JButton("���");
		jButtons[1]=new JButton("�޸�");
		jButtons[2]=new JButton("ɾ��");
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