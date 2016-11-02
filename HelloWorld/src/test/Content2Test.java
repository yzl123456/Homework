package test;


public class Content2Test {

    public static void main(String[] args){
        Circle circle1 = new Circle(15);
        Circle circle2 = new Circle(15);
        System.out.println(circle1.equals(circle2));
        System.out.println(circle1.compareTo(circle2));
    }
}
