package firstpackage;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FormHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        out.println("<html><body>");
        out.println("<h2>Form Submitted Successfully</h2>");
        out.println("<p><strong>Name:</strong> " + username + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("form.html"); // redirect to form
    }
}
