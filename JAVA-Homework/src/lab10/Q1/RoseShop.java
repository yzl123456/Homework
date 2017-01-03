package lab10.Q1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class RoseShop extends JFrame{
	final int WINDOW_WIDTH = 700;
	final int WINDOW_HEIGHT =470;
	//定义普通面板
	JPanel titlePanel;
	JPanel deliverPanel;
	JPanel productPanel;
	JPanel pricePanel;
	JPanel submitPanel;
	//定义按钮
	JButton calButton;
	JButton initButton;
	//定义复选框
	JCheckBox jCheckBox1;
	JCheckBox jCheckBox2;
	JCheckBox jCheckBox3;
	//定义单选框
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	JRadioButton radioButton3;
	public RoseShop() {
		//设置窗体标题，大小，布局方式，及布局方式的间距
		this.setTitle("yzl Rose Window");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLayout(new BorderLayout(15,35));
		
		//构造5个普通面板
		buildTitlePanel();
		buildDeliverPanel();
		buildProductPanel();
		buildPricePanel();
		buildSubmitPanel();
		
		//将5个普通面板填充到JFrame的内容面板上
		add(titlePanel,BorderLayout.NORTH);
		add(deliverPanel,BorderLayout.WEST);
		add(productPanel, BorderLayout.CENTER);
		add(pricePanel,BorderLayout.EAST);
		add(submitPanel,BorderLayout.SOUTH);
		
		//设置可见
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void buildTitlePanel(){
		titlePanel=new JPanel();//创建普通视图
		JLabel jLabel=new JLabel("我们为您提供最优质的服务",SwingConstants.CENTER);//创建居中标签
		jLabel.setFont(new Font("宋体", Font.BOLD,18));//设置字体
		titlePanel.add(jLabel);//将组件添加到普通面板
	}
	
	public void buildDeliverPanel(){
		deliverPanel=new JPanel(new GridLayout(4,1));//创建普通视图并设置布局为网格4*1
		deliverPanel.setPreferredSize(new Dimension(200,400));//设置视图的大小
		deliverPanel.setBorder(BorderFactory.createLineBorder(Color.red, 5));//设置字体
		//创建标签组件
		JLabel jLabel=new JLabel("选择你的邮递方式",SwingConstants.CENTER);
		jLabel.setFont(new Font("宋体",Font.BOLD,14));
		//创建一套单选框
		radioButton1=new JRadioButton("快递",true);
		radioButton2=new JRadioButton("普邮");
		radioButton3=new JRadioButton("自提");
		//给一套单选框设置字体及颜色
		radioButton1.setFont(new Font("宋体",Font.BOLD,14));
		radioButton1.setForeground(Color.blue);
		radioButton2.setFont(new Font("宋体",Font.BOLD,14));
		radioButton2.setForeground(Color.blue);
		radioButton3.setFont(new Font("宋体",Font.BOLD,14));
		radioButton3.setForeground(Color.blue);
		//一套单选框加入到buttonGroup使其互斥
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		//创建价格标签
		JLabel labelPrice1=new JLabel("10R");
		JLabel labelPrice2=new JLabel("5R");
		JLabel labelPrice3=new JLabel("0R");
		//创建3个普通面板
		JPanel row1Panel=new JPanel();
		JPanel row2Panel=new JPanel();
		JPanel row3Panel=new JPanel();
		//每个面板放一个单选框
		row1Panel.add(radioButton1);
		row1Panel.add(labelPrice1);
		row2Panel.add(radioButton2);
		row2Panel.add(labelPrice2);
		row3Panel.add(radioButton3);
		row3Panel.add(labelPrice3);
		//在普通视图上添加3个子普通视图及标签
		deliverPanel.add(jLabel);
		deliverPanel.add(row1Panel);
		deliverPanel.add(row2Panel);
		deliverPanel.add(row3Panel);
	}
	
	public void buildProductPanel(){
		//创建普通视图及设置其布局网格4*1
		productPanel=new JPanel(new GridLayout(4, 1));
		//设置此普通视图大小，边框，背景色
		productPanel.setPreferredSize(new Dimension(200, 200));
		productPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		productPanel.setBackground(Color.yellow);
		//创建居中标签
		JLabel jLabel=new JLabel("请选择你需要的商品",SwingConstants.CENTER);
		//创建一套复选框
		jCheckBox1=new JCheckBox("11朵玫瑰 --------------->");
		jCheckBox2=new JCheckBox("精美包装盒-------------->");
		jCheckBox3=new JCheckBox("贺卡------------------------>");
		//设置复选框颜色
		jCheckBox1.setBackground(Color.yellow);
		jCheckBox2.setBackground(Color.yellow);
		jCheckBox3.setBackground(Color.yellow);
		//添加复选框到此普通面板
		productPanel.add(jLabel);
		productPanel.add(jCheckBox1);
		productPanel.add(jCheckBox2);
		productPanel.add(jCheckBox3);
	}
	
	public void buildPricePanel(){
		//创建普通视图及设置其布局网格4*1
		pricePanel=new JPanel(new GridLayout(4, 1));
		//设置此普通视图大小，边框，背景色
		pricePanel.setPreferredSize(new Dimension(200, 400));
		pricePanel.setBackground(Color.green);
		//创建标签
		JLabel jLabel=new JLabel("商品价格",SwingConstants.CENTER);
		JLabel jLabelPrice1=new JLabel("108元");
		JLabel jLabelPrice2=new JLabel("28元");
		JLabel jLabelPrice3=new JLabel("8元");
		//设置标签颜色
		jLabel.setBackground(Color.GREEN);
		jLabelPrice1.setBackground(Color.GREEN);
		jLabelPrice2.setBackground(Color.GREEN);
		jLabelPrice3.setBackground(Color.GREEN);
		//将标签添加到普通面板
		pricePanel.add(jLabel);
		pricePanel.add(jLabelPrice1);
		pricePanel.add(jLabelPrice2);
		pricePanel.add(jLabelPrice3);
	}
	
	public void buildSubmitPanel(){
		//创建放按钮的普通面板
		submitPanel=new JPanel();
		//创建2个按钮
		calButton=new JButton("计算");
		initButton=new JButton("重置");
		//为2个按钮注册2个不同的时间（其实我觉得放一个事件里也行，通过getsource判断）
		calButton.addActionListener(new CalButtonListener());
		initButton.addActionListener(new ResetButtonListener());
		//向普通面板里添加2个按钮组件
		submitPanel.add(calButton);
		submitPanel.add(initButton);
		
	}
	private class CalButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double money=0;//计算价格
			if(e.getSource()==calButton){//若事件是计算按钮触发的
				if(radioButton1.isSelected()){//判断邮递费用
					money+=10;
				}
				else if(radioButton2.isSelected()){
					money+=5;
				}
				else if(radioButton3.isSelected()){
					money+=0;
				}
				
				if(jCheckBox1.isSelected()){//判断商品费用
					money+=108;
				}
				if(jCheckBox2.isSelected()){
					money+=28;
				}
				if(jCheckBox3.isSelected()){
					money+=8;
				}
				//弹出对话框
				JOptionPane.showMessageDialog(submitPanel,"总价为："+money);	
			}
		}		
	}
	
	private class ResetButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==initButton){//若事件是初始化按钮出发
				radioButton1.setSelected(true);//单选框初始化
				
				jCheckBox1.setSelected(false);//复选框初始化
				jCheckBox2.setSelected(false);
				jCheckBox3.setSelected(false);
				
				
			}
			
		}		
	}
	
	
	public static void main(String[] args) {
		new RoseShop();
	}
}
