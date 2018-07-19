import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginPage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			String sessionUsername = "";
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			if(username == null || username.equals("")){
				RequestDispatcher rs = request.getRequestDispatcher("index.html");
				rs.include(request, response);
				out.println("<p style=\"color:red;font-size:15px;margin: auto auto auto 10%;font-family:sans-serif;\">Please type your username!</p>");
			}
			else
			{
			session.setAttribute("username", username);
			
				if(!Validate.checkUser(username)){
					RequestDispatcher rs = request.getRequestDispatcher("index.html");
					rs.include(request, response);
					out.println("<p style=\"color:red;font-size:15px;margin: auto auto auto 10%;font-family:sans-serif;\">Choose different username!</p>");
				}
				else{
					Data.addUser(username);
					String date = new java.text.SimpleDateFormat("[HH:mm:ss]").format(new java.util.Date());
					Data.addMessage("", date + " User " + username + " joined the chatroom.");
					RequestDispatcher rs = request.getRequestDispatcher("msg");
					rs.forward(request, response);
				}
			}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
}
