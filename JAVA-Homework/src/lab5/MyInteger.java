package lab5;

public class MyInteger {
	private int value;//value值
	public int getValue() {
		return value;
	}
	public MyInteger(int value) {//构造器初始化value
		super();
		this.value = value;
	}
	
	public boolean isEven(){//判断对象本身的value是偶
		if(value%2==0) return true;
		else return false;
	}
	public static boolean isEven(int x){//方法重载，参数为一个int 注意静态
		if(x%2==0) return true;
		else return false;
	}
	public static boolean isEven(MyInteger myInteger){//方法重载，参数为一对象 注意静态
		return isEven(myInteger.getValue());
	}
	
	public boolean isOdd(){//同Even的方法重载
		return !isEven();
	}
	public static boolean isOdd(int x){
		if(x%2==1) return true;
		else return false;
	}
	public static boolean isOdd(MyInteger myInteger){
		return isOdd(myInteger.getValue());
	}
	
	public boolean isPrime(){//同Even的方法重载
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
	
	public boolean equals(int x){//比较value是否与一个int相等
		return x==value;
	}
	public boolean equals(MyInteger myInteger){//比较一个外来对象是否与本身的value相等
		return myInteger.getValue()==value;
	}
	
	public static int parseInt(char[] str){//将字符数组转成int，注意静态
		int number=0;
		for(int i=0;i<str.length;i++){
			number=number*10+str[i]-'0';//多项式
		}
		return number;
	}
	public static int parseInt(String s){//将String转成int
		int number=0;
		for(int i=0;i<s.length();i++){
			number=number*10+s.charAt(i)-'0';//多项式
		}
		return number;
	}
}
