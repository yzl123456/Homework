package question4.yzl;

import java.util.Scanner;
/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question3 {
	public static void main(String[] args) {
		//�������������8���ַ�������ֻ�ܰ�����ĸ�����֡��������������2�����֡�
		Scanner in=new Scanner(System.in);
		String password=in.nextLine();		
		int countLetter=0,countNumber=0;//ͳ����ĸ���� �� ���ָ���
		boolean isOnlyLetterOrNumber=true;//��ʶ�Ƿ�ֻ������ĸ������ ����Ϊtrue ��֮false
		for(int i=0;i<password.length();i++){
			if(Character.isDigit(password.charAt(i)))//�ж�
				countNumber++;
			else if(Character.isLetter(password.charAt(i)))//�ж�
				countLetter++;
			else{
				isOnlyLetterOrNumber=false;break;//������ֱ��break
			}
		}
		if(isOnlyLetterOrNumber==false){
			System.out.println("InValid  Password");
		}
		else{
			if(countLetter+countNumber<8||countNumber<2)
				System.out.println("InValid  Password");
			else 
				System.out.println("Valid  Password");
		}
		
	}
}
