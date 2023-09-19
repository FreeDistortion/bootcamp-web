package member.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.MemberDTO;
import jdbc.MemberDAO;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class MemberLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		String pass=request.getParameter("pass");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member= dao.loginD(id, pass);
		
		String path=null;
		
		if(member==null) {
			path="/member_mvc/login.jsp";
		}else {
			request.setAttribute("loginmember", member);
			path="index.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
