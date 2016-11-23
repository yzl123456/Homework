package lab5;

import java.util.Arrays;

public class TestArrayListCourse {
	public static void main(String[] args) {
		ArrayListCourse course1=new ArrayListCourse("math");//新建一个课程
		ArrayListCourse course2=new ArrayListCourse("English");//新建第二个课程
		course1.addStudent("yzl1");//加入学生1
		course1.addStudent("yzl2");//加入学生2
		course1.addStudent("yzl3");//加入学生3
		System.out.println(course1.getStudents().size());//得到学生人数
		course1.dropStudent("yzl1");//移除指定名字学生
		//输出当前学生
		System.out.println(course1.getStudents());
	}
}
