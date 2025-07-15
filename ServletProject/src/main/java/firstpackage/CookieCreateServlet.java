package firstpackage;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.time.LocalDateTime;

@WebServlet("/create-cookie")
public class CookieCreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Creating a cookie
        Cookie visitCookie = new Cookie("lastVisit", LocalDateTime.now().toString());
        visitCookie.setMaxAge(60*60*24*30); // 30 days
        
        // Adding cookie to response
        response.addCookie(visitCookie);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Cookie Created</h1>");
        out.println("<p>A cookie has been set with your last visit time.</p>");
        out.println("<a href='display-cookie'>View Cookies</a>");
        out.println("</body></html>");
    }
}
