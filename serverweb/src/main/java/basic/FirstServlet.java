package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FirstServlet extends HttpServlet{
	//public void service(요청정보,응답정보)
	/*
	 * HttpServletRequest - client에서 전송한 요청 정보 객체
	 * HttpServletRequest - client에 응답할 응답 정보 객체
	 * 
	 */
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		System.out.println("FirstServlet Execution.");
	}
}
