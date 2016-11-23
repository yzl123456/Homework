package question1.yzl;

import java.util.Random;
import java.util.Scanner;

/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class PrimaryMath {
	static int  getNumber(){
		Random random=new Random();
		int need=random.nextInt(100);
		while(!(need>=10&&need<=99)){
			need=random.nextInt(100);
		}
		return need;
	}
	static int getSymbol(){
		return getNumber()%4;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		long startTime = System.currentTimeMillis();
		int time=5,count=0;
		while(time--!=0){
			int number1=getNumber();
			int number2=getNumber();
			int symbol=getSymbol();
			if(symbol==0){
				System.out.println(number1+"+"+number2+"=");
				int myAns=in.nextInt();
				if(myAns==number1+number2)
					count++;
			}
			else if(symbol==1){
				System.out.println(number1+"-"+number2+"=");
				int myAns=in.nextInt();
				if(myAns==number1-number2)
					count++;
			}
			else if(symbol==2){
				System.out.println(number1+"*"+number2+"=");
				int myAns=in.nextInt();
				if(myAns==number1*number2)
					count++;
			}
			else{
				System.out.println(number1+"/"+number2+"=(取整即可)");
				int myAns=in.nextInt();
				if(myAns==number1/number2)
					count++;
			}
		}
		long endTime = System.currentTimeMillis();
		long spendTime=(endTime-startTime)/1000;
		System.out.println("你答对了"+count+"题!");
		System.out.println("你花费了"+spendTime+"秒！");
	}
}
