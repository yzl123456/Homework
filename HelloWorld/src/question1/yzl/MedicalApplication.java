package question1.yzl;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 2
 */

public class MedicalApplication {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter weight:");
		double weight=in.nextDouble();
		System.out.println("Enter height");
		double height=in.nextDouble();
		double BMI=(weight/height/height);
		DecimalFormat df = new DecimalFormat("#.###");  
		
		System.out.println(df.format(BMI));
		if(BMI<16){
			System.out.println("����ƫ��");
		}
		else if(BMI<=18){
			System.out.println("ƫ��");
		}
		else if(BMI<=24){
			System.out.println("����");
		}
		else if(BMI<=29){
			System.out.println("ƫ��");
		}
		else if(BMI<=35){
			System.out.println("����ƫ��");
		}
		else System.out.println("����ƫ��");
	}
	
	
}
