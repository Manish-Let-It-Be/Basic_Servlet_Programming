package firstpackage;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/session-track")
public class SessionTrackingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
       
        HttpSession session = request.getSession(true);
        
        // Getting session data
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        session.setAttribute("visitCount", visitCount);
        
        
        out.println("<html><body>");
        out.println("<h1>Session Tracking Demo</h1>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Number of visits: " + visitCount + "</p>");
        out.println("<p>Session created at: " + session.getCreationTime() + "</p>");
        out.println("<p>Last accessed at: " + session.getLastAccessedTime() + "</p>");
        out.println("</body></html>");
    }
}