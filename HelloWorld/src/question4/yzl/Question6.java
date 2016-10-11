package question4.yzl;

import java.util.Scanner;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question6 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();//输入
		String[] tokens=str.split(" ");//分割成string数组
		boolean isFirst=true;
		for(String var:tokens){//遍历
			if(isFirst){//判断是否第一次输出 确定是否要加空格 避免最后多一个空格
				isFirst=false;
			}
			else System.out.print(" ");
			for(int i=1;i<var.length();i++)
				System.out.print(var.charAt(i));//先输出第一个字母以外的
			System.out.print(var.charAt(0));//输出第一个字母
			System.out.print("AY");//末尾+AY
		}
	}
}
