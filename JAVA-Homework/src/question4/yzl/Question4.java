package question4.yzl;

import java.util.Scanner;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question4 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		StringBuilder str=new StringBuilder(in.nextLine());//获得输入的字符串并包装成Stringbuilder对象	
		//注意这里要new StringBuilder 而不是copyStr=str;前者是把相同值的拷贝成一个备份 后者把copyStr的指向str的地址指向 后者无效
		StringBuilder copyStr=new StringBuilder(str);
		//接下来要说非常严重的问题,String中的equals方法重写了Object的equals方法，比较的是字符串的内容，而StringBuilder类中
		//并没有重写equals方法，所以在StringBuilder中的equals方法比较的还是地址，这个特别要区分开，所以要加tostring转成string的
		if(copyStr.toString().equals(str.reverse().toString())){//方法链连缀调用
			System.out.println(copyStr+" is a palindrome");
		}
		else System.out.println(copyStr+" is not a palindrome");
	}
}
