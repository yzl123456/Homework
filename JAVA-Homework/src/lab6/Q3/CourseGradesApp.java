package lab6.Q3;

public class CourseGradesApp {
	public static void main(String[] args) {
		CourseGrades courseGrades=new CourseGrades();//new coursegrades
		//将各项考试set进去
		GradedActivity lab=new GradedActivity();
		lab.setScore(80);
		GradedActivity passFailExam=new PassFailExam(10,3, 70);
		GradedActivity finalExam=new FinalExam(50,2);
		courseGrades.setLab(lab);
		courseGrades.setPassFailExam(passFailExam);
		courseGrades.setFinalExam(finalExam);
		//输出
		System.out.println(lab.getScore()+": "+lab.getGrade());
		System.out.println(passFailExam.getScore()+": "+passFailExam.getGrade());
		System.out.println(finalExam.getScore()+": "+finalExam.getGrade());
	}
}
