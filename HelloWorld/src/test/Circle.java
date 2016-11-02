package test;
public class Circle extends GeometricObject implements Comparable{
	private double radius;
	public Circle(double radiusTemp) {
		this.radius = radiusTemp;
	}

	@Override
	public double getArea() {
		return Math.PI*this.radius*this.radius;
	}

	@Override
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}
	public double getRadius() {
		return this.radius;
	}

	

	
	

}

