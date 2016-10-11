package question4.yzl;

import java.util.Scanner;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question3 {
	public static void main(String[] args) {
		//密码必须至少有8个字符。密码只能包括字母和数字。密码必须至少有2个数字。
		Scanner in=new Scanner(System.in);
		String password=in.nextLine();		
		int countLetter=0,countNumber=0;//统计字母个数 和 数字个数
		boolean isOnlyLetterOrNumber=true;//标识是否只出现字母和数字 符合为true 反之false
		for(int i=0;i<password.length();i++){
			if(Character.isDigit(password.charAt(i)))//判断
				countNumber++;
			else if(Character.isLetter(password.charAt(i)))//判断
				countLetter++;
			else{
				isOnlyLetterOrNumber=false;break;//不符合直接break
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
