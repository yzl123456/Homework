package lab6.Q1;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class MyDate {
	private int year;
	private int month;
	private int day;
	public MyDate(int year, int month, int day) {//构造器
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//tostring
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
}
