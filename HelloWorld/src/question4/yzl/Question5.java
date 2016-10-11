package question4.yzl;

import java.util.Scanner;
/*
 * Ӧ����
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question5 {
	//getPos������������3��������λ�õ���Сֵ������ֵΪ-1������Ϊ���
	public static int getPos(int a,int b,int c){
		if(a==-1&&b==-1&&c==-1) return -1;//�������� ����-1
		if(a==-1) a=Integer.MAX_VALUE;//��������Ϊ���
		if(b==-1) b=Integer.MAX_VALUE;
		if(c==-1) c=Integer.MAX_VALUE;
		return Integer.min(c, Integer.min(a, b));//ȡ3�����е���С�ĵ�
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String genome=in.nextLine();//�����ַ���
		int start_point=0,end_point=0;//��ʼ����㣬ĩ��
		start_point= genome.indexOf("ATG");//��һ�ε����
		boolean isOut=false;//��־�Ƿ������
		//indexOf(str, fromIndex)���������ʾ��fromIndex
		//����±꿪ʼ�������Ƿ����str�ַ������ҵ������±꣬�Ҳ�������-1
		while(end_point!=-1&&start_point!=-1){//�������ڲ����յ����ʱ
			//ͨ�������õ�3�����з���Ҫ�����Сλ�õĵ㣬ע��Ҫ�����+3λ����
			end_point=getPos(genome.indexOf("TAG", start_point+3),
					genome.indexOf("TAA", start_point+3), genome.indexOf("TGA", start_point+3));
			if(end_point!=-1){
				for(int i=start_point+3;i<end_point;i++){//��������յ��еĻ���
					System.out.print(genome.charAt(i));
				}
				isOut=true;//��ʾ�������
				System.out.println();
			}
			start_point=genome.indexOf("ATG", end_point+3);//���ϴε��յ�+3��λ��������Ѱ�����
		}
		if(isOut==false) System.out.println("No gene is found");
	}
	
}
