package lab5;

public class TestMyInteger {
	public static void main(String[] args) {
		MyInteger myInteger=new MyInteger(5);//����һ������
		System.out.println(myInteger.getValue());//�õ�valueֵ
		
		System.out.println(myInteger.isEven());//�жϸö����valueֵ���桢ż������
		System.out.println(myInteger.isOdd());
		System.out.println(myInteger.isPrime());
		
		System.out.println(MyInteger.isEven(4));//�ж�һ��int�͵�ֵ���桢ż������
		System.out.println(MyInteger.isOdd(4));
		System.out.println(MyInteger.isPrime(4));
		
		System.out.println(MyInteger.isEven(myInteger));//�ж�һ���������桢ż������
		System.out.println(MyInteger.isOdd(myInteger));
		System.out.println(MyInteger.isPrime(myInteger));
		
		System.out.println(myInteger.equals(5));//��һ��int�Ƚ�
		System.out.println(myInteger.equals(new MyInteger(5)));//��һ������Ƚ�
		
		char str[]=new char[]{'1','2','3','4'};//���ַ�����ת��int
		System.out.println(MyInteger.parseInt(str));
		String string="1234";//��Stringת��int
		System.out.println(MyInteger.parseInt(string));
		
		
	}
}
