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
	//窗体大小
	final private int WINDOW_WIDTH = 410;
	final private int WINDOW_HEIGHT = 130;
	private JPanel panel1;
	private JPanel panel2;
	private JButton threadButton;
	private JButton nothreadButton;
	private JProgressBar progress;
	private JLabel text;
	private double count=0;
	//构造函数
	public Compare(){
		//设置标题
		this.setTitle("多线程");
		//设置大小
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//默认退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//创建内容
		buildPanel();
		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		//设置可见性
		this.setVisible(true);
	}
	//创建内容布局
	private void buildPanel(){
		//进度条
		progress=new JProgressBar(0,100);
		progress.setStringPainted(true);
		progress.setString("完成进度");
		progress.setValue(0);
		//百分比
		text=new JLabel("0%");
		//按钮
		threadButton=new JButton("线程方式运行");
		nothreadButton=new JButton("非线程方式运行");
		threadButton.addActionListener(new ButtonSetsListener());
		nothreadButton.addActionListener(new ButtonSetsListener());
		panel1=new JPanel();
		panel2=new JPanel();
		panel1.add(progress);
		panel1.add(text);
		panel2.add(threadButton);
		panel2.add(nothreadButton);
	}
	//内部类
	class TestThread extends Thread{
		public void run(){
			try{
				//获取当前百分比
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
	//处理事件
	private class ButtonSetsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==threadButton){
				//开启线程
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
	//主函数
	public static void main(String[] args){
		new Compare();
	}
}
