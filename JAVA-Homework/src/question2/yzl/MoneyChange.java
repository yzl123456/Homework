package question2.yzl;

import java.util.Scanner;

/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 1
 */

public class MoneyChange {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int RMB_10=0,RMB_5=0,RMB_1=0,fifty_cents=0,ten_cents=0,five_cents=0,two_cents=0,one_cent=0;
		System.out.println("Please input the total money:");
		double money=in.nextDouble();
		int cents=(int) (100*(money-(int)money));
		RMB_10=(int)money/10;
		RMB_5=(int) ((money-RMB_10*10)/5);
		RMB_1=((int)money%5);
		fifty_cents=cents/50;
		ten_cents=cents%50/10;
		five_cents=cents%10/5;
		one_cent=cents%5;
		//if(RMB_10!=0)
		System.out.println(RMB_10+"��10Ԫ");
		//if(RMB_5!=0)
		System.out.println(RMB_5+"��5Ԫ");
		//if(RMB_1!=0)
		System.out.println(RMB_1+"��1Ԫ");
		//if(fifty_cents!=0)
		System.out.println(fifty_cents+"��5��");
		//if(ten_cents!=0)
		System.out.println(ten_cents+"��1��");
		//if(five_cents!=0)
		System.out.println(five_cents+"��5��");
		//if(two_cents!=0)
		System.out.println(two_cents+"��2��");
		//if(one_cent!=0)
		System.out.println(one_cent+"��1��");
		
		
	}
}
