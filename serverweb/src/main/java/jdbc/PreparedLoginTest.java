package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.runtime.ObjectMethods;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//id가 bts1이고 pass가 2323인 data조회
//있으면 출력 없으면 없다.
public class PreparedLoginTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String id;
		try {
			System.out.print("id: ");
			id = bf.readLine();
			System.out.print("pass: ");
			String pass=bf.readLine();
		
		PreparedLoginTest obj = new PreparedLoginTest();
		obj.login(id,pass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void login(String id,String pass) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("SELECT * FROM MEMBER ");
		
		//1. SQL command에서 외부에서 압력 받을 부분은 ?로 표시.
		sqlCommand.append("WHERE ID=? AND PASS=?");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(url, user, password);
			//2. PreparedStatement객체 생성
			PreparedStatement ptmt=conn.prepareStatement(sqlCommand.toString());
			
			//3. ?에 대해서 값 세팅
			ptmt.setString(1,id);
			ptmt.setString(2,pass);

			//4. SQL command 실행 - method 호출할 때 SQL command 빼고 호출
			ResultSet rs = ptmt.executeQuery(sqlCommand.toString());
			if (rs.next()) {
				System.out.print(rs.getString("ID")+"\t");
				System.out.print(rs.getString("PASS")+"\t");
				System.out.print(rs.getString("NAME")+"\t");
				System.out.print(rs.getString("ADDR")+"\t");
				System.out.print(rs.getDate("REGDATE")+"\t");
				System.out.print(rs.getString("POINT")+"\t");
				System.out.println(rs.getString(7)+"\t");
			}else {
				System.out.println("Login failed.");

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
