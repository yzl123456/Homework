package lab7.Q1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question1 {
	//求商
	public static int quotient(int numerator, int denominator){
		try {//尝试除法
			int result=numerator/denominator;
			return result;
		} catch (ArithmeticException e) {
			throw e;//如果出现数学异常，把该异常抛给main函数处理
		}
	}
	
	
	public static void main(String[] args) {
		/**
		 * 用string接收数据而不是用int 可以避免读入出错时 还要想办法把错误的数据读掉 不然出错的数据不读掉 会一直留在输入区
		 */
		int a ,b;//用于计算的数字
		String strA,strB;//通过String接收读入的数据
		Scanner in=new Scanner(System.in);
		System.out.println("Please input 2 integers:");
		while(true){//输入2个整数且除法无异常时退出
			try {
				strA=in.next();strB=in.next();//String接收读入数据
				try {
					a=Integer.parseInt(strA);//强转出异常说明读入的不是2个整形
					b=Integer.parseInt(strB);
				} catch (Exception e) {
					throw new InputMismatchException();//抛出读入不匹配的异常给最外层的try
				}
				
				try {//尝试除法是否会抛异常
					int result=quotient(a, b);
					System.out.println(result);
					break;//不出异常跳出循环终止
				} catch (ArithmeticException e) {
					//针对数学异常输出提示语句
					System.out.println("Zero is an invalid denominator. Pleasetry again.");
				}
				
		
			} catch (InputMismatchException e) {
				//输出提示语句
				System.out.println("You must enter integers. Please try again.");
			}
		}

	}
	
}
