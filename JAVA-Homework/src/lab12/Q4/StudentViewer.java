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
		setTitle("Student Viewer");//设置一般属性
		setSize(400, 300);
		buildPanel();//构造jpanel
		add(jPanel);//将jpanel加入jframe
		setVisible(true);
	}
	public void buildPanel(){
		jPanel=new JPanel();
		jTextArea=new JTextArea(11,35);
		jPanel.add(jTextArea);//文本区域
		queryButton=new JButton("查询");//按钮
		exitButton=new JButton("退出");
		queryButton.addActionListener(new ButtonActionListener());//注册事件
		exitButton.addActionListener(new ButtonActionListener());
		jPanel.add(queryButton);
		jPanel.add(exitButton);
	}
	public class ButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==queryButton){
				TestAccessDB2 selectTest=new TestAccessDB2();//new对象
				selectTest.getConnection();//得到连接
				new TableFormatter(selectTest.getTableData(jTextArea.getText()),selectTest.getNameCols(jTextArea.getText()));
				selectTest.closeConnection();//关闭
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
