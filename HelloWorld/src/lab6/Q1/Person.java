package lab6.Q1;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Person {
	private final String name="myPerson";//定义final
	private final String address="hznu";
	private final String phone="3333333333";
	private final String email="3333333333@qq.com";
	public Person() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
