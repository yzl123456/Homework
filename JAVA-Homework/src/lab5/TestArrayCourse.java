package lab5;

import java.util.Arrays;

public class TestArrayCourse {
	public static void main(String[] args) {
		ArrayCourse course1=new ArrayCourse("math");//�½�һ���γ�
		ArrayCourse course2=new ArrayCourse("English");//�½��ڶ����γ�
		course1.addStudent("yzl1");//����ѧ��1
		course1.addStudent("yzl2");//����ѧ��2
		course1.addStudent("yzl3");//����ѧ��3
		System.out.println(course1.getNumberOfStudent());//�õ�ѧ������
		course1.dropStudent("yzl1");//�Ƴ�ָ������ѧ��
		//�����ǰѧ��,����Arrays.asList��String����ת��list���,�����������+hashֵ
		System.out.println(Arrays.asList(course1.getStudents()));
	}
}
