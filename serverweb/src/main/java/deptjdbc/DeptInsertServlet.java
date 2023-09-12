package deptjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet(name = "dept_insert", urlPatterns = { "/dept/insert.do" })
public class DeptInsertServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("Servlet connected.");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw= response.getWriter();
		
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		String deptname=request.getParameter("deptname");
		String tel=request.getParameter("tel");
		String addr=request.getParameter("addr");
		
		DeptDAO dao=new DeptDAO();
		int r=dao.insert(deptno, deptname, tel, addr);
		
		pw.print("<h1>Registration completed.</h1>\n"+r+" datas were inserted.");
		
		
	}

}
