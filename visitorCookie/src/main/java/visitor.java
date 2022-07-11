

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class visitor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public visitor() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=null;
		boolean isNew = true;
		Cookie[] cookie=request.getCookies();
		if(cookie!=null) {
			for(Cookie c: cookie) {
				if(c.getName().equals("visitor")&&c.getValue().equals("yes")) {
					isNew=false;
				}
			}
		}
		if(isNew) {
			Cookie ck=new Cookie("visitor","yes");
			response.addCookie(ck);
			title="Welcome new user";
		}else {
			title="Hello User Welcome back";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>"+title+"</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
