package question4.yzl;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question2 {

	public static void main(String[] args) {
		StringBuilder s1=new StringBuilder("java");
		StringBuilder s2=new StringBuilder("html");
		//（1）s1.append("is fun");
		System.out.println(s1.append("is fun"));
		s1=new StringBuilder("java");s2=new StringBuilder("html");//初始化
		//（2）s1.insert(2,"is fun");
		System.out.println(s1.insert(2, "is fun"));
		s1=new StringBuilder("java");s2=new StringBuilder("html");//初始化
		//（3）s1.charAt(2);
		System.out.println(s1.charAt(2));
		s1=new StringBuilder("java");s2=new StringBuilder("html");//初始化
		//(4) s1.deleteCharAt(2);
		System.out.println(s1.deleteCharAt(2));
		s1=new StringBuilder("java");s2=new StringBuilder("html");//初始化
		//(5) s1.delete (1,3);
		System.out.println(s1.delete(1, 3));
		s1=new StringBuilder("java");s2=new StringBuilder("html");//初始化
		//(6) s1.reverse ();
		System.out.println(s1.reverse());
		s1=new StringBuilder("java");s2=new StringBuilder("html");//初始化
		//(7) s1.replace (1,3,“computer”);
		System.out.println(s1.replace(1,3, "computer"));
		s1=new StringBuilder("java");s2=new StringBuilder("html");//初始化
		//(8) s1.substring (1,3);
		System.out.println(s1.substring(1,3));
		s1=new StringBuilder("java");s2=new StringBuilder("html");//初始化
		//(9) s1.substring (2);
		System.out.println(s1.substring(2));
	}
}
