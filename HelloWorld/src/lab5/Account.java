package lab5;

import java.util.Date;

public class Account {
	private int id=0;//��ʼ��idΪ0
	private double balance;
	private double annualInterestRate=0;//��ʼ��������Ϊ0
	private Date dateCreated=new Date();//����ʱ��Ϊ��ǰʱ��
	public Account() {//�޲ι�����
	}
	public Account(int id, double balance) {//���ι�����
		super();
		this.id = id;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public Date getDateCreated() {//dateֻ�ṩget���� ��ֹ�޸�
		return dateCreated;
	}
	public double getMonthlyInterestRate(){
		return annualInterestRate/12;
	}
	public void withDraw(double money){
		balance-=money;
	}
	public void deposit(double money){
		balance+=money;
	}
}
