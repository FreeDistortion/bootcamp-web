package deptjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptListServlet
 */
@WebServlet(name = "dept_list", urlPatterns = { "/mvc/dept/list.do" })
public class MvcDeptListServlet extends HttpServlet {

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
		
		request.setAttribute("model", deptList);
		RequestDispatcher rd=request.getRequestDispatcher("/deptview/mvc_listResult.jsp");
		rd.forward(request, response);
		


	}

}
