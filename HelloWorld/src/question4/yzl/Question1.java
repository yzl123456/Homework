package question4.yzl;
/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question1 {
	public static void main(String[] args) {
		String s1="Welcome";
		String s2="welcome";
		//���s1��s2�Ƿ���ȣ�Ȼ�󽫽����ֵ��һ����������isEqual
		boolean isEqual=s1.equals(s2);
		System.out.println(isEqual);
		//����ں��Դ�Сд�������s1��s2���Ƿ���ȣ�Ȼ�󽫽����ֵ��һ����������isEqual��
		isEqual=s1.equalsIgnoreCase(s2);
		System.out.println(isEqual);
		//�Ƚ�s1��s2��Ȼ�󽫽����ֵ��һ������ֵx��
		int x=s1.compareTo(s2);
		System.out.println(x);
		//�ں��Դ�Сд������±Ƚ�s1��s2,Ȼ�󽫽����ֵ��һ������ֵx��
		x=s1.compareToIgnoreCase(s2);
		System.out.println(x);
		//���s1�Ƿ���ǰ׺��AAA��,Ȼ�󽫽����ֵ��һ����������b��
		boolean b=s1.startsWith("AAA");
		System.out.println(b);
		//���s1�Ƿ��к�׺��AAA��,Ȼ�󽫽����ֵ��һ����������b��
		b=s1.endsWith("AAA");
		System.out.println(b);
		//��s1�ĳ��ȸ�ֵ��һ�����ͱ���x��
		x=s1.length();
		System.out.println(x);
		//��s1�ĵ�һ���ַ���ֵ��һ���ַ��ͱ���x��
		char ch=s1.charAt(0);
		System.out.println(ch);
		//����һ�����ַ���s3������s1��s2����ϡ�
		String s3=s1+s2;
		System.out.println(s3);
		//����һ��s1���Ӵ����±��1��ʼ��
		String subS1=s1.substring(1);
		System.out.println(subS1);
		//����һ��s1���Ӵ����±��1��4��
		subS1=s1.substring(1, 4);
		System.out.println(subS1);
		//����һ�����ַ���s3������s1ת��ΪСд��
		s3=s1.toLowerCase();
		System.out.println(s3);
		//����һ�����ַ���s3������s1ת��Ϊ��д��
		s3=s1.toUpperCase();
		System.out.println(s3);
		//����һ�����ַ���s3������s1�����˵Ŀո�ȥ����
		s3=s1.trim();
		System.out.println(s3);
		//��E�滻s1�����г����ַ�e�ĵط���Ȼ�����ַ�����ֵ��s3��
		s3=s1.replace('e', 'E');
		System.out.println(s3);
		//����welcome to java and html�����ո�ָ�Ϊһ������tokens��
		String[] tokens="welcome to java and html".split(" ");
//		System.out.println(tokens);
		for(String str:tokens){
			System.out.print(str+" ");
		}
		System.out.println();
		//��s1���ַ�e��һ�γ��ֵ��±긳ֵ��һ��int�ͱ���x��
		x=s1.indexOf('e');
		System.out.println(x);
		//��s1���ַ���abc���һ�γ��ֵ��±긳ֵ��һ��int�ͱ���x��
		x=s1.lastIndexOf("abc");//δ����abc����-1
		System.out.println(x);
	}
}
