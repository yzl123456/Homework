package lab11.Q3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MainView extends JFrame{
	//�������
	JLabel jLabel1;
	JLabel jLabel2;
	JLabel jLabel3;
	JTextField jTextField1;
	JTextField jTextField2;
	JTextField jTextField3;
	JButton jButton;
	JPanel buttonJpanel;
	JPanel labelJpanel;
	//ok�����������̵߳�run�����ģ�ok=falseʱrun�������߳��������ڽ���
	boolean ok=true;
	public MainView() {
		super("Progress Bar");
		setBounds(300, 200, 320, 150); // ���Զ�λ�����С��λ��
		// ���ô���Ĺرշ�ʽ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildButtonJpanel();
		buildLabelJpanel();
		//���2����ͨjpanel
		add(labelJpanel,BorderLayout.CENTER);
		add(buttonJpanel,BorderLayout.SOUTH);
		
		setVisible(true); // ʹ�������
	}
	void buildButtonJpanel(){
		//������ťjpanel
		buttonJpanel=new JPanel();
		jButton=new JButton("��ʼ");
		jButton.addActionListener(new ButtonActionListener());
		buttonJpanel.add(jButton);
	}
	void buildLabelJpanel(){
		//����label �� jpanel
		labelJpanel=new JPanel();
		labelJpanel.setLayout(new GridLayout(2, 3,10,3));
		
		jLabel1=new JLabel("�߳�һ",SwingConstants.CENTER);
		jLabel2=new JLabel("�̶߳�",SwingConstants.CENTER);
		jLabel3=new JLabel("�߳���",SwingConstants.CENTER);
		jTextField1=new JTextField(3);
		jTextField2=new JTextField(3);
		jTextField3=new JTextField(3);
		
		labelJpanel.add(jLabel1);
		labelJpanel.add(jLabel2);
		labelJpanel.add(jLabel3);
		labelJpanel.add(jTextField1);
		labelJpanel.add(jTextField2);
		labelJpanel.add(jTextField3);

	}
	//�õ������
	int getRandomNumber(){
		Random random=new Random();
		int number=random.nextInt(26);//����0-26���������nextINt Ϊ[0,26)
		//��Ŀδ��ȷӢ����ĸ�Ĵ�Сд����ֱ�Ӹ���number����ż�ж���
		if(number%2==0)//odd-> small
			return 'a'+number;
		else return 'A'+number;
		
	}
	public class ButtonActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str=jButton.getText();
			if(str=="��ʼ"){//�����ʼ
				ok=true;//��ʱ�߳�����
				doThread();//��3���̵߳Ĳ�����ȡ��1������
				jButton.setText("ֹͣ");//�ı�label
			}
			else{
				ok=false;//��ʱ�߳��������ڽ���
				jButton.setText("��ʼ");//�ı�label
			}
			
			
		}	
	}
	void doThread(){
		//���˻��ǱȽ�ϲ��ֱ��new��runnable�ӿ� ��дrun����������
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				while(ok){
					try {
						Thread.sleep(100);//˯100ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					char letter=(char)getRandomNumber();
					jTextField1.setText(letter+"");//���ַ�ת��Ϊ�ַ���
				}
			}
		});
		t1.start();//��ʼ
	
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				while(ok){
					try {
						Thread.sleep(100);//˯100ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					char letter=(char)getRandomNumber();
					jTextField2.setText(letter+"");//���ַ�ת��Ϊ�ַ���
				}
			}
		});
		t2.start();//��ʼ
		
		Thread t3=new Thread(new Runnable() {
			@Override
			public void run() {
				while(ok){
					try {
						Thread.sleep(100);//˯100ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					char letter=(char)getRandomNumber();
					jTextField3.setText(letter+"");//���ַ�ת��Ϊ�ַ���
				}
			}
		});
		t3.start();//��ʼ
	}
	
	public static void main(String[] args) {
		new MainView();
	}
}
