package lab11.Q2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		threadButton.addActionListener(new ThreadButtonListener());//ע���¼�
		noThreadButton=new JButton("���̷߳�ʽ����");
		noThreadButton.addActionListener(new ThreadButtonListener());
		jPanel.add(threadButton);
		jPanel.add(noThreadButton);
		
		add(jPanel, BorderLayout.SOUTH);
		
		setVisible(true); // ʹ�������
	}
	
	private class ThreadButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==threadButton){//���¼���ThreadButton����
				//���˻��ǱȽ�ϲ��ֱ��new runnable�ӿڲ��ṩrun������ʵ�֣��Ҿ��ù���һ������ʵͦ��׸�ģ��Ͼ�ֻ��һ��run��������
				Thread t=new Thread(new Runnable() {
					@Override
					public void run() {
						while(i<20000){
							try {
								Thread.sleep(1);//˯��
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							i++;
							progressBar.setValue(i/200);//���ý�����
							jLabel.setText(i/200+"%");
						}
					}
				});
				t.start();
			}
			else if(e.getSource()==noThreadButton){
				while(i<20000){
					i++;
					try {
						Thread.currentThread().sleep(1);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					progressBar.setValue(i/200);
					jLabel.setText(i/200+"%");
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		new MainView();
	}
}
