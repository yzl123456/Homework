package lab10.Q2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RoseShop extends JFrame{
	final int WINDOW_WIDTH = 700;
	final int WINDOW_HEIGHT =470;
	//定义普通面板
	JPanel panelN;
	JPanel panelW;
	JPanel panelS;
	JPanel panelE;
	JPanel panelC;
	//定义按钮
	JButton choseButton;
	JButton resetButton;
	//JSlider数组
	JSlider[] jSlider=new JSlider[3];
	//左边区域的子panel数组
	JPanel[] sonJPanel=new JPanel[12];
	//中心调色的jpanel
	JPanel centerJPanel;
	//存放调完色的颜色数组
	List<Color>colors=new LinkedList<>();
	
	public RoseShop() {
		//设置窗体标题，大小，布局方式，及布局方式的间距
		this.setTitle("yzl Color Window");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLayout(new BorderLayout(15,35));
		
		//构造5个普通面板
		buildNorthPanel();
		buildWestPanel();
		buildCenterPanel();
		buildEastPanel();
		buildSubmitPanel();
		
		//将5个普通面板填充到JFrame的内容面板上
		add(panelN,BorderLayout.NORTH);
		add(panelW,BorderLayout.WEST);
		add(panelC, BorderLayout.CENTER);
		add(panelE,BorderLayout.EAST);
		add(panelS,BorderLayout.SOUTH);
		
		//设置可见
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void buildNorthPanel(){
		panelN=new JPanel();//创建普通视图
		JLabel jLabel=new JLabel("请在这里调色",SwingConstants.CENTER);//创建居中标签
		jLabel.setFont(new Font("宋体", Font.BOLD,18));//设置字体
		panelN.add(jLabel);//将组件添加到普通面板
	}
	
	public void buildWestPanel(){
		//添加布局和大小
		panelW=new JPanel(new BorderLayout());
		panelW.setPreferredSize(new Dimension(200, 400));
		//由于标签不能直接设置背景色，我这里是把标签放到jpanel中然后对jpanel设置背景
		JPanel labelPanel=new JPanel();
		labelPanel.setBackground(Color.yellow);
		JLabel jLabel=new JLabel("你的选择",SwingConstants.CENTER);
		labelPanel.add(jLabel);
		
		//将文字放到调色板北部
		panelW.add(labelPanel,BorderLayout.NORTH);
		//12个空白的调色框，同时设置边距
		JPanel gridPanel=new JPanel(new GridLayout(6, 2,2,2));
		gridPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		//放到中心
		panelW.add(gridPanel,BorderLayout.CENTER);
		//初始化12个调色框白色
		for(int i=0;i<12;i++){
			sonJPanel[i]=new JPanel();
			sonJPanel[i].setBackground(Color.WHITE);
			gridPanel.add(sonJPanel[i]);
		}
		
	}
	
	public void buildCenterPanel(){
		//创建中心panel背景为白色
		panelC=new JPanel(new GridLayout(1, 1));
		panelC.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		centerJPanel=new JPanel();
		centerJPanel.setBackground(Color.WHITE);
		panelC.add(centerJPanel);
	}
	
	public void buildEastPanel(){
		//创建东部panel
		panelE=new JPanel(new GridLayout(1, 3));
		panelE.setPreferredSize(new Dimension(200, 200));
		//设置标题边框
		LineBorder lbr=new LineBorder(Color.RED,3);
		panelE.setBorder(BorderFactory.createTitledBorder((lbr),"RGB"));
		//添加滑块组件，同时放到jpanel对象
		for(int i=0;i<3;i++){
			jSlider[i]=new JSlider(JSlider.VERTICAL, 0, 255, 255);
			jSlider[i].setMajorTickSpacing(51);
			jSlider[i].setMinorTickSpacing(17);
			jSlider[i].setPaintTicks(true);
			jSlider[i].setPaintLabels(true);
			jSlider[i].addChangeListener(new SliderListener());
			panelE.add(jSlider[i]);
		}
	}
	
	public void buildSubmitPanel(){
		//创建按钮对象
		panelS=new JPanel();
		choseButton=new JButton("就选它了");
		resetButton=new JButton("重置");
		//注册事件
		choseButton.addActionListener(new ChoseButtonListener());
		resetButton.addActionListener(new ResetButtonListener());
		//添加按钮到jpanel对象
		panelS.add(choseButton);
		panelS.add(resetButton);
		
	}
	private class SliderListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			//获取3个滑块的值存到num数组
			int []num=new int[3];
			for(int i=0;i<3;i++){
				num[i]=jSlider[i].getValue();
			}
			//给中心jpanle染色，每当滑块取值改变
			centerJPanel.setBackground(new Color(num[0], num[1], num[2]));	
		}
	}
	
	private class ChoseButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//获取中心jpanel的背景
			Color color=centerJPanel.getBackground();
			//添加到linklist里，下标为0
			colors.add(0, color);
			//若linklist存在color对象，则给左边区域的12块调色板赋背景
			for(int i=0;i<12;i++){
				if(i<colors.size())
				sonJPanel[i].setBackground(colors.get(i));
			}
		}		
	}
	
	private class ResetButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//清空linklist
			colors.clear();
			//初始化滑块值
			for(int i=0;i<3;i++){
				jSlider[i].setValue(255);
			}
			//初始化左边12个调色框
			for(int i=0;i<12;i++){
				sonJPanel[i].setBackground(Color.WHITE);
			}
		}		
	}
	
	
	public static void main(String[] args) {
		new RoseShop();
	}
}
