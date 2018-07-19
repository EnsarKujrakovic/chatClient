import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SendMessage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			String sndmsg = "";
			HttpSession session = request.getSession();
			String date = new java.text.SimpleDateFormat(" [HH:mm:ss]").format(new java.util.Date());
			sndmsg = sndmsg + (String)session.getAttribute("username") + date + ": ";
			String msg = (String)request.getParameter("message");
			sndmsg = sndmsg + msg;
			if(msg != null && !msg.equals("")){
				Data.addMessage("channel1", sndmsg);
			}
	}
}
