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
//	private String url = "jdbc:odbc:myODBC"; // 指定连接数据库的URL
	private String user = "root"; // 指定连接数据库的用户名
	private String passWord = "cbxyzl"; // 指定连接数据库的密码
	
	public void getConnection(){
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lab12",user,passWord);// 创建数据库连接
			if (conn != null) { // 如果Connection实例不为空
				System.out.println("数据库连接成功"); // 提示信息
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	public void queryInDB(){
		try {
			// 创建statement对象
			sta = conn.prepareStatement("SELECT * FROM studentInfo");
			String sqlStatement= "SELECT * FROM studentInfo";
			// 把SELECT语句传给DBMS
//			sta.executeUpdate("insert into contactlist values(2,'jun','189678','hangzhou')");
			rs=sta.executeQuery();
//			rs = sta.executeQuery(sqlStatement);
			// 显示查询结果
			System.out.println("\n查找到的学生信息");
			System.out.println("--------------------------");
			while (rs.next()) {
				// 根据字段名称 获得各个字段的值
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
