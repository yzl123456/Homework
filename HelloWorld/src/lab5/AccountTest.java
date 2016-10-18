package lab5;

public class AccountTest {
	public static void main(String[] args) {
		Account account=new Account(1122, 20000);//new 一个对象 初始化id balance
		account.setAnnualInterestRate(0.045);//设置年利率
		account.withDraw(2500);//取款
		account.deposit(3000);//存款
		//输出
		System.out.println("余额: "+account.getBalance());
		System.out.println("月利息: "+account.getMonthlyInterestRate()*account.getBalance());
		System.out.println("开户日期: "+account.getDateCreated());
	}
}
