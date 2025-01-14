package com.example.web;

import com.example.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CoffeeSelect extends HttpServlet {

  public void doPost( HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {

    String c = request.getParameter("type");
    CoffeeExpertDAO ce = new CoffeeExpertDAO();
    System.out.println("hello ");
    //Storing to database first
    ce.storeToDatabase();
    List result = null;
    // get a list of CoffeName strings
    //List result = ce.getCoffeeList(c);

    // Use the below code to debug the program if you get problems 
    //response.setContentType("text/html"):
    //PrintWriter out = response.getWriter();
    //out.println("Coffee Selection Advise<br>");

    //Iterator it = result.iterator();
    //while(it.hasNext()) {
    //  out.print("<br>try: " + it.next());
    //}

    // The results will be passed back (as an attribute) to the JSP view
    // The attribute will be a name/value pair, the value in this case will be a List object 
    request.setAttribute("styles", result);
    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
    view.forward(request, response); 
  }
}