package lab5;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCourse {
	private List<String>students=new ArrayList<>();//ArrayList�洢ѧ��
	private String courseName;//�γ���
	public ArrayListCourse() {//�޲ι�����
	}
	public ArrayListCourse(String courseName){//���ι�����
		this.courseName=courseName;
	}
	public void addStudent(String name){//����ѧ��
		students.add(name);
	}
	public void dropStudent(String name){//�Ƴ�ѧ��
		students.remove(name);
	}
	public List<String>getStudents(){//�õ�ѧ��
		return students;
	}
}
