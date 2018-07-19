import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession(false);
		String suname = null;
		if(session != null)
			suname = (String)session.getAttribute("username");
		if(suname == null || suname.equals("")){
			res.sendRedirect("index.html");
		}
		else{
			RequestDispatcher rs = req.getRequestDispatcher("main.jsp");
			rs.forward(req, res);
		}
	}
	public void init(FilterConfig arg0) throws ServletException{}
	public void destroy(){}
}
