package lab12.Q3;

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
			rs.last();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("结果集一共有"+rs.getRow()+"行，"+rsmd.getColumnCount()+"列");
			System.out.println("列标题为:");
			for(int i=1;i<=rsmd.getColumnCount();i++){
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println("\n结果集中所有数据为:");
			rs.beforeFirst();
			while (rs.next()) {
				// 根据字段名称 获得各个字段的值
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getInt(6)+"\t");
				System.out.print(rs.getInt(7)+"\n");
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
	public String[][] getTableData(String sql){
		try {
			// 创建statement对象
			sta = conn.prepareStatement(sql);
			String sqlStatement= sql;//使用传入的sql语句
			rs=sta.executeQuery();//执行语句
			// 显示查询结果
			rs.last();//游标移到最后
			ResultSetMetaData rsmd = rs.getMetaData();
			tableData=new String[rs.getRow()][rsmd.getColumnCount()];
			rs.beforeFirst();//游标移到第一行前
			int i=0;
			while (rs.next()) {//提取组装需要的tableData，注意mysql中的index是从1开始的
				for(int j=1;j<=rsmd.getColumnCount();j++){
					tableData[i][j-1]=rs.getString(j)+"";//通过String接受均可匹配
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
			String sqlStatement= sql;//利用传入sql
			rs=sta.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();//得到元数据
			nameCols=new String[rsmd.getColumnCount()];//new 
			int j=0;
			for(int i=1;i<=rsmd.getColumnCount();i++){
				nameCols[j++]=rsmd.getColumnLabel(i);//得到列标签
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nameCols;
	}
	
	public static void main(String[] args) {
		TestAccessDB2 selectTest = new TestAccessDB2();
		selectTest.getConnection();
//		selectTest.queryInDB();
		String sql="select * from studentInfo";
		System.out.println("-----------show tableData");
		String[][] tableData2 = selectTest.getTableData(sql);
		List<String[]> list = Arrays.asList(tableData2);
		for(int i=0;i<list.size();i++){
			System.out.println(Arrays.asList(list.get(i)));
		}
		
		System.out.println("----------show nameColumn");
		String[] nameColumn=selectTest.getNameCols(sql);
		System.out.println(Arrays.asList(nameColumn));
		selectTest.closeConnection();	
	}
}
