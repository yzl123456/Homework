package lab6.Q4;


public class CourseGradesInterface extends CourseGrades implements Analyzable{
	private CourseGrades courseGrades;//����һ��coursegrade
	public CourseGradesInterface(CourseGrades courseGrades) {
		super();
		this.courseGrades = courseGrades;
	}
	@Override
	public double getAverage() {//�õ�ƽ��ֵ������double
		return (courseGrades.getLab().getScore()+courseGrades.getPassFailExam().getScore()
				+courseGrades.getFinalExam().getScore())/3;
	}

	@Override
	public GradedActivity getHighest() {//����gradeactivity
		double a=courseGrades.getLab().getScore();
		double b=courseGrades.getPassFailExam().getScore();
		double c=courseGrades.getFinalExam().getScore();
		if(a>b&&a>c) return courseGrades.getLab();
		else if(b>a&&b>c) return courseGrades.getPassFailExam();
		else return courseGrades.getFinalExam();
	}

	@Override
	public GradedActivity getLowest() {//����gradeactivity
		double a=courseGrades.getLab().getScore();
		double b=courseGrades.getPassFailExam().getScore();
		double c=courseGrades.getFinalExam().getScore();
		if(a<b&&a<c) return courseGrades.getLab();
		else if(b<a&&b<c) return courseGrades.getPassFailExam();
		else return courseGrades.getFinalExam();
	}

}
