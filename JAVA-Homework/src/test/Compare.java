package test;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Compare extends JFrame{
	//�����С
	final private int WINDOW_WIDTH = 410;
	final private int WINDOW_HEIGHT = 130;
	private JPanel panel1;
	private JPanel panel2;
	private JButton threadButton;
	private JButton nothreadButton;
	private JProgressBar progress;
	private JLabel text;
	private double count=0;
	//���캯��
	public Compare(){
		//���ñ���
		this.setTitle("���߳�");
		//���ô�С
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//Ĭ���˳�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��������
		buildPanel();
		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		//���ÿɼ���
		this.setVisible(true);
	}
	//�������ݲ���
	private void buildPanel(){
		//������
		progress=new JProgressBar(0,100);
		progress.setStringPainted(true);
		progress.setString("��ɽ���");
		progress.setValue(0);
		//�ٷֱ�
		text=new JLabel("0%");
		//��ť
		threadButton=new JButton("�̷߳�ʽ����");
		nothreadButton=new JButton("���̷߳�ʽ����");
		threadButton.addActionListener(new ButtonSetsListener());
		nothreadButton.addActionListener(new ButtonSetsListener());
		panel1=new JPanel();
		panel2=new JPanel();
		panel1.add(progress);
		panel1.add(text);
		panel2.add(threadButton);
		panel2.add(nothreadButton);
	}
	//�ڲ���
	class TestThread extends Thread{
		public void run(){
			try{
				//��ȡ��ǰ�ٷֱ�
				count=progress.getPercentComplete();
				while(count<=100){
					count+=0.005;
					progress.setValue((int)count);
					sleep(1);
					text.setText((int)count+"%");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//�����¼�
	private class ButtonSetsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==threadButton){
				//�����߳�
				TestThread thread=new TestThread();
				thread.start();
			}
			if(e.getSource()==nothreadButton){
				while(count<=100){
					count=progress.getPercentComplete();
					System.out.println(count);
					count+=0.005;
					progress.setValue((int)count);
					System.out.println(count);
					text.setText(progress.getPercentComplete()+"%");
				}
			}
		}
	}
	//������
	public static void main(String[] args){
		new Compare();
	}
}
