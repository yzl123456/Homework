package lab6.Q1;
/*
 * ”¶‘Û¡÷
 * JAVA programing Autumn 2016
 * Lab 2
 */
public class Student extends Person{
	private final String grade;
	
	public Student(String name, String address, String phone, String email, String grade) {
		super(name, address, phone, email);
		this.grade = grade;
	}

	//tostring
	@Override
	public String toString() {
		return "Student "+getName();
	}
	
	
	
}
