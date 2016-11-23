package lab9.Q2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RunnerWindow extends JFrame{
	//���峣������
	final int WINDOW_WIDTH = 600;
	final int WINDOW_HEIGHT = 200;
	//�������
	private JLabel jLabel;
	private JTextField jTextField;
	private JButton jButton;
	//������ͨ���
	private JPanel jPanel;
	public RunnerWindow() {
		//�������ȳ�ʼ����һЩ�������ԣ�ע��setvisableһ��Ҫ�����������������visable����Ȼ��ʾ�������
		this.setTitle("Runner Window");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�������������ݳ�ȡ��һ������
		bulidPanel();
		//����ͨ�����ӵ�JFrame����������ϣ��˴���add�����Ǽ̳й�����
		add(jPanel); 
		//�������ʾ�������
		this.setVisible(true);
	}
	private void bulidPanel(){
		//new 3��������ֱ��������ǵ�����
		jLabel = new JLabel("this window displays the running letter");
		jTextField = new JTextField(45);
		jButton = new JButton("stop the process");
		//ע���¼�
		jButton.addActionListener(new StopButtonListener());
		//new ��ͨ���
		jPanel=new JPanel();
		//�������ӵ���ͨ���
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jButton);	
	}
	private class StopButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "the program exits!");
			System.exit(0);//�˳�����
		}
	}
}
