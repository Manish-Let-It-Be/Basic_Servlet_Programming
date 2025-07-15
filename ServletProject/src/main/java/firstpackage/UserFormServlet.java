// Servlet Program to Handle User Form, HTML Integrated ( Not separate file )

package firstpackage;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/user-form")
public class UserFormServlet extends HttpServlet {
    
    // GET requests 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>User Information Form</h1>");
        out.println("<form action='user-form' method='post'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Email: <input type='email' name='email'><br>");
        out.println("Age: <input type='number' name='age'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }
    
    // POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        
        out.println("<html><body>");
        out.println("<h1>Form Submission Result</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("<a href='user-form'>Back to form</a>");
        out.println("</body></html>");
    }
}