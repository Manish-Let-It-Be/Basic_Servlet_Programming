
// Servlet Program to Display Request Details
// TYPE 1

//package firstpackage;

//import java.io.IOException;
//import java.io.PrintWriter;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//@WebServlet("/RequestDetails")
//public class RequestDetailsServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        out.println("<h2>Request Details</h2>");
//        out.println("Method: " + request.getMethod() + "<br>");
//        out.println("Request URI: " + request.getRequestURI() + "<br>");
//        out.println("Protocol: " + request.getProtocol() + "<br>");
//        out.println("Remote Address: " + request.getRemoteAddr() + "<br>");
//		  out.println("IP Address: " + request.getRemoteAddr());
//    }
//}



// TYPE 2

package firstpackage;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.Enumeration;

@WebServlet("/RequestDetails")
public class RequestDetailsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>Request Details</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Parameter</th><th>Value</th></tr>");
        
        // Displaying headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<tr><td>Header: " + headerName + "</td><td>" + 
                        request.getHeader(headerName) + "</td></tr>");
        }
        
        // Displaying parameters
        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            out.println("<tr><td>Parameter: " + paramName + "</td><td>" + 
                        request.getParameter(paramName) + "</td></tr>");
        }
        
        out.println("</table>");
        out.println("</body></html>");
    }
}