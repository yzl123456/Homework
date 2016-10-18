package lab5;

import java.util.Arrays;

public class TestArrayCourse {
	public static void main(String[] args) {
		ArrayCourse course1=new ArrayCourse("math");//新建一个课程
		ArrayCourse course2=new ArrayCourse("English");//新建第二个课程
		course1.addStudent("yzl1");//加入学生1
		course1.addStudent("yzl2");//加入学生2
		course1.addStudent("yzl3");//加入学生3
		System.out.println(course1.getNumberOfStudent());//得到学生人数
		course1.dropStudent("yzl1");//移除指定名字学生
		//输出当前学生,利用Arrays.asList将String数组转成list输出,否则输出对象+hash值
		System.out.println(Arrays.asList(course1.getStudents()));
	}
}
