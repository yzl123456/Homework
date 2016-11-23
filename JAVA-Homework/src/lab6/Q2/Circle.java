package lab6.Q2;

public class Circle extends GeometricObject implements Comparable{
	private double radius;	
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle){
			Circle circle=(Circle) o;
			if(this.getArea()>circle.getArea()){
				return 1;
			}
			else if(this.getArea()<circle.getArea()){
				return -1;
			}
			else return 0;
		}
		throw new RuntimeException("³ö´íÁË");
	}
	@Override
	public boolean equals(Object object) {
		if(object instanceof Circle)
			return this.radius==((Circle) object).getRadius();
		else return false;
	}

	@Override
	public double getArea() {
		return Math.PI*radius*radius;
	}

	@Override
	public double getPerimeter() {
		return Math.PI*radius*2;
	}
}
