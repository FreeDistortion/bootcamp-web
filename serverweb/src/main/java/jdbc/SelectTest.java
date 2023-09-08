package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("SELECT * FROM MEMBER");
		
		
		try {
			//1. driver loading
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. make connection
			Connection conn=DriverManager.getConnection(url, user, password);
			//3. make object for execute SQL command
			Statement statement=conn.createStatement();
			//4. execute SQL command
			ResultSet rs = statement.executeQuery(sqlCommand.toString());
			System.out.println("조회된 ResultSet Object: "+rs);
			//5. result handling
			/*
			 * if(rs.next()) { System.out.println("Record(row) exists."); }else {
			 * System.out.println("Record(row) non-exists."); }
			 */
			while (rs.next()) {
				System.out.print(rs.getString("ID")+"\t");
				System.out.print(rs.getString("PASS")+"\t");
				System.out.print(rs.getString("NAME")+"\t");
				System.out.print(rs.getString("ADDR")+"\t");
				System.out.print(rs.getDate("REGDATE")+"\t");
				System.out.print(rs.getString("POINT")+"\t");
				System.out.println(rs.getString(7)+"\t");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
