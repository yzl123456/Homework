package lab5;

public class MyInteger {
	private int value;//valueֵ
	public int getValue() {
		return value;
	}
	public MyInteger(int value) {//��������ʼ��value
		super();
		this.value = value;
	}
	
	public boolean isEven(){//�ж϶������value��ż
		if(value%2==0) return true;
		else return false;
	}
	public static boolean isEven(int x){//�������أ�����Ϊһ��int ע�⾲̬
		if(x%2==0) return true;
		else return false;
	}
	public static boolean isEven(MyInteger myInteger){//�������أ�����Ϊһ���� ע�⾲̬
		return isEven(myInteger.getValue());
	}
	
	public boolean isOdd(){//ͬEven�ķ�������
		return !isEven();
	}
	public static boolean isOdd(int x){
		if(x%2==1) return true;
		else return false;
	}
	public static boolean isOdd(MyInteger myInteger){
		return isOdd(myInteger.getValue());
	}
	
	public boolean isPrime(){//ͬEven�ķ�������
		if(value==1) return false;
		if(value==2) return true;
		for(int i=2;i*i<=value;i++){
			if(value%i==0)
				return false;
		}
		return true;
	}
	public static boolean isPrime(int x){
		if(x==1) return false;
		if(x==2) return true;
		for(int i=2;i*i<=x;i++){
			if(x%i==0) return false;
		}
		return true;
	}
	public static boolean isPrime(MyInteger myInteger){
		return isPrime(myInteger.getValue());
	}
	
	public boolean equals(int x){//�Ƚ�value�Ƿ���һ��int���
		return x==value;
	}
	public boolean equals(MyInteger myInteger){//�Ƚ�һ�����������Ƿ��뱾���value���
		return myInteger.getValue()==value;
	}
	
	public static int parseInt(char[] str){//���ַ�����ת��int��ע�⾲̬
		int number=0;
		for(int i=0;i<str.length;i++){
			number=number*10+str[i]-'0';//����ʽ
		}
		return number;
	}
	public static int parseInt(String s){//��Stringת��int
		int number=0;
		for(int i=0;i<s.length();i++){
			number=number*10+s.charAt(i)-'0';//����ʽ
		}
		return number;
	}
}
