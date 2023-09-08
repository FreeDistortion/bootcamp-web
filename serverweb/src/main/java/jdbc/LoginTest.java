package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//id가 bts1이고 pass가 2323인 data조회
//있으면 출력 없으면 없다.
public class LoginTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("SELECT * FROM MEMBER ");
		sqlCommand.append("WHERE ID='BTS1' AND PASS='2323'");
		
		
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
			
			//그러나, 해당 경우의 경우 PK로 비교를 하는 것이기 때문에 중복 data의 걱정이 없어 while이 아닌 if로 비교해도 된다.
			/*
			 if (rs.next()) {
				System.out.print(rs.getString("ID")+"\t");
				System.out.print(rs.getString("PASS")+"\t");
				System.out.print(rs.getString("NAME")+"\t");
				System.out.print(rs.getString("ADDR")+"\t");
				System.out.print(rs.getDate("REGDATE")+"\t");
				System.out.print(rs.getString("POINT")+"\t");
				System.out.println(rs.getString(7)+"\t");
			}
			 
			 */
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
