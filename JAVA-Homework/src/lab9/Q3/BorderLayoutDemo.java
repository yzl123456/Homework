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

public class BorderLayoutDemo extends JFrame {//�߽粼�ֹ�����
	//�������
	JLabel jLabel;
	JTextField jTextField;
	JButton forwardButton;
	JButton backwordButton;
	public BorderLayoutDemo() { // ���캯������ʼ������ֵ
		// ����Ϊ�߽粼�֣����������������Ϊ5����
		setLayout(new BorderLayout(5, 5));
		//��������
		setFont(new Font("Helvetica", Font.PLAIN, 14));

		JPanel jPanel1 = new JPanel();
		jLabel=new JLabel("click \"forward\" to run letter M ,click backword to reverse  ");
		jPanel1.add(jLabel);
		getContentPane().add("North", jPanel1); // ��jlabel��ӵ�������

		JPanel jPanel2 = new JPanel();
		jTextField=new JTextField(45);
		jPanel2.add(jTextField);
		getContentPane().add("Center", jPanel2); // ��Jtextfield��ӵ�������
		
		JPanel jPanel3 = new JPanel();
		forwardButton = new JButton("forward");
		backwordButton= new JButton("backword");
		jPanel3.add(forwardButton);//��ͨ��ͼ���button
		jPanel3.add(backwordButton);
		getContentPane().add("South", jPanel3); // ��Jbutton��ӵ�������
		
		// ע���¼�
		forwardButton.addActionListener(new ButtonListener());
		backwordButton.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==forwardButton){//�ж��¼�����Դ������forward
				String content=jTextField.getText();//�õ��ı�����
				jTextField.setText(content+"M");//��������+��M��
			}
			else if(e.getSource()==backwordButton){//����backword
				String content=jTextField.getText();//�õ��ı�����
				if(content.length()>=1){//�����ȡ�1��ʾ�ܹ�����ɾ
					//�����ı�Ϊԭ���ı��Ĵ�ȥ�����һλ
					jTextField.setText(content.substring(0, content.length()-1));
				}
			}

		}
	}

}
