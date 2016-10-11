package question4.yzl;

import java.util.Scanner;
/*
 * 应泽林
 * JAVA programing Autumn 2016
 * Lab 4
 */
public class Question5 {
	//getPos函数是用来求3个结束点位置的最小值，若有值为-1，则置为最大
	public static int getPos(int a,int b,int c){
		if(a==-1&&b==-1&&c==-1) return -1;//都不存在 返回-1
		if(a==-1) a=Integer.MAX_VALUE;//不存在置为最大
		if(b==-1) b=Integer.MAX_VALUE;
		if(c==-1) c=Integer.MAX_VALUE;
		return Integer.min(c, Integer.min(a, b));//取3个点中的最小的点
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String genome=in.nextLine();//输入字符串
		int start_point=0,end_point=0;//初始化起点，末点
		start_point= genome.indexOf("ATG");//第一次的起点
		boolean isOut=false;//标志是否输出过
		//indexOf(str, fromIndex)这个函数表示从fromIndex
		//这个下标开始往下搜是否存在str字符串，找到返回下标，找不到返回-1
		while(end_point!=-1&&start_point!=-1){//当起点存在并且终点存在时
			//通过函数得到3个点中符合要求的最小位置的点，注意要从起点+3位置搜
			end_point=getPos(genome.indexOf("TAG", start_point+3),
					genome.indexOf("TAA", start_point+3), genome.indexOf("TGA", start_point+3));
			if(end_point!=-1){
				for(int i=start_point+3;i<end_point;i++){//输出起点和终点中的基因
					System.out.print(genome.charAt(i));
				}
				isOut=true;//表示输出过了
				System.out.println();
			}
			start_point=genome.indexOf("ATG", end_point+3);//从上次的终点+3的位置再往下寻找起点
		}
		if(isOut==false) System.out.println("No gene is found");
	}
	
}
