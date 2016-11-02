package lab6.Q1;
/*
 * ”¶‘Û¡÷
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Employee extends Person{

	private String workRoom;
	private int salary;
	private MyDate workDay;
	
	public Employee(String name, String address, String phone, String email, String workRoom, int salary,
			MyDate workDay) {
		super(name, address, phone, email);
		this.workRoom = workRoom;
		this.salary = salary;
		this.workDay = workDay;
	}

	@Override
	public String toString() {//tostring
		return "Employee "+getName();
	}
}
