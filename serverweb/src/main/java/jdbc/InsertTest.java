package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql="INSERT INTO MEMBER VALUES('BTS3','1234','SUGAR','서울',SYSDATE,10000,'RAPPER')";		
		try {
			//1. driver loading
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully!");
			
			//2. create connection
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected successfully!" + con);
			
			//3. SQL문 실행 위한 객체 생성
			Statement stmt=con.createStatement();
			System.out.println("Statement object: "+stmt);
			
			//4. SQL문 실행
			int result=stmt.executeUpdate(sql);
			
			//5. 결과 처리
			System.out.println(result+" rows insert completed!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
