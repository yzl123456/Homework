package lab12.Q4;

import java.io.ObjectInputStream.GetField;
// Needed for JDBC classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
	
	private String[][] tableData;
	private String[] nameCols;
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
	
	public void closeConnection(){
		try {
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String[][] getTableData(String sql){
		try {
			// 创建statement对象
			sta = conn.prepareStatement(sql);
			String sqlStatement= sql;//使用传入sql
			rs=sta.executeQuery();
			rs.last();//游标移到最后
			ResultSetMetaData rsmd = rs.getMetaData();
			tableData=new String[rs.getRow()][rsmd.getColumnCount()];
			rs.beforeFirst();//游标移到第一行的前面
			int i=0;
			while (rs.next()) {
				for(int j=1;j<=rsmd.getColumnCount();j++){//注意mysqlindex从1开始
					tableData[i][j-1]=rs.getString(j)+"";
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableData;
	}
	public String[] getNameCols(String sql){
		try {
			// 创建statement对象
			sta = conn.prepareStatement(sql);
			String sqlStatement= sql;
			rs=sta.executeQuery();	
			ResultSetMetaData rsmd=rs.getMetaData();
			nameCols=new String[rsmd.getColumnCount()];
			int j=0;
			for(int i=1;i<=rsmd.getColumnCount();i++){
				nameCols[j++]=rsmd.getColumnLabel(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nameCols;
	}
}
