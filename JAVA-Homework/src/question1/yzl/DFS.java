package question1.yzl;

import java.io.PrintStream;
import java.util.Scanner;

public class DFS {
	public static void main(String[] args)
	{
		Scanner fin=new Scanner(System.in);
		PrintStream fout = new PrintStream(System.out);
		long[] C=new long[]{1,4,6,4,1}; //����� C(i��4)
		long Ans = 0; // ���
		int[] cot=new int[4]; // �����Ƶĵ���
		int all = 24;  // �ܵ���
		for(cot[0]=1;cot[0]<=13;cot[0]++)
			for(cot[1]=cot[0];cot[1]<=13;cot[1]++)
				for(cot[2]=cot[1];cot[2]<=13;cot[2]++)
				{
					//ö��ǰ�����Ƶĵ���
					cot[3]=all-(cot[0]+cot[1]+cot[2]);//�������Ƶĵ���
					if(cot[1]+cot[0]+cot[2]>=all)continue;
					if(cot[3]<cot[2])continue;
					if(cot[3]>13||cot[3]<1)continue;
					//���Ϸ������ontinue
					int flag=1;
					long ga=1;
					for(int i=1;i<4;i++) //ͳ��ÿ���Ƶ���Ŀ
					{
						if(cot[i]!=cot[i-1])
						{
							ga*=C[flag]; //����ǰ�������Ŀ
							flag=1;
						}
						else flag++;
					}
					ga*=C[flag];
					Ans+=ga;//��ǰ���������
					fout.printf("%d %d %d %d %d\n", cot[0],cot[1],cot[2],cot[3],ga);
					//fout.print(C[flag]+"\n");
					//fout.print(Ans);
				}
		fout.print(Ans);
	}
}
