package question4.yzl;

import java.util.Scanner;
/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question4 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		StringBuilder str=new StringBuilder(in.nextLine());//���������ַ�������װ��Stringbuilder����	
		//ע������Ҫnew StringBuilder ������copyStr=str;ǰ���ǰ���ֵͬ�Ŀ�����һ������ ���߰�copyStr��ָ��str�ĵ�ַָ�� ������Ч
		StringBuilder copyStr=new StringBuilder(str);
		//������Ҫ˵�ǳ����ص�����,String�е�equals������д��Object��equals�������Ƚϵ����ַ��������ݣ���StringBuilder����
		//��û����дequals������������StringBuilder�е�equals�����ȽϵĻ��ǵ�ַ������ر�Ҫ���ֿ�������Ҫ��tostringת��string��
		if(copyStr.toString().equals(str.reverse().toString())){//��������׺����
			System.out.println(copyStr+" is a palindrome");
		}
		else System.out.println(copyStr+" is not a palindrome");
	}
}
