package lab5;

public class TestTime {
	public static void main(String[] args) {
		Time time1=new Time();//�޲ι���
		Time time2=new Time(555550);//�вι���
		System.out.println(time1.getHour()+":"+time1.getMinute()+":"+time1.getSecond());//���
		System.out.println(time2.getHour()+":"+time2.getMinute()+":"+time2.getSecond());
	}
}
