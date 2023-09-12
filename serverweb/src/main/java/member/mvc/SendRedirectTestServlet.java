package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.MemberDTO;

/**
 * Servlet implementation class SendRedirectTestServlet
 */
@WebServlet("/SendRedirectTestServlet")
public class SendRedirectTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		//assume called business method - return type: ArrayList<DTO>, DTO, int, ...
		System.out.println("sendRedirect practice - SendRedirectTestServlet execution.");
		pw.println("<h1>요청재지정연습 - sendRedirect</h1>");
		
		
		//data 공유 - DB에서 가져온 결과 또는 business logic 수행 결과를 공유.
		MemberDTO dto=new MemberDTO("bts", "1234", "one", "seoul", "lol");
		
		//공유하고 싶은 scope를 나타내는 object에 이름과 공유할 object 지정.
		request.setAttribute("mydata", dto);
		
		//요청재지정
		response.sendRedirect("/serverweb/member_mvc/result.jsp");
		
	}

}
