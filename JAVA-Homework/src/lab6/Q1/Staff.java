package lab6.Q1;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Staff extends Employee{
	private String title;
	//构造器
	public Staff(String name, String address, String phone, String email, String workRoom, int salary, MyDate workDay,
			String title) {
		super(name, address, phone, email, workRoom, salary, workDay);
		this.title = title;
	}
	
	//tostring
	@Override
	public String toString() {
		return "Staff "+getName();
	}
	
	
}
