package lab6.Q1;

import java.util.Date;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Test {
	public static void main(String[] args) {
		Person person=new Person("aa", "hznu", "11111111111", "aa@qq.com");
		System.out.println(person);
		
		Student student=new Student("bb", "hznu", "22222222222", "bb@qq.com", "大二");
		System.out.println(student);
		
		Date date=new Date();
		MyDate myDate=new MyDate(date.getYear()+1900,date.getMonth()+1,date.getDate());
		Employee employee=new Employee("cc", "hznu", "11111111111", "cc@qq.com","16-302", 10000, myDate);
		System.out.println(employee);
		Faculty faculty=new Faculty("dd", "hznu", "11111111111", "dd@qq.com","16-302",10000,myDate,"8:00-16:00","助教");
		System.out.println(faculty);
		Staff staff=new Staff("ee", "hznu", "11111111111", "ee@qq.com","16-302", 10000, myDate, "monitor");
		System.out.println(staff);
	}
}
