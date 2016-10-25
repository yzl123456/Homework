package lab6.Q1;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Faculty extends Employee{
	private final String name="myFaculty";//定义final
	private final String address="hznu";
	private final String phone="44444444444";
	private final String email="44444444444@qq.com";
	private String workTime;
	private String level;
	//构造器
	public Faculty(String workRoom, int salary, MyDate workDay, String workTime, String level) {
		super(workRoom, salary, workDay);
		this.workTime = workTime;
		this.level = level;
	}
	//tostring
	@Override
	public String toString() {
		return "Faculty [name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", workTime=" + workTime + ", level=" + level + "]";
	}

	
}
