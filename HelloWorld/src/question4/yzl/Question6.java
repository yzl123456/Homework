package question4.yzl;

import java.util.Scanner;
/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question6 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();//����
		String[] tokens=str.split(" ");//�ָ��string����
		boolean isFirst=true;
		for(String var:tokens){//����
			if(isFirst){//�ж��Ƿ��һ����� ȷ���Ƿ�Ҫ�ӿո� ��������һ���ո�
				isFirst=false;
			}
			else System.out.print(" ");
			for(int i=1;i<var.length();i++)
				System.out.print(var.charAt(i));//�������һ����ĸ�����
			System.out.print(var.charAt(0));//�����һ����ĸ
			System.out.print("AY");//ĩβ+AY
		}
	}
}
