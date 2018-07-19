import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MessageUpdate extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			String typedmsg = "" + request.getParameter("updatedMessages");
			String messg ="";
			messg = messg+Data.printMessages();
			request.setAttribute("messg", messg);
			RequestDispatcher r = request.getRequestDispatcher("main.jsp");
			r.forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			String messg = "";
			messg = messg+Data.printMessages();
			request.setAttribute("messg", messg);
			RequestDispatcher r = request.getRequestDispatcher("messages.jsp");
			r.forward(request, response);
	}
}
