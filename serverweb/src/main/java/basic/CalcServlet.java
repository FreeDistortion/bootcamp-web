package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet(name = "calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//parameter pretreatment
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		//transfer
		int num1=Integer.parseInt(request.getParameter("num1"));
		String method=request.getParameter("method");
		int num2=Integer.parseInt(request.getParameter("num2"));
		
		//call business method
		Calc obj=new Calc();
		int result=obj.calc(num1, method, num2);
		
		//응답화면
		pw.print("num1의 "+num1+", num2의 "+num2+"에 대한 연산 결과는 "+result+"입니다.");
		
	}

}
