package lab7.Q2;

public class Test {
	public static void main(String[] args) {
		double [] scores=new double[]{20, 70, 90, 88, 60, -88};
		//创建对象
		TestScores testScores=new TestScores(scores);
		//尝试求平均
		try {
			int ave=testScores.getAverage();
			System.out.println(ave);//不出错正常执行
		} catch (InvalidTestScore e) {//出错处理自定义异常打印信息
			System.out.println(e.getMessage());
		}
		
	}
}
