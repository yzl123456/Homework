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
	//组件声明
	JLabel jLabel1;
	JLabel jLabel2;
	JLabel jLabel3;
	JTextField jTextField1;
	JTextField jTextField2;
	JTextField jTextField3;
	JButton jButton;
	JPanel buttonJpanel;
	JPanel labelJpanel;
	//ok是用来控制线程的run方法的，ok=false时run结束，线程生命周期结束
	boolean ok=true;
	public MainView() {
		super("Progress Bar");
		setBounds(300, 200, 320, 150); // 绝对定位窗体大小与位置
		// 设置窗体的关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildButtonJpanel();
		buildLabelJpanel();
		//添加2个普通jpanel
		add(labelJpanel,BorderLayout.CENTER);
		add(buttonJpanel,BorderLayout.SOUTH);
		
		setVisible(true); // 使窗体可视
	}
	void buildButtonJpanel(){
		//构建按钮jpanel
		buttonJpanel=new JPanel();
		jButton=new JButton("开始");
		jButton.addActionListener(new ButtonActionListener());
		buttonJpanel.add(jButton);
	}
	void buildLabelJpanel(){
		//构建label 的 jpanel
		labelJpanel=new JPanel();
		labelJpanel.setLayout(new GridLayout(2, 3,10,3));
		
		jLabel1=new JLabel("线程一",SwingConstants.CENTER);
		jLabel2=new JLabel("线程二",SwingConstants.CENTER);
		jLabel3=new JLabel("线程三",SwingConstants.CENTER);
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
	//得到随机数
	int getRandomNumber(){
		Random random=new Random();
		int number=random.nextInt(26);//生成0-26的随机数，nextINt 为[0,26)
		//题目未明确英文字母的大小写，我直接根据number的奇偶判断了
		if(number%2==0)//odd-> small
			return 'a'+number;
		else return 'A'+number;
		
	}
	public class ButtonActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str=jButton.getText();
			if(str=="开始"){//点击开始
				ok=true;//此时线程运行
				doThread();//将3个线程的操作抽取成1个方法
				jButton.setText("停止");//改变label
			}
			else{
				ok=false;//此时线程生命周期结束
				jButton.setText("开始");//改变label
			}
			
			
		}	
	}
	void doThread(){
		//个人还是比较喜欢直接new个runnable接口 重写run方法。。。
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				while(ok){
					try {
						Thread.sleep(100);//睡100ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					char letter=(char)getRandomNumber();
					jTextField1.setText(letter+"");//将字符转化为字符串
				}
			}
		});
		t1.start();//开始
	
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				while(ok){
					try {
						Thread.sleep(100);//睡100ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					char letter=(char)getRandomNumber();
					jTextField2.setText(letter+"");//将字符转化为字符串
				}
			}
		});
		t2.start();//开始
		
		Thread t3=new Thread(new Runnable() {
			@Override
			public void run() {
				while(ok){
					try {
						Thread.sleep(100);//睡100ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					char letter=(char)getRandomNumber();
					jTextField3.setText(letter+"");//将字符转化为字符串
				}
			}
		});
		t3.start();//开始
	}
	
	public static void main(String[] args) {
		new MainView();
	}
}
