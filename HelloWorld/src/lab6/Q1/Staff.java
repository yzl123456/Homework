package lab6.Q1;
/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Staff extends Employee{
	private final String name="myStaff";//����final
	private final String address="hznu";
	private final String phone="55555555555";
	private final String email="55555555555@qq.com";
	private String title;
	//������
	public Staff(String workRoom, int salary, MyDate workDay, String title) {
//		super(workRoom, salary, workDay);
		super();
		this.title = title;
	}
	//tostring
	@Override
	public String toString() {
		return "Staff [name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", title="
				+ title + "]";
	}
	
}
