package question4.yzl;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question1 {
	public static void main(String[] args) {
		String s1="Welcome";
		String s2="welcome";
		//检查s1和s2是否相等，然后将结果赋值给一个布尔变量isEqual
		boolean isEqual=s1.equals(s2);
		System.out.println(isEqual);
		//检查在忽略大小写的情况下s1和s2下是否相等，然后将结果赋值给一个布尔变量isEqual。
		isEqual=s1.equalsIgnoreCase(s2);
		System.out.println(isEqual);
		//比较s1和s2，然后将结果赋值给一个整型值x。
		int x=s1.compareTo(s2);
		System.out.println(x);
		//在忽略大小写的情况下比较s1和s2,然后将结果赋值给一个整型值x。
		x=s1.compareToIgnoreCase(s2);
		System.out.println(x);
		//检查s1是否有前缀“AAA”,然后将结果赋值给一个布尔变量b。
		boolean b=s1.startsWith("AAA");
		System.out.println(b);
		//检查s1是否有后缀“AAA”,然后将结果赋值给一个布尔变量b。
		b=s1.endsWith("AAA");
		System.out.println(b);
		//将s1的长度赋值给一个整型变量x。
		x=s1.length();
		System.out.println(x);
		//将s1的第一个字符赋值给一个字符型变量x。
		char ch=s1.charAt(0);
		System.out.println(ch);
		//创建一个新字符串s3，它是s1和s2的组合。
		String s3=s1+s2;
		System.out.println(s3);
		//创建一个s1的子串，下标从1开始。
		String subS1=s1.substring(1);
		System.out.println(subS1);
		//创建一个s1的子串，下标从1到4。
		subS1=s1.substring(1, 4);
		System.out.println(subS1);
		//创建一个新字符串s3，它将s1转换为小写。
		s3=s1.toLowerCase();
		System.out.println(s3);
		//创建一个新字符串s3，它将s1转换为大写。
		s3=s1.toUpperCase();
		System.out.println(s3);
		//创建一个新字符串s3，它将s1的两端的空格去掉。
		s3=s1.trim();
		System.out.println(s3);
		//用E替换s1中所有出现字符e的地方，然后将新字符串赋值给s3。
		s3=s1.replace('e', 'E');
		System.out.println(s3);
		//将“welcome to java and html”按空格分隔为一个数组tokens。
		String[] tokens="welcome to java and html".split(" ");
//		System.out.println(tokens);
		for(String str:tokens){
			System.out.print(str+" ");
		}
		System.out.println();
		//将s1中字符e第一次出现的下标赋值给一个int型变量x。
		x=s1.indexOf('e');
		System.out.println(x);
		//将s1中字符串abc最后一次出现的下标赋值给一个int型变量x。
		x=s1.lastIndexOf("abc");//未出现abc返回-1
		System.out.println(x);
	}
}
