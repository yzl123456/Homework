package question1.yzl;

import java.util.Random;
import java.util.Scanner;

/*
 * Ó¦ÔóÁÖ
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class GuessGame {
	public static void main(String[] args) {
		Random random=new Random();
		int realNumber=random.nextInt(101);
		Scanner in=new Scanner(System.in);
		System.out.println("Guess a magic number between 0 and 100:");
		System.out.println("Enter your guess:");
		int myChose=in.nextInt();
		while(realNumber!=myChose){
			if(realNumber>myChose){
				System.out.println("Your guess is too low!");
			}
			else System.out.println("Your guess is too high!");
			myChose=in.nextInt();
		}
		System.out.println("Yes,the number is "+realNumber);
		
	}
}
