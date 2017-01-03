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
		setBounds(300, 200, 320, 150); // 绝对定位窗体大小与位置
		setLayout(new FlowLayout());
		// 设置窗体的关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jPanel2=new JPanel();
		jLabel=new JLabel("0%");
		progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		progressBar.setBounds(50, 30, 200, 30); // 设置进度条的位置及大小
		progressBar.setString("正在完成");
		progressBar.setStringPainted(true); // 显示进度条中的文字或百分比
		jPanel2.add(progressBar);
		jPanel2.add(jLabel);
		add(jPanel2,BorderLayout.NORTH); // 将进度条添加到容器
		
		//构建按钮的jpanel，然后放入到JFrame中
		jPanel=new JPanel();
		threadButton=new JButton("线程方式运行");

		noThreadButton=new JButton("非线程方式运行");

		jPanel.add(threadButton);
		jPanel.add(noThreadButton);
		
		add(jPanel, BorderLayout.SOUTH);
		
		setVisible(true); // 使窗体可视
	}
	

	
	public static void main(String[] args) {
		new MainView();
	}
}
