package question1.yzl;

import java.util.Random;
import java.util.Scanner;

/*
 * Ó¦ÔóÁÖ
 * JAVA programing Autumn 2016
 * Lab 2
 */

public class LotteryTicket {
	static int matchNumber(int number1,int number2){
		int unitNumber1=number1%10;
		int decadeNumber1=number1/10;
		int unitNumber2=number2%10;
		int decadeNumber2=number2/10;
		if(unitNumber1==decadeNumber2&&unitNumber2==decadeNumber1){
			return 2;
		}
		else if(unitNumber1==unitNumber2||unitNumber1==decadeNumber2||decadeNumber1==unitNumber2||decadeNumber1==decadeNumber2){
			return 1;
		}
		else 
			return 0;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your lottery pick (two digits):");
		int myChose=in.nextInt();
		Random random=new Random();
		int randomNumber=random.nextInt(100) ;
		while(!(randomNumber>=10&&randomNumber<=99)){
			randomNumber=random.nextInt(100);
		}
		System.out.println("The lottery number is "+randomNumber);
		if(myChose==randomNumber){
			System.out.println("Perfect!:You win $10000");
		}
		else {
			int match_number=matchNumber(myChose,randomNumber);
			if(match_number==1){
				System.out.println("Match one digit: you win $1000");
			}
			else if(match_number==2){
				System.out.println("Match two digits: you win $3000");
			}
			else System.out.println("You lose.");
		}
	}
}
