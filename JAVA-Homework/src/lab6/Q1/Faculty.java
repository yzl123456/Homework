package lab6.Q1;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Faculty extends Employee{

	private String workTime;
	private String level;
	//构造器
	public Faculty(String name, String address, String phone, String email, String workRoom, int salary, MyDate workDay,
			String workTime, String level) {
		super(name, address, phone, email, workRoom, salary, workDay);
		this.workTime = workTime;
		this.level = level;
	}
	//tostring
	@Override
	public String toString() {
		return "Faculty "+getName();
	}
}
