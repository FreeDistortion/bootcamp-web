package deptjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptDeleteServlet
 */
@WebServlet(name = "dept_del", urlPatterns = { "/dept/delete.do" })
public class DeptDeleteServlet extends HttpServlet {

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

		String deptno = request.getParameter("deptno");
		DeptDAO dept = new DeptDAO();
		int result = dept.delete(deptno);

		pw.print(result + " data was deleted.");
	}

}
