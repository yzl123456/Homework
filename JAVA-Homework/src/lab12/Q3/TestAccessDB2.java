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
			rs.last();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("�����һ����"+rs.getRow()+"�У�"+rsmd.getColumnCount()+"��");
			System.out.println("�б���Ϊ:");
			for(int i=1;i<=rsmd.getColumnCount();i++){
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println("\n���������������Ϊ:");
			rs.beforeFirst();
			while (rs.next()) {
				// �����ֶ����� ��ø����ֶε�ֵ
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
			// ����statement����
			sta = conn.prepareStatement(sql);
			String sqlStatement= sql;//ʹ�ô����sql���
			rs=sta.executeQuery();//ִ�����
			// ��ʾ��ѯ���
			rs.last();//�α��Ƶ����
			ResultSetMetaData rsmd = rs.getMetaData();
			tableData=new String[rs.getRow()][rsmd.getColumnCount()];
			rs.beforeFirst();//�α��Ƶ���һ��ǰ
			int i=0;
			while (rs.next()) {//��ȡ��װ��Ҫ��tableData��ע��mysql�е�index�Ǵ�1��ʼ��
				for(int j=1;j<=rsmd.getColumnCount();j++){
					tableData[i][j-1]=rs.getString(j)+"";//ͨ��String���ܾ���ƥ��
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
			String sqlStatement= sql;//���ô���sql
			rs=sta.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();//�õ�Ԫ����
			nameCols=new String[rsmd.getColumnCount()];//new 
			int j=0;
			for(int i=1;i<=rsmd.getColumnCount();i++){
				nameCols[j++]=rsmd.getColumnLabel(i);//�õ��б�ǩ
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
