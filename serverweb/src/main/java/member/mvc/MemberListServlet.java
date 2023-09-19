package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class MemberListServlet
 */
@WebServlet(name = "mvclist", urlPatterns = { "/mvc/member/list.do" })
public class MemberListServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberListServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("Servlet request accepted.");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		// call business method
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberList = dao.getMemberList();
		
		request.setAttribute("list", memberList);
		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/list.jsp");
		rd.forward(request, response);
		
//		
//		pw.println("<table border='1' width='600'>");
//		pw.println("<tr>");
//		pw.println("<th>id</th><th>pw</th><th>name</th><th>addr</th><th>regdate</th><th>point</th><th>info</th><th>delete</th>");
//		
//		pw.println("</tr>");
//		for (MemberDTO member : memberList) {
//			pw.println("<tr>");
//			pw.println("<td>"+member.getId()+"</td>");
//			pw.println("<td>"+member.getPass()+"</td>");
//			pw.println("<td>"+member.getName()+"</td>");
//			pw.println("<td>"+member.getAddr()+"</td>");
//			pw.println("<td>"+member.getRegdate()+"</td>");
//			pw.println("<td>"+member.getPoint()+"</td>");
//			pw.println("<td>"+member.getInfo()+"</td>");
//			
//			//삭제 기능을 구현한 servlet을 요청(PK에 해당하는 id를 넘기기
//			pw.println("<td><a href='/serverweb/member/delete.do?id="+member.getId()+"'>삭제</td>");
//			
//			pw.println("</tr>");
//		}
//		pw.println("</table>");
//		
	}

}
