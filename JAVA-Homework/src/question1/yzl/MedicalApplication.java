package question1.yzl;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
 * 应泽林
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
			System.out.println("严重偏瘦");
		}
		else if(BMI<=18){
			System.out.println("偏瘦");
		}
		else if(BMI<=24){
			System.out.println("正常");
		}
		else if(BMI<=29){
			System.out.println("偏胖");
		}
		else if(BMI<=35){
			System.out.println("严重偏胖");
		}
		else System.out.println("极度偏胖");
	}
	
	
}
