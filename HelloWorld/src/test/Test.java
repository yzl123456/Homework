package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
//		int[] numbers=new int[]{1,2,3,4,5};
//		File file=new File("g://a.txt");
//		OutputStream outputStream=new FileOutputStream(file);
//		ObjectOutputStream out=new ObjectOutputStream(outputStream);
//		out.writeObject(numbers);
//		Integer xInteger;
//		int[] want;
//		File file=new File("g://a.txt");
//		InputStream inputStream=new FileInputStream(file);
//		ObjectInputStream in=new ObjectInputStream(inputStream);
//		Object object = in.readObject();
//		int [] numbers=(int[])object;
//		for(int i=0;i<numbers.length;i++){
//			System.out.println(numbers[i]);
//		}
		int[] numbers=new int[]{1,2,3};
		Person person=new Person();
		System.out.println(numbers);
		System.out.println(person);
		
	}
	
}
