package lab5;

public class AccountTest {
	public static void main(String[] args) {
		Account account=new Account(1122, 20000);//new һ������ ��ʼ��id balance
		account.setAnnualInterestRate(0.045);//����������
		account.withDraw(2500);//ȡ��
		account.deposit(3000);//���
		//���
		System.out.println("���: "+account.getBalance());
		System.out.println("����Ϣ: "+account.getMonthlyInterestRate()*account.getBalance());
		System.out.println("��������: "+account.getDateCreated());
	}
}
