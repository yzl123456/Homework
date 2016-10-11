package question1.yzl;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray extends ArrayList<String> {
	int[] numbers=new int[4];
	public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public boolean equals(MyArray obj) {
		
		int []test=obj.getNumbers();
		for(int i=0;i<4;i++){
			if(numbers[i]!=test[i]){
				//System.out.println("false!");
				return false;
			}
		}
		//System.out.println("TRUE!");
		return true;
	}
	@Override
	public String toString() {
		String tmp=numbers[0]+" "+numbers[1]+" "+numbers[2]+" "+numbers[3];
		return tmp;
	}
	
}
