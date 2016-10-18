package fortest;

public class Foo {
    int i=5;
    static int k=2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=i;
		ml();
		System.out.println(i);
	}
	public void ml(){
		i=i+k+m2(i,k);
	}
	
	public static int m2(int i,int j){
		return (int)(Math.pow(i, j));
	}
	

}
