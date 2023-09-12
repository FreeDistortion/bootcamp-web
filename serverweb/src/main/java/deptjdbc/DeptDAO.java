package deptjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO {

	public int insert(int deptno, String deptname, String tel, String addr) {
		StringBuffer sql=new StringBuffer();
		sql.append("INSERT INTO MYDEPT VALUES(");
		//DEPTNO, DEPTNAME, TEL, ADDR
		sql.append("?,?,?,?)");
		
		Connection conn=null;
		PreparedStatement prpdStmt= null;
		int result=0;
		
		
		try {
			conn=DBUtil.getConnect();
			prpdStmt=conn.prepareStatement(sql.toString());
			prpdStmt.setInt(1, deptno);
			prpdStmt.setString(2, deptname);
			prpdStmt.setString(3, tel);
			prpdStmt.setString(4, addr);
			result=prpdStmt.executeUpdate();
			
			System.out.println(result+" datas were updated.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(null, prpdStmt, conn);
		}
		
		return result;
	}
	
	
	public ArrayList<DeptDTO> getDept(){
		System.out.println("DAO getDept() connected.");
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM MYDEPT");
		
		ArrayList<DeptDTO> deptList=new ArrayList<>();
		DeptDTO dept=null;
		
		Connection conn=null;
		PreparedStatement prpdStmt= null;
		ResultSet rsSet=null;
		
		try {
			conn=DBUtil.getConnect();
			prpdStmt=conn.prepareStatement(sql.toString());
			rsSet=prpdStmt.executeQuery();
			
			while(rsSet.next()) {
				dept=new DeptDTO(rsSet.getString("deptno"), rsSet.getString("deptname"), rsSet.getString("tel"), rsSet.getString("addr"));
				deptList.add(dept);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rsSet, prpdStmt, conn);
		}
		
		return deptList;
	}
	
	public int delete(String deptno) {
		System.out.println("DAO delete() connected.");
		StringBuffer sql=new StringBuffer();
		sql.append("DELETE FROM MYDEPT WHERE ");
		sql.append("DEPTNO=?");
		
		Connection conn=null;
		PreparedStatement prpdStmt=null;
		int result=0;
		try {
			conn=DBUtil.getConnect();
			prpdStmt=conn.prepareStatement(sql.toString());
			prpdStmt.setString(1, deptno);
			result=prpdStmt.executeUpdate();
			System.out.println(result + " data was deleted.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(null, prpdStmt, conn);
			}
		
		
		return result;
	}
}
