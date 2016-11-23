package question1.yzl;

import java.util.Scanner;

public class Test {
	public static void main(String[] args)
	{
		int ans=0;
		int array[]={1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,
				1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13};
		for(int i=0;i<array.length;++i)
		{
			for(int j=0;j<array.length;++j)
			{
				if(array[i]+array[j]>=24||i==j)continue;
				for(int k=0;k<array.length;++k)
				{
					if(array[i]+array[j]+array[k]>=24||i==k||j==k)continue;
					for(int q=0;q<array.length;++q)
					{
						if(q==i||q==j||q==k)continue;
						if(array[i]+array[j]+array[k]+array[q]==24)ans++;
					}
				}
			}
		}
		//四张牌的排列是A(4,4)所以除于24
		System.out.println(ans/24);
	}
}
