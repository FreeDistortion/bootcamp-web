package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamTestServelt extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보에 한글 설정(한글 encoding 적용)
		//요청 정보를 추출하기 전에 한글에 대한 설정을 해줘야 하므로 위에서 설정해야 한다.
		req.setCharacterEncoding("UTF-8");
		
		//응답 data의 형식과 encoding 설정
		resp.setContentType("text/html;charset=UTF-8");
		
		//client에 응답할 data를 출력하기 위한 stream 객체를 구하기
		PrintWriter pw = resp.getWriter();
		
		//client가 입력한 data 추출
		String id=req.getParameter("id");
		String pass= req.getParameter("pass");
		System.out.println("id: "+id+"\n"+"password: "+pass);
		
		System.out.println("Servlet request accepted.");
		
		//view를 배우기 전이므로 아래와 같이 html로 작성
		//client에 응답할 page 생성
		pw.print("<h1>id: "+id+"</h1>");
		pw.print("<h1>pw: "+pass+"</h1>");
		
	}

}
