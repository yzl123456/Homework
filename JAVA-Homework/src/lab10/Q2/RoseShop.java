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
	//������ͨ���
	JPanel panelN;
	JPanel panelW;
	JPanel panelS;
	JPanel panelE;
	JPanel panelC;
	//���尴ť
	JButton choseButton;
	JButton resetButton;
	//JSlider����
	JSlider[] jSlider=new JSlider[3];
	//����������panel����
	JPanel[] sonJPanel=new JPanel[12];
	//���ĵ�ɫ��jpanel
	JPanel centerJPanel;
	//��ŵ���ɫ����ɫ����
	List<Color>colors=new LinkedList<>();
	
	public RoseShop() {
		//���ô�����⣬��С�����ַ�ʽ�������ַ�ʽ�ļ��
		this.setTitle("yzl Color Window");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLayout(new BorderLayout(15,35));
		
		//����5����ͨ���
		buildNorthPanel();
		buildWestPanel();
		buildCenterPanel();
		buildEastPanel();
		buildSubmitPanel();
		
		//��5����ͨ�����䵽JFrame�����������
		add(panelN,BorderLayout.NORTH);
		add(panelW,BorderLayout.WEST);
		add(panelC, BorderLayout.CENTER);
		add(panelE,BorderLayout.EAST);
		add(panelS,BorderLayout.SOUTH);
		
		//���ÿɼ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void buildNorthPanel(){
		panelN=new JPanel();//������ͨ��ͼ
		JLabel jLabel=new JLabel("���������ɫ",SwingConstants.CENTER);//�������б�ǩ
		jLabel.setFont(new Font("����", Font.BOLD,18));//��������
		panelN.add(jLabel);//�������ӵ���ͨ���
	}
	
	public void buildWestPanel(){
		//��Ӳ��ֺʹ�С
		panelW=new JPanel(new BorderLayout());
		panelW.setPreferredSize(new Dimension(200, 400));
		//���ڱ�ǩ����ֱ�����ñ���ɫ���������ǰѱ�ǩ�ŵ�jpanel��Ȼ���jpanel���ñ���
		JPanel labelPanel=new JPanel();
		labelPanel.setBackground(Color.yellow);
		JLabel jLabel=new JLabel("���ѡ��",SwingConstants.CENTER);
		labelPanel.add(jLabel);
		
		//�����ַŵ���ɫ�山��
		panelW.add(labelPanel,BorderLayout.NORTH);
		//12���հ׵ĵ�ɫ��ͬʱ���ñ߾�
		JPanel gridPanel=new JPanel(new GridLayout(6, 2,2,2));
		gridPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		//�ŵ�����
		panelW.add(gridPanel,BorderLayout.CENTER);
		//��ʼ��12����ɫ���ɫ
		for(int i=0;i<12;i++){
			sonJPanel[i]=new JPanel();
			sonJPanel[i].setBackground(Color.WHITE);
			gridPanel.add(sonJPanel[i]);
		}
		
	}
	
	public void buildCenterPanel(){
		//��������panel����Ϊ��ɫ
		panelC=new JPanel(new GridLayout(1, 1));
		panelC.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		centerJPanel=new JPanel();
		centerJPanel.setBackground(Color.WHITE);
		panelC.add(centerJPanel);
	}
	
	public void buildEastPanel(){
		//��������panel
		panelE=new JPanel(new GridLayout(1, 3));
		panelE.setPreferredSize(new Dimension(200, 200));
		//���ñ���߿�
		LineBorder lbr=new LineBorder(Color.RED,3);
		panelE.setBorder(BorderFactory.createTitledBorder((lbr),"RGB"));
		//��ӻ��������ͬʱ�ŵ�jpanel����
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
		//������ť����
		panelS=new JPanel();
		choseButton=new JButton("��ѡ����");
		resetButton=new JButton("����");
		//ע���¼�
		choseButton.addActionListener(new ChoseButtonListener());
		resetButton.addActionListener(new ResetButtonListener());
		//��Ӱ�ť��jpanel����
		panelS.add(choseButton);
		panelS.add(resetButton);
		
	}
	private class SliderListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			//��ȡ3�������ֵ�浽num����
			int []num=new int[3];
			for(int i=0;i<3;i++){
				num[i]=jSlider[i].getValue();
			}
			//������jpanleȾɫ��ÿ������ȡֵ�ı�
			centerJPanel.setBackground(new Color(num[0], num[1], num[2]));	
		}
	}
	
	private class ChoseButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//��ȡ����jpanel�ı���
			Color color=centerJPanel.getBackground();
			//��ӵ�linklist��±�Ϊ0
			colors.add(0, color);
			//��linklist����color���������������12���ɫ�帳����
			for(int i=0;i<12;i++){
				if(i<colors.size())
				sonJPanel[i].setBackground(colors.get(i));
			}
		}		
	}
	
	private class ResetButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//���linklist
			colors.clear();
			//��ʼ������ֵ
			for(int i=0;i<3;i++){
				jSlider[i].setValue(255);
			}
			//��ʼ�����12����ɫ��
			for(int i=0;i<12;i++){
				sonJPanel[i].setBackground(Color.WHITE);
			}
		}		
	}
	
	
	public static void main(String[] args) {
		new RoseShop();
	}
}
