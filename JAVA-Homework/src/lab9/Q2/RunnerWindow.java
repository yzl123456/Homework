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
	//定义常量属性
	final int WINDOW_WIDTH = 600;
	final int WINDOW_HEIGHT = 200;
	//定义组件
	private JLabel jLabel;
	private JTextField jTextField;
	private JButton jButton;
	//定义普通面板
	private JPanel jPanel;
	public RunnerWindow() {
		//构造器先初始化完一些常用属性，注意setvisable一定要放在最后，添加完组件在visable，不然显示不了组件
		this.setTitle("Runner Window");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将添加组件的内容抽取成一个方法
		bulidPanel();
		//将普通面板添加到JFrame的内容面板上，此处的add方法是继承过来的
		add(jPanel); 
		//最后在显示这个窗口
		this.setVisible(true);
	}
	private void bulidPanel(){
		//new 3个组件，分别设置他们的属性
		jLabel = new JLabel("this window displays the running letter");
		jTextField = new JTextField(45);
		jButton = new JButton("stop the process");
		//注册事件
		jButton.addActionListener(new StopButtonListener());
		//new 普通面板
		jPanel=new JPanel();
		//将组件添加到普通面板
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jButton);	
	}
	private class StopButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "the program exits!");
			System.exit(0);//退出程序
		}
	}
}
