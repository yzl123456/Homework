package lab9.Q3;

import javax.swing.JFrame;

public class Test {
	public static void main(String args[]) {
		//�����߽粼��demo
		BorderLayoutDemo f = new BorderLayoutDemo();
		//����һЩ����
		f.setTitle("Control Window");

		f.pack();

		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setLocationRelativeTo(null); // �ô��������ʾ

	}
}
