package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CloseTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott"; 
		String password = "tiger";
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("SELECT * FROM MEMBER");
		
		Connection conn=null;
		PreparedStatement ptmt=null;
		ResultSet rs =null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url, user, password);
			ptmt=conn.prepareStatement(sqlCommand.toString());
			rs=ptmt.executeQuery(sqlCommand.toString());
			System.out.println("조회된 ResultSet Object: "+rs);
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
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ptmt!=null)ptmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
