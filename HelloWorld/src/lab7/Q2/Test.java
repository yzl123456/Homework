package lab7.Q2;

public class Test {
	public static void main(String[] args) {
		double [] scores=new double[]{20, 70, 90, 88, 60, -88};
		//��������
		TestScores testScores=new TestScores(scores);
		//������ƽ��
		try {
			int ave=testScores.getAverage();
			System.out.println(ave);//����������ִ��
		} catch (InvalidTestScore e) {//�������Զ����쳣��ӡ��Ϣ
			System.out.println(e.getMessage());
		}
		
	}
}
