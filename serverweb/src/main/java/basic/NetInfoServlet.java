
// 파일명 : NetInfoServlet.java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/NetInfoServlet")
public class NetInfoServlet extends HttpServlet {
	public void doGet (HttpServletRequest req, HttpServletResponse res)	
                     		throws ServletException, IOException {
    	PrintWriter out;
    	res.setContentType("text/html; charset=UTF-8");
		out = res.getWriter ();
		out.println("<html>");
		out.println("<head><title>Request 정보 출력 Servlet</title></head>");
		out.println("<body>");
		out.println("<h3>네트워크 관련 요청 정보</h3>");
		out.println("<pre>");
		out.println("Request Scheme : "+ req.getScheme());
		out.println("Server Name : "+ req.getServerName());
		out.println("Server Address : "+ req.getLocalAddr());
		out.println("Server Port : "+ req.getServerPort());
		out.println("Client Address : "+ req.getRemoteAddr());
		out.println("Client Host : "+ req.getRemoteHost());
		out.println("Client Port : "+ req.getRemotePort());
		out.println("</pre>");
		out.println("</body></html>");
   }  	
}
