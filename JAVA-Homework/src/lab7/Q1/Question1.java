package lab7.Q1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question1 {
	//����
	public static int quotient(int numerator, int denominator){
		try {//���Գ���
			int result=numerator/denominator;
			return result;
		} catch (ArithmeticException e) {
			throw e;//���������ѧ�쳣���Ѹ��쳣�׸�main��������
		}
	}
	
	
	public static void main(String[] args) {
		/**
		 * ��string�������ݶ�������int ���Ա���������ʱ ��Ҫ��취�Ѵ�������ݶ��� ��Ȼ��������ݲ����� ��һֱ����������
		 */
		int a ,b;//���ڼ��������
		String strA,strB;//ͨ��String���ն��������
		Scanner in=new Scanner(System.in);
		System.out.println("Please input 2 integers:");
		while(true){//����2�������ҳ������쳣ʱ�˳�
			try {
				strA=in.next();strB=in.next();//String���ն�������
				try {
					a=Integer.parseInt(strA);//ǿת���쳣˵������Ĳ���2������
					b=Integer.parseInt(strB);
				} catch (Exception e) {
					throw new InputMismatchException();//�׳����벻ƥ����쳣��������try
				}
				
				try {//���Գ����Ƿ�����쳣
					int result=quotient(a, b);
					System.out.println(result);
					break;//�����쳣����ѭ����ֹ
				} catch (ArithmeticException e) {
					//�����ѧ�쳣�����ʾ���
					System.out.println("Zero is an invalid denominator. Pleasetry again.");
				}
				
		
			} catch (InputMismatchException e) {
				//�����ʾ���
				System.out.println("You must enter integers. Please try again.");
			}
		}

	}
	
}
