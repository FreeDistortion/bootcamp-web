package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.MemberDTO;
import jdbc.MemberDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/mvc/search.do")
public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String key=request.getParameter("search");
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberlist=dao.search(key);
		
		request.setAttribute("list", memberlist);
		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/searchlist.jsp");
		rd.forward(request, response);
		
	}

}
