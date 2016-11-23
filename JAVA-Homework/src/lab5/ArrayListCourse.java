package lab5;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCourse {
	private List<String>students=new ArrayList<>();//ArrayList存储学生
	private String courseName;//课程名
	public ArrayListCourse() {//无参构造器
	}
	public ArrayListCourse(String courseName){//带参构造器
		this.courseName=courseName;
	}
	public void addStudent(String name){//加入学生
		students.add(name);
	}
	public void dropStudent(String name){//移除学生
		students.remove(name);
	}
	public List<String>getStudents(){//得到学生
		return students;
	}
}
