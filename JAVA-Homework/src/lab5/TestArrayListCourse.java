package lab5;

import java.util.Arrays;

public class TestArrayListCourse {
	public static void main(String[] args) {
		ArrayListCourse course1=new ArrayListCourse("math");//�½�һ���γ�
		ArrayListCourse course2=new ArrayListCourse("English");//�½��ڶ����γ�
		course1.addStudent("yzl1");//����ѧ��1
		course1.addStudent("yzl2");//����ѧ��2
		course1.addStudent("yzl3");//����ѧ��3
		System.out.println(course1.getStudents().size());//�õ�ѧ������
		course1.dropStudent("yzl1");//�Ƴ�ָ������ѧ��
		//�����ǰѧ��
		System.out.println(course1.getStudents());
	}
}
