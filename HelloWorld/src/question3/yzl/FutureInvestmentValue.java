package question3.yzl;

import java.util.Scanner;

/*
 * ”¶‘Û¡÷
 * JAVA programing Autumn 2016
 * Lab 1
 */
public class FutureInvestmentValue {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Please input investmentAmount");
		double investmentAmount=in.nextDouble();
		System.out.println("Please input yearinterest rate");
		double yearInterestRate=in.nextDouble()/100;
		System.out.println("Please input number of years");
		int numberOfYears=in.nextInt();
		double futureInvestmentValue=Math.pow((1+yearInterestRate/12), numberOfYears*12)*investmentAmount;
		System.out.println(futureInvestmentValue);
		
		
	}
}
