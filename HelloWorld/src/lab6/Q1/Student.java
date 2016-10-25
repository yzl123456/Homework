package lab6.Q1;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Student extends Person{
	private final String name="myStudent";//定义final
	private final String address="hznu";
	private final String phone="22222222222";
	private final String email="22222222222@qq.com";
	private final String grade="大二";
	public Student() {
		// TODO Auto-generated constructor stub
	}
	//tostring
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", grade="
				+ grade + "]";
	}
	
	
	
}
