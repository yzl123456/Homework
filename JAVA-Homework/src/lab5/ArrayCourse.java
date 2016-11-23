package lab5;

import java.util.ArrayList;
import java.util.List;

public class ArrayCourse {
	private String[] students=new String[105];//数组实现要声明长度
	private int numberOfStudent=0;//学生个数初始为0
	private String courseName;//课程名
	public int getNumberOfStudent() {//得到学生个数
		return numberOfStudent;
	}
	public ArrayCourse() {//无参构造器
	}
	public ArrayCourse(String courseName){//带参构造器
		this.courseName=courseName;
	}
	public void addStudent(String name){//加入学生
		students[numberOfStudent]=name;
		numberOfStudent++;
	}
	public void dropStudent(String name){//移除学生
		int pos=-1;
		for(int i=0;i<students.length;i++){//找到当前要删的学生
			if(students[i].equals(name)){
				pos=i;break;
			}
		}
		for(int j=pos+1;j<numberOfStudent;j++){//要删除学生的后面每个往前移动
			students[j-1]=students[j];
		}
		numberOfStudent--;//学生数--
	}
	public String[] getStudents(){//得到学生
		String[] tmpString=new String[numberOfStudent];
		for(int i=0;i<numberOfStudent;i++){
			tmpString[i]=students[i];
		}
		return tmpString;//只返回实际大小的String 数组 方便main里面的Arrays.asList
	}
}
