package lab6.Q3;

import java.util.Arrays;

public class CourseGrades {
	GradedActivity[] grades=new GradedActivity[3];//����������
	public void setLab(GradedActivity lab){
		grades[0]=lab;
	}
	public GradedActivity getLab(){
		return grades[0];
	}
	public void setPassFailExam(GradedActivity passFailExam){
		grades[1]=passFailExam;
	}
	public GradedActivity getPassFailExam(){
		return grades[1];
	}
	public void setFinalExam(GradedActivity finalExam){
		grades[2]=finalExam;
	}
	public GradedActivity getFinalExam(){
		return grades[2];
	}
	//��дtostring
	@Override
	public String toString() {
		return "CourseGrades [grades=" + Arrays.toString(grades) + "]";
	}
	
	
}
