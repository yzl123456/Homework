package lab5;

import java.util.ArrayList;
import java.util.List;

public class ArrayCourse {
	private String[] students=new String[105];//����ʵ��Ҫ��������
	private int numberOfStudent=0;//ѧ��������ʼΪ0
	private String courseName;//�γ���
	public int getNumberOfStudent() {//�õ�ѧ������
		return numberOfStudent;
	}
	public ArrayCourse() {//�޲ι�����
	}
	public ArrayCourse(String courseName){//���ι�����
		this.courseName=courseName;
	}
	public void addStudent(String name){//����ѧ��
		students[numberOfStudent]=name;
		numberOfStudent++;
	}
	public void dropStudent(String name){//�Ƴ�ѧ��
		int pos=-1;
		for(int i=0;i<students.length;i++){//�ҵ���ǰҪɾ��ѧ��
			if(students[i].equals(name)){
				pos=i;break;
			}
		}
		for(int j=pos+1;j<numberOfStudent;j++){//Ҫɾ��ѧ���ĺ���ÿ����ǰ�ƶ�
			students[j-1]=students[j];
		}
		numberOfStudent--;//ѧ����--
	}
	public String[] getStudents(){//�õ�ѧ��
		String[] tmpString=new String[numberOfStudent];
		for(int i=0;i<numberOfStudent;i++){
			tmpString[i]=students[i];
		}
		return tmpString;//ֻ����ʵ�ʴ�С��String ���� ����main�����Arrays.asList
	}
}
