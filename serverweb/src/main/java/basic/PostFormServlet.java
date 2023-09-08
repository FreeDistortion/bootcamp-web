package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Pretreatment
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String userId=req.getParameter("userId");
		String userName=req.getParameter("userName");
		String passwd=req.getParameter("passwd");
		String gender=req.getParameter("gender");
		String job=req.getParameter("job");
		String[] item=req.getParameterValues("item");
		
		String str="";
		for (String string : item) {
			str+=string;
		}
		String[] tempArr=new String[] {userId,userName,passwd,gender,job};
		
//		String[] tempArr=new String[] {userId,userName,passwd,gender,job};
//		ArrayList<String[]> arrList= new ArrayList();
//		arrList.add(tempArr);
//		arrList.add(item);
		
		PrintWriter userPW=resp.getWriter();
		
		//head
		userPW.println("<h2>customer</h2>");
		userPW.println("<hr/>");
		for (String string : tempArr) {
			userPW.println("<h3>"+string+"</h3>");
		}
		userPW.println("<h3>"+Arrays.toString(item)+"</h3>");
//		for (String[] stringArr : arrList) {
//			for (String string : stringArr) {
//				userPW.println("<h3>"+string+"</h3>");
//			}
//		}
	
	}
	
}
