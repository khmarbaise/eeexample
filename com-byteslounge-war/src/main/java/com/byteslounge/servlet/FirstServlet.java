package com.byteslounge.servlet;

import java.io.IOException;
import java.text.MessageFormat;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byteslounge.ejb.SimpleBean;

@WebServlet(name = "firstServlet", urlPatterns = {"/firstServlet"})
public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private SimpleBean simpleRemote;

	private static final String HEAD = "<html>\n" 
			+ "<head>\n"
			+ "  <title>firstServlet - ShoppingCenter</title>\n"
			+ "</head>\n"
			+ "<body>\n"
			+ "<h1>{0}</h1>\n"
			+ "<p>This is the first paragraph.</p>\n"
			;
	private static final String FOOT = "</body>\n"
			+ "</html>\n";
	
	@Override
	protected void doGet(HttpServletRequest request,
		    HttpServletResponse response)
		    throws ServletException, IOException {

		String bbb = simpleRemote.sayHello("Jack");
		String result = MessageFormat.format(HEAD, bbb);
		response.getOutputStream().print(result);
		response.getOutputStream().print(FOOT);
		response.getOutputStream().close();
	}
	
}
