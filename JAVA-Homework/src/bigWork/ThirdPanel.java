package bigWork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bigWork.global.Global;
import bigWork.user.entity.User;
import bigWork.user.service.UserService;
import bigWork.utils.CtxUtils;


//@SuppressWarnings("serial")
public class ThirdPanel extends JPanel{
	private JLabel title;
	private JPanel northPanel;
	JPanel centerPanel;
	JPanel southPanel;
	JLabel jLabel1;
	JLabel jLabel2;
	JLabel jLabel3;
	JTextField jTextField1;
	JTextField jTextField2;
	JTextField jTextField3;
	JButton jButton;
	
	UserService userService=CtxUtils.getUserService();
	public ThirdPanel(){
		buildNorthPanel();
		buildCenterPanel();
		buildSouthPanel();
		
	    // 把标题面板加入first panel面板
		this.add(northPanel, BorderLayout.NORTH);
//		this.add(southPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
	}	
	public void buildNorthPanel(){
		// 创建标题面板
		northPanel = new JPanel();
		
		// 设置标题面板的大小
		northPanel.setPreferredSize(new Dimension(600, 140));
		
		// 设置标题面板上下左右的边距
		northPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		
		// 设置标题的字体及大小
		title = new JLabel("修改密码", SwingConstants.CENTER);
		title.setFont(new Font("宋体", Font.BOLD, 28));
		
		// 把标题加入标题面板
		northPanel.add(title);
	}
	public void buildCenterPanel(){
		centerPanel=new JPanel(new GridLayout(4, 2,10,50));
		jLabel1=new JLabel("请输入旧密码:  ");
		jLabel2=new JLabel("请输入新密码:  ");
		jLabel3=new JLabel("再次输入新密码:");
		jTextField1=new JPasswordField(10);
		jTextField2=new JPasswordField(10);
		jTextField3=new JPasswordField(10);
		centerPanel.add(jLabel1);
		centerPanel.add(jTextField1);
		centerPanel.add(jLabel2);
		centerPanel.add(jTextField2);
		centerPanel.add(jLabel3);
		centerPanel.add(jTextField3);
		
		jButton=new JButton("确定");
		jButton.addActionListener(new ButtonActionListener());
//		centerPanel.add(new JLabel(""));
		centerPanel.add(jButton);
		
	}
	public void buildSouthPanel(){
//		southPanel=new JPanel();
//		jButton=new JButton("确定");
//		southPanel.add(jButton);
	}
	public class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			User user=Global.getUser();
			if(!jTextField1.getText().equals(user.getPassword())){
				JOptionPane.showMessageDialog(jButton, "旧密码输入错误");
				jTextField1.setText("");
				return ;
			}
			
			if(jTextField2.getText().equals(jTextField3.getText())){
				
				user.setPassword(jTextField2.getText());
				userService.saveAndFlush(user);
				JOptionPane.showMessageDialog(jButton, "密码修改成功");
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
			}
			else{
				JOptionPane.showMessageDialog(jButton, "两次输入密码不一致");
			}
			
			
		}
	}
	
}
