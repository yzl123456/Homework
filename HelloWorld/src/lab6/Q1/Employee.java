package lab6.Q1;
/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Employee extends Person{
	private final String name="myEmployee";//����final
	private final String address="hznu";
	private final String phone="11111111111";
	private final String email="11111111111@qq.com";
	private String workRoom;
	private int salary;
	private MyDate workDay;
	public Employee(String workRoom, int salary, MyDate workDay) {//������
		super();
		this.workRoom = workRoom;
		this.salary = salary;
		this.workDay = workDay;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {//tostring
		return "Employee [name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", workRoom=" + workRoom + ", salary=" + salary + ", workDay=" + workDay + "]";
	}
}
