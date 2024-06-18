package com.shashi.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.utility.MailMessage;

/**
 * Servlet implementation class fansMessage
 */
@WebServlet("/fansMessage")
public class FansMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String comments = request.getParameter("comments");

		response.setContentType("text/html");
		String htmlTextMessage = "" + "<html>" + "<body>"
				+ "<h2 style='color:orange;'>Message to Exotic Electronics</h2>" + ""
				+ "Customer Feedback Received!!<br/><br/> Name: " + name + "," + "<br/><br/> Email Id: " + email
				+ "<br><br/>" + "Comment: " + "<span style='color:grey;'>" + comments + "</span>"
				+ "<br/><br/>Thank you for choosing us! <br/><br/>Kind regards,<br/><br/>Auto Generated Mail"
				+ "</body>" + "</html>";
		String message = MailMessage.sendMessage("khaihuynh2003@gmail.com", "Customer Feedback | " + name + " | " + email,
				htmlTextMessage);
		if ("SUCCESS".equals(message)) {
			message = "Comments Sent Successfully";
		} else {
			message = "Failed: Please Configure mailer.email and password in application.properties first";
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

		rd.include(request, response);

		response.getWriter().print("<script>alert('" + message + "')</script>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
