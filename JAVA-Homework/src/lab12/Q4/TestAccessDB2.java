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
//	private String url = "jdbc:odbc:myODBC"; // ָ���������ݿ��URL
	private String user = "root"; // ָ���������ݿ���û���
	private String passWord = "cbxyzl"; // ָ���������ݿ������
	
	private String[][] tableData;
	private String[] nameCols;
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
			// ����statement����
			sta = conn.prepareStatement(sql);
			String sqlStatement= sql;//ʹ�ô���sql
			rs=sta.executeQuery();
			rs.last();//�α��Ƶ����
			ResultSetMetaData rsmd = rs.getMetaData();
			tableData=new String[rs.getRow()][rsmd.getColumnCount()];
			rs.beforeFirst();//�α��Ƶ���һ�е�ǰ��
			int i=0;
			while (rs.next()) {
				for(int j=1;j<=rsmd.getColumnCount();j++){//ע��mysqlindex��1��ʼ
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
			// ����statement����
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
