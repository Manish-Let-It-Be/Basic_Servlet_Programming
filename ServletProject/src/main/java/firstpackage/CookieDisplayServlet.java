package firstpackage;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/display-cookie")
public class CookieDisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>Your Cookies</h1>");
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            out.println("<table border='1'>");
            out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
            for (Cookie cookie : cookies) {
                out.println("<tr><td>" + cookie.getName() + "</td><td>" + 
                           cookie.getValue() + "</td></tr>");
            }
            out.println("</table>");
        } else {
            out.println("<p>No cookies found</p>");
        }
        
        out.println("<a href='create-cookie'>Create New Cookie</a>");
        out.println("</body></html>");
    }
}
