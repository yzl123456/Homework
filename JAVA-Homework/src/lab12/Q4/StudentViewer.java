package lab12.Q4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StudentViewer extends JFrame{
	JTextArea jTextArea;
	JButton queryButton;
	JButton exitButton;
	JPanel jPanel;
	public StudentViewer() {
		setTitle("Student Viewer");//����һ������
		setSize(400, 300);
		buildPanel();//����jpanel
		add(jPanel);//��jpanel����jframe
		setVisible(true);
	}
	public void buildPanel(){
		jPanel=new JPanel();
		jTextArea=new JTextArea(11,35);
		jPanel.add(jTextArea);//�ı�����
		queryButton=new JButton("��ѯ");//��ť
		exitButton=new JButton("�˳�");
		queryButton.addActionListener(new ButtonActionListener());//ע���¼�
		exitButton.addActionListener(new ButtonActionListener());
		jPanel.add(queryButton);
		jPanel.add(exitButton);
	}
	public class ButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==queryButton){
				TestAccessDB2 selectTest=new TestAccessDB2();//new����
				selectTest.getConnection();//�õ�����
				new TableFormatter(selectTest.getTableData(jTextArea.getText()),selectTest.getNameCols(jTextArea.getText()));
				selectTest.closeConnection();//�ر�
			}
			else{
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new StudentViewer();
	}
	
}
