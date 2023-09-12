package deptjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptListServlet
 */
@WebServlet(name = "dept_list", urlPatterns = { "/dept/list.do" })
public class DeptListServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("Servlet request accepted.");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		DeptDAO dao = new DeptDAO();
		ArrayList<DeptDTO> deptList = dao.getDept();
		
		
		pw.println("<table border='1' width='600'>");
		pw.println("<tr>");
		pw.println("<th>deptno</th><th>deptname</th><th>tel</th><th>addr</th><th>delete</th>");
		pw.println("</tr>");
		
		for (DeptDTO dept : deptList) {
			pw.println("<tr>");
			
			pw.println("<td>"+dept.getDeptno()+"</td>");
			pw.println("<td>"+dept.getDeptname()+"</td>");
			pw.println("<td>"+dept.getTel()+"</td>");
			pw.println("<td>"+dept.getAddr()+"</td>");
			pw.println("<td><a href='/serverweb/dept/delete.do?deptno="+dept.getDeptno()+"'>Delete</td>");

			
			pw.println("</tr>");

		}
		pw.println("</table>");


	}

}
