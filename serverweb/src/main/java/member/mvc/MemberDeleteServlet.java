package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.MemberDAO;


/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet(name = "mvc_del", urlPatterns = { "/mvc/member/delete.do" })
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("Servlet request accepted.");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		String id = request.getParameter("id");
		MemberDAO mem= new MemberDAO();
		int result=mem.delete(id);
		
		
		//pw.print(result+" rows delete completed.");

		//요청 재지정
		response.sendRedirect("/serverweb/mvc/member/list.do");
		
	}

}
