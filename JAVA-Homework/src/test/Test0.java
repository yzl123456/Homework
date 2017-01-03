package test;


  
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;  
  
public class Test0 extends JFrame{  
    JComboBox[] jcb=new JComboBox[20];  //������  
    JLabel jlb1, jlb2;  
    JScrollPane jsp;    //�����ؼ�  
    String[] condition={"ѧ��","����","�Ա�","��������","����","��ѧ","Ӣ��"};
    
    JPanel northContent;
    JPanel northPanel;
    //���캯��  
    public Test0(){  
    	buildNorthPanel();
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,400,400);
    	setVisible(true);
    	setContentPane(northPanel);
    }  
    public void buildNorthPanel(){
    	northPanel=new JPanel(new BorderLayout());
    	
    	JLabel titleLabel=new JLabel("�����ѯ����",SwingConstants.CENTER);
    	northPanel.add(titleLabel,BorderLayout.NORTH);
    	
    	northContent=new JPanel();
    	for(int i=0;i<20;i++){
    		jcb[i]=new JComboBox(condition);
    	}
		northContent.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		for(int i=0;i<20;i++){
			northContent.add(jcb[i]);
		}
		northPanel.add(northContent,BorderLayout.CENTER);
		
    }
      
    public static void main(String[] args) {  
        Test0 test0 = new Test0();
    }  
  
}  