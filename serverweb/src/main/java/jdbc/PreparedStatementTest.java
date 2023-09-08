package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
	InsertTest,UpdateTest,DeleteTest,SelectTest를 모두 PreparedStatement가 적용되도록 변경하세요.
	
	PreparedInsertTest, PreparedUpdateTest, PreparedDeleteTest,PreparedSelectTest
	
	
	Insert
	현재날짜, 1000은 기본값으로 주고 5개만 입력받기
	
	[출처] PreparedStatement로 변경하기|작성자 heaves1
*/

public class PreparedStatementTest {
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String user="scott";
	private static String password="tiger";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bf =new BufferedReader (new InputStreamReader(System.in));
			System.out.print("아이디:");
			String id = bf.readLine();
			System.out.print("패스워드:");
			String pass = bf.readLine();
			System.out.print("성명:");
			String name = bf.readLine();
			System.out.print("주소:");
			String addr = bf.readLine();
			System.out.print("기타:");
			String info = bf.readLine();
			
			PreparedStatementTest m = new PreparedStatementTest();
			System.out.println("login");
			m.login(id, pass);
			System.out.println("update");
			m.update(id, addr);
			System.out.println("delete");
			m.delete(id);
			System.out.println("insert");
			m.insert(id, pass, name, addr, info);
			System.out.println("select");
			m.select();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void login(String id,String pass) {
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("SELECT * FROM MEMBER ");
		sqlCommand.append("WHERE ID=? AND PASS=?");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(this.url, this.user, this.password);
			PreparedStatement preparedStmt=conn.prepareStatement(sqlCommand.toString());
			
			preparedStmt.setString(1,id);
			preparedStmt.setString(2,pass);

			ResultSet rs = preparedStmt.executeQuery(sqlCommand.toString());
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

	public void update(String id,String addr) {
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("UPDATE MEMBER SET ");
		sqlCommand.append("ADDR=? WHERE ID=?");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(this.url, this.user, this.password);
			PreparedStatement preparedStmt=con.prepareStatement(sqlCommand.toString());
			
			preparedStmt.setString(1,addr);
			preparedStmt.setString(2,id);
			
			ResultSet result=preparedStmt.executeQuery(sqlCommand.toString());
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("DELETE FROM MEMBER WHERE ");
		sqlCommand.append("ID=?");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(this.url, this.user, this.password);
			PreparedStatement preparedStmt=con.prepareStatement(sqlCommand.toString());

			preparedStmt.setString(1,id);

			ResultSet result=preparedStmt.executeQuery(sqlCommand.toString());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insert(String id, String pass, String name, String addr, String info) {
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("INSERT INTO MEMBER VALUES(");
		sqlCommand.append("?,?,?,?,SYSDATE,10000,?)");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(this.url, this.user, this.password);
			PreparedStatement preparedStmt=con.prepareStatement(sqlCommand.toString());
			
			preparedStmt.setString(1,id);
			preparedStmt.setString(2,pass);
			preparedStmt.setString(3,name);
			preparedStmt.setString(4,addr);
			preparedStmt.setString(5,info);
			
			
			ResultSet result=preparedStmt.executeQuery(sqlCommand.toString());
			
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
	
	public void select() {
		StringBuffer sqlCommand=new StringBuffer();
		sqlCommand.append("INSERT INTO MEMBER VALUES(");
		sqlCommand.append("?,?,?,?,SYSDATE,10000,?)");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(this.url, this.user, this.password);
			PreparedStatement preparedStmt=con.prepareStatement(sqlCommand.toString());
			
			ResultSet rs = preparedStmt.executeQuery(sqlCommand.toString());
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
		}
	}
}
