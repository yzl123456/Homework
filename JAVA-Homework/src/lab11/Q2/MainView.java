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
		threadButton.addActionListener(new ThreadButtonListener());//注册事件
		noThreadButton=new JButton("非线程方式运行");
		noThreadButton.addActionListener(new ThreadButtonListener());
		jPanel.add(threadButton);
		jPanel.add(noThreadButton);
		
		add(jPanel, BorderLayout.SOUTH);
		
		setVisible(true); // 使窗体可视
	}
	
	private class ThreadButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==threadButton){//若事件是ThreadButton触发
				//个人还是比较喜欢直接new runnable接口并提供run方法的实现，我觉得构建一个类其实挺累赘的，毕竟只有一个run方法有用
				Thread t=new Thread(new Runnable() {
					@Override
					public void run() {
						while(i<20000){
							try {
								Thread.sleep(1);//睡眠
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							i++;
							progressBar.setValue(i/200);//设置进度条
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
