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
	//������ͨ���
	JPanel titlePanel;
	JPanel deliverPanel;
	JPanel productPanel;
	JPanel pricePanel;
	JPanel submitPanel;
	//���尴ť
	JButton calButton;
	JButton initButton;
	//���帴ѡ��
	JCheckBox jCheckBox1;
	JCheckBox jCheckBox2;
	JCheckBox jCheckBox3;
	//���嵥ѡ��
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	JRadioButton radioButton3;
	public RoseShop() {
		//���ô�����⣬��С�����ַ�ʽ�������ַ�ʽ�ļ��
		this.setTitle("yzl Rose Window");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLayout(new BorderLayout(15,35));
		
		//����5����ͨ���
		buildTitlePanel();
		buildDeliverPanel();
		buildProductPanel();
		buildPricePanel();
		buildSubmitPanel();
		
		//��5����ͨ�����䵽JFrame�����������
		add(titlePanel,BorderLayout.NORTH);
		add(deliverPanel,BorderLayout.WEST);
		add(productPanel, BorderLayout.CENTER);
		add(pricePanel,BorderLayout.EAST);
		add(submitPanel,BorderLayout.SOUTH);
		
		//���ÿɼ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void buildTitlePanel(){
		titlePanel=new JPanel();//������ͨ��ͼ
		JLabel jLabel=new JLabel("����Ϊ���ṩ�����ʵķ���",SwingConstants.CENTER);//�������б�ǩ
		jLabel.setFont(new Font("����", Font.BOLD,18));//��������
		titlePanel.add(jLabel);//�������ӵ���ͨ���
	}
	
	public void buildDeliverPanel(){
		deliverPanel=new JPanel(new GridLayout(4,1));//������ͨ��ͼ�����ò���Ϊ����4*1
		deliverPanel.setPreferredSize(new Dimension(200,400));//������ͼ�Ĵ�С
		deliverPanel.setBorder(BorderFactory.createLineBorder(Color.red, 5));//��������
		//������ǩ���
		JLabel jLabel=new JLabel("ѡ������ʵݷ�ʽ",SwingConstants.CENTER);
		jLabel.setFont(new Font("����",Font.BOLD,14));
		//����һ�׵�ѡ��
		radioButton1=new JRadioButton("���",true);
		radioButton2=new JRadioButton("����");
		radioButton3=new JRadioButton("����");
		//��һ�׵�ѡ���������弰��ɫ
		radioButton1.setFont(new Font("����",Font.BOLD,14));
		radioButton1.setForeground(Color.blue);
		radioButton2.setFont(new Font("����",Font.BOLD,14));
		radioButton2.setForeground(Color.blue);
		radioButton3.setFont(new Font("����",Font.BOLD,14));
		radioButton3.setForeground(Color.blue);
		//һ�׵�ѡ����뵽buttonGroupʹ�以��
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		//�����۸��ǩ
		JLabel labelPrice1=new JLabel("10R");
		JLabel labelPrice2=new JLabel("5R");
		JLabel labelPrice3=new JLabel("0R");
		//����3����ͨ���
		JPanel row1Panel=new JPanel();
		JPanel row2Panel=new JPanel();
		JPanel row3Panel=new JPanel();
		//ÿ������һ����ѡ��
		row1Panel.add(radioButton1);
		row1Panel.add(labelPrice1);
		row2Panel.add(radioButton2);
		row2Panel.add(labelPrice2);
		row3Panel.add(radioButton3);
		row3Panel.add(labelPrice3);
		//����ͨ��ͼ�����3������ͨ��ͼ����ǩ
		deliverPanel.add(jLabel);
		deliverPanel.add(row1Panel);
		deliverPanel.add(row2Panel);
		deliverPanel.add(row3Panel);
	}
	
	public void buildProductPanel(){
		//������ͨ��ͼ�������䲼������4*1
		productPanel=new JPanel(new GridLayout(4, 1));
		//���ô���ͨ��ͼ��С���߿򣬱���ɫ
		productPanel.setPreferredSize(new Dimension(200, 200));
		productPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		productPanel.setBackground(Color.yellow);
		//�������б�ǩ
		JLabel jLabel=new JLabel("��ѡ������Ҫ����Ʒ",SwingConstants.CENTER);
		//����һ�׸�ѡ��
		jCheckBox1=new JCheckBox("11��õ�� --------------->");
		jCheckBox2=new JCheckBox("������װ��-------------->");
		jCheckBox3=new JCheckBox("�ؿ�------------------------>");
		//���ø�ѡ����ɫ
		jCheckBox1.setBackground(Color.yellow);
		jCheckBox2.setBackground(Color.yellow);
		jCheckBox3.setBackground(Color.yellow);
		//��Ӹ�ѡ�򵽴���ͨ���
		productPanel.add(jLabel);
		productPanel.add(jCheckBox1);
		productPanel.add(jCheckBox2);
		productPanel.add(jCheckBox3);
	}
	
	public void buildPricePanel(){
		//������ͨ��ͼ�������䲼������4*1
		pricePanel=new JPanel(new GridLayout(4, 1));
		//���ô���ͨ��ͼ��С���߿򣬱���ɫ
		pricePanel.setPreferredSize(new Dimension(200, 400));
		pricePanel.setBackground(Color.green);
		//������ǩ
		JLabel jLabel=new JLabel("��Ʒ�۸�",SwingConstants.CENTER);
		JLabel jLabelPrice1=new JLabel("108Ԫ");
		JLabel jLabelPrice2=new JLabel("28Ԫ");
		JLabel jLabelPrice3=new JLabel("8Ԫ");
		//���ñ�ǩ��ɫ
		jLabel.setBackground(Color.GREEN);
		jLabelPrice1.setBackground(Color.GREEN);
		jLabelPrice2.setBackground(Color.GREEN);
		jLabelPrice3.setBackground(Color.GREEN);
		//����ǩ��ӵ���ͨ���
		pricePanel.add(jLabel);
		pricePanel.add(jLabelPrice1);
		pricePanel.add(jLabelPrice2);
		pricePanel.add(jLabelPrice3);
	}
	
	public void buildSubmitPanel(){
		//�����Ű�ť����ͨ���
		submitPanel=new JPanel();
		//����2����ť
		calButton=new JButton("����");
		initButton=new JButton("����");
		//Ϊ2����ťע��2����ͬ��ʱ�䣨��ʵ�Ҿ��÷�һ���¼���Ҳ�У�ͨ��getsource�жϣ�
		calButton.addActionListener(new CalButtonListener());
		initButton.addActionListener(new ResetButtonListener());
		//����ͨ��������2����ť���
		submitPanel.add(calButton);
		submitPanel.add(initButton);
		
	}
	private class CalButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double money=0;//����۸�
			if(e.getSource()==calButton){//���¼��Ǽ��㰴ť������
				if(radioButton1.isSelected()){//�ж��ʵݷ���
					money+=10;
				}
				else if(radioButton2.isSelected()){
					money+=5;
				}
				else if(radioButton3.isSelected()){
					money+=0;
				}
				
				if(jCheckBox1.isSelected()){//�ж���Ʒ����
					money+=108;
				}
				if(jCheckBox2.isSelected()){
					money+=28;
				}
				if(jCheckBox3.isSelected()){
					money+=8;
				}
				//�����Ի���
				JOptionPane.showMessageDialog(submitPanel,"�ܼ�Ϊ��"+money);	
			}
		}		
	}
	
	private class ResetButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==initButton){//���¼��ǳ�ʼ����ť����
				radioButton1.setSelected(true);//��ѡ���ʼ��
				
				jCheckBox1.setSelected(false);//��ѡ���ʼ��
				jCheckBox2.setSelected(false);
				jCheckBox3.setSelected(false);
				
				
			}
			
		}		
	}
	
	
	public static void main(String[] args) {
		new RoseShop();
	}
}
