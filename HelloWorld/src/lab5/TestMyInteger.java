package lab5;

public class TestMyInteger {
	public static void main(String[] args) {
		MyInteger myInteger=new MyInteger(5);//生成一个对象
		System.out.println(myInteger.getValue());//得到value值
		
		System.out.println(myInteger.isEven());//判断该对象的value值的奇、偶、质数
		System.out.println(myInteger.isOdd());
		System.out.println(myInteger.isPrime());
		
		System.out.println(MyInteger.isEven(4));//判断一个int型的值的奇、偶、质数
		System.out.println(MyInteger.isOdd(4));
		System.out.println(MyInteger.isPrime(4));
		
		System.out.println(MyInteger.isEven(myInteger));//判断一个对象是奇、偶、质数
		System.out.println(MyInteger.isOdd(myInteger));
		System.out.println(MyInteger.isPrime(myInteger));
		
		System.out.println(myInteger.equals(5));//与一个int比较
		System.out.println(myInteger.equals(new MyInteger(5)));//与一个对象比较
		
		char str[]=new char[]{'1','2','3','4'};//将字符数组转成int
		System.out.println(MyInteger.parseInt(str));
		String string="1234";//将String转成int
		System.out.println(MyInteger.parseInt(string));
		
		
	}
}
