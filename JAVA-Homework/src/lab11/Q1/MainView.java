package lab11.Q1;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class MainView extends JFrame{
	JButton threadButton;
	JButton noThreadButton;
	JProgressBar progressBar;
	JPanel jPanel;
	JLabel jLabel;
	int i=0;
	public MainView() {
		super("Progress Bar");
		setBounds(300, 200, 320, 150); // ���Զ�λ�����С��λ��
		setLayout(new FlowLayout());
		// ���ô���Ĺرշ�ʽ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jPanel2=new JPanel();
		jLabel=new JLabel("0%");
		progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		progressBar.setBounds(50, 30, 200, 30); // ���ý�������λ�ü���С
		progressBar.setString("�������");
		progressBar.setStringPainted(true); // ��ʾ�������е����ֻ�ٷֱ�
		jPanel2.add(progressBar);
		jPanel2.add(jLabel);
		add(jPanel2,BorderLayout.NORTH); // ����������ӵ�����
		
		//������ť��jpanel��Ȼ����뵽JFrame��
		jPanel=new JPanel();
		threadButton=new JButton("�̷߳�ʽ����");

		noThreadButton=new JButton("���̷߳�ʽ����");

		jPanel.add(threadButton);
		jPanel.add(noThreadButton);
		
		add(jPanel, BorderLayout.SOUTH);
		
		setVisible(true); // ʹ�������
	}
	

	
	public static void main(String[] args) {
		new MainView();
	}
}
