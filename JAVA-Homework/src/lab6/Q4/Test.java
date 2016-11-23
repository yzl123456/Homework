package lab6.Q4;



public class Test {
	public static void main(String[] args) {
		//…Ë÷√coursegrade
		CourseGrades courseGrades=new CourseGrades();
		GradedActivity lab=new GradedActivity();
		lab.setScore(80);
		GradedActivity passFailExam=new PassFailExam(10,3, 70);
		GradedActivity finalExam=new FinalExam(50,2);
		courseGrades.setLab(lab);
		courseGrades.setPassFailExam(passFailExam);
		courseGrades.setFinalExam(finalExam);
		System.out.println(lab.getScore()+": "+lab.getGrade());
		System.out.println(passFailExam.getScore()+": "+passFailExam.getGrade());
		System.out.println(finalExam.getScore()+": "+finalExam.getGrade());
		//new courseGradesInterface
		CourseGradesInterface courseGradesInterface=new CourseGradesInterface(courseGrades);
		System.out.println("The average score is: "+courseGradesInterface.getAverage());
		System.out.println("The highest score is: "+courseGradesInterface.getHighest().getScore());
		System.out.println("The lowest score is: "+courseGradesInterface.getLowest().getScore());
		
	}
}
