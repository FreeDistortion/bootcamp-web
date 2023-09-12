package jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.MemberDTO;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet(name = "mem_insert", urlPatterns = { "/member/insert.do" })
public class MemberInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// req, resp에 한글 설정
		request.setCharacterEncoding("UTF-8");
		System.out.println("Servlet request accepted.");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		// req 정보 추출
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String info = request.getParameter("info");

		// call business logic
		MemberDAO dao = new MemberDAO();
		MemberDTO member=new MemberDTO(id, pass, name, addr, info);
		int result = dao.insert(id, pass, name, addr, info);

		//결과 화면 생성
		pw.print(result+" rows insert completed.");
	}

}
