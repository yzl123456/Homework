package lab5;

import java.util.Date;

public class Account {
	private int id=0;//初始化id为0
	private double balance;
	private double annualInterestRate=0;//初始化年利率为0
	private Date dateCreated=new Date();//创建时间为当前时间
	public Account() {//无参构造器
	}
	public Account(int id, double balance) {//带参构造器
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
	public Date getDateCreated() {//date只提供get方法 防止修改
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
