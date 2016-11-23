package lab6.Q2;

public class Test {
	public static void main(String[] args) {
		Circle circle1=new Circle(5.0);
		Circle circle2=new Circle(5.0);
		System.out.println(circle1.compareTo(circle2));
		System.out.println(circle1.equals(circle2));
		
		circle1.setRadius(4.0);
		System.out.println(circle1.compareTo(circle2));
		System.out.println(circle1.equals(circle2));
	}
}
