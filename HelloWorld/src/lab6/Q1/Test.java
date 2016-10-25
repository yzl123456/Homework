package lab6.Q1;

import java.util.Date;
/*
 * ”¶‘Û¡÷
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Test {
	public static void main(String[] args) {
		Person person=new Person();
		System.out.println(person);
		Student student=new Student();
		System.out.println(student);
		Date date=new Date();
		MyDate myDate=new MyDate(date.getYear()+1900,date.getMonth()+1,date.getDate());
		Employee employee=new Employee("16-302", 10000, myDate);
		System.out.println(employee);
		Faculty faculty=new Faculty("16-302",10000,myDate,"8:00-16:00","÷˙ΩÃ");
		System.out.println(faculty);
		Staff staff=new Staff("16-302", 10000, myDate, "monitor");
		System.out.println(staff);
	}
}
