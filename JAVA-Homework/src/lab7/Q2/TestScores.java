package lab7.Q2;

public class TestScores {
	private double [] scores;//��������
	public TestScores(double[] scores) {//������
		super();
		this.scores = scores;
	}
	public int getAverage(){//��ƽ��
		int sum=0;
		for(int i=0;i<scores.length;i++){
			if(scores[i]>=0&&scores[i]<=100){//���������ż�
				sum+=scores[i];
			}
			else throw new InvalidTestScore("Error:score is out of range"+scores[i]);//���������쳣
		}
		return sum;
	}	
}
