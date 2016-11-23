package lab9.Q3;

import javax.swing.JFrame;

public class Test {
	public static void main(String args[]) {
		//创建边界布局demo
		BorderLayoutDemo f = new BorderLayoutDemo();
		//设置一些属性
		f.setTitle("Control Window");

		f.pack();

		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setLocationRelativeTo(null); // 让窗体居中显示

	}
}
