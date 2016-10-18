package lab5;

import java.util.Date;

public class Time {
	private int hour;//3��������
	private int minute;
	private int second;
	public int getHour() {//3��get����
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public Time() {//�޲ι�����
		long tmp=System.currentTimeMillis()/1000;//ע�ⷵ�ص��Ǻ��룬������
		long day=60*60*24;//�õ���Ӧ��hour minute second
		hour=(int) (tmp%day/3600);
		minute=(int) (tmp%day%3600/60);
		second=(int) (tmp%day%60);
	}
	public Time(long tmp){//����������ֱ�Ӳ���set����
		setTime(tmp);
	}
	public void setTime(long tmp){//���õ�ǰʱ��
		long day=60*60*24;
		hour=(int) (tmp%day/3600);
		minute=(int) (tmp%day%3600/60);
		second=(int) (tmp%day%60);
	}
	
}
