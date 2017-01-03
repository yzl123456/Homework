package lab12.Q1;

// Needed for JDBC classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This program demonstrates how to connect to a Access database using JDBC-ODBC.
 */
public class TestAccessDB2 {
	private Connection conn; 
	private PreparedStatement sta;
	ResultSet rs;
//	private String url = "jdbc:odbc:myODBC"; // ָ���������ݿ��URL
	private String user = "root"; // ָ���������ݿ���û���
	private String passWord = "cbxyzl"; // ָ���������ݿ������
	
	public void getConnection(){
		try {
			// �������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lab12",user,passWord);// �������ݿ�����
			if (conn != null) { // ���Connectionʵ����Ϊ��
				System.out.println("���ݿ����ӳɹ�"); // ��ʾ��Ϣ
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	public void queryInDB(){
		try {
			// ����statement����
			sta = conn.prepareStatement("SELECT * FROM studentInfo");
			String sqlStatement= "SELECT * FROM studentInfo";
			// ��SELECT��䴫��DBMS
//			sta.executeUpdate("insert into contactlist values(2,'jun','189678','hangzhou')");
			rs=sta.executeQuery();
//			rs = sta.executeQuery(sqlStatement);
			// ��ʾ��ѯ���
			System.out.println("\n���ҵ���ѧ����Ϣ");
			System.out.println("--------------------------");
			while (rs.next()) {
				// �����ֶ����� ��ø����ֶε�ֵ
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\n");
//				System.out.print(rs.getString(5)+"\n");
//				System.out.print(rs.getDate(5)+"\n");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		try {
			rs.close();
			sta.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestAccessDB2 selectTest = new TestAccessDB2();
		selectTest.getConnection();
		selectTest.queryInDB();
		selectTest.closeConnection();	
	}
}
