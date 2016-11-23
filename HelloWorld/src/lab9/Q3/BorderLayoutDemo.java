package lab9.Q3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BorderLayoutDemo extends JFrame {//边界布局管理器
	//定义组件
	JLabel jLabel;
	JTextField jTextField;
	JButton forwardButton;
	JButton backwordButton;
	public BorderLayoutDemo() { // 构造函数，初始化对象值
		// 设置为边界布局，组件间横向、纵向间距均为5像素
		setLayout(new BorderLayout(5, 5));
		//设置字体
		setFont(new Font("Helvetica", Font.PLAIN, 14));

		JPanel jPanel1 = new JPanel();
		jLabel=new JLabel("click \"forward\" to run letter M ,click backword to reverse  ");
		jPanel1.add(jLabel);
		getContentPane().add("North", jPanel1); // 将jlabel添加到窗口中

		JPanel jPanel2 = new JPanel();
		jTextField=new JTextField(45);
		jPanel2.add(jTextField);
		getContentPane().add("Center", jPanel2); // 将Jtextfield添加到窗口中
		
		JPanel jPanel3 = new JPanel();
		forwardButton = new JButton("forward");
		backwordButton= new JButton("backword");
		jPanel3.add(forwardButton);//普通视图添加button
		jPanel3.add(backwordButton);
		getContentPane().add("South", jPanel3); // 将Jbutton添加到窗口中
		
		// 注册事件
		forwardButton.addActionListener(new ButtonListener());
		backwordButton.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==forwardButton){//判断事件的来源，若是forward
				String content=jTextField.getText();//得到文本内容
				jTextField.setText(content+"M");//设置内容+“M”
			}
			else if(e.getSource()==backwordButton){//若是backword
				String content=jTextField.getText();//得到文本内容
				if(content.length()>=1){//若长度》1表示能够往后删
					//设置文本为原来文本的串去掉最后一位
					jTextField.setText(content.substring(0, content.length()-1));
				}
			}

		}
	}

}
