package lab7.Q2;

public class TestScores {
	private double [] scores;//引用类型
	public TestScores(double[] scores) {//构造器
		super();
		this.scores = scores;
	}
	public int getAverage(){//求平均
		int sum=0;
		for(int i=0;i<scores.length;i++){
			if(scores[i]>=0&&scores[i]<=100){//满足条件才加
				sum+=scores[i];
			}
			else throw new InvalidTestScore("Error:score is out of range"+scores[i]);//不满足抛异常
		}
		return sum;
	}	
}
