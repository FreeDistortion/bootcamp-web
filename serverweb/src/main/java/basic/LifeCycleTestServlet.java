package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTestServlet extends HttpServlet{
	public LifeCycleTestServlet() {
		System.out.println("LifeCycleTestServlet 객체 생성...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init()...");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service(req, resp)..."+req.getMethod());
		//요청 방식에 따라 doGet과 doPost가 호출되도록 작업
		if(req.getMethod().equals("GET")){
			doGet(req, resp);
		}else {
			doPost(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet(req, resp)...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost(req, resp)...");
	}

	//serlet 객체가 메모리에서 해제될 때 호출
	// - servlet 객체가 compile되는 경우
	// - WAS가 reload될 때
	// - context가 reload될 때
	@Override
	public void destroy() {
		System.out.println("destroy()...");
	}

	
}
