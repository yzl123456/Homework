package lab5;

import java.util.Date;

public class Time {
	private int hour;//3个数据域
	private int minute;
	private int second;
	public int getHour() {//3个get方法
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public Time() {//无参构造器
		long tmp=System.currentTimeMillis()/1000;//注意返回的是毫秒，换成秒
		long day=60*60*24;//得到对应的hour minute second
		hour=(int) (tmp%day/3600);
		minute=(int) (tmp%day%3600/60);
		second=(int) (tmp%day%60);
	}
	public Time(long tmp){//构造器方法直接采用set方法
		setTime(tmp);
	}
	public void setTime(long tmp){//设置当前时间
		long day=60*60*24;
		hour=(int) (tmp%day/3600);
		minute=(int) (tmp%day%3600/60);
		second=(int) (tmp%day%60);
	}
	
}
