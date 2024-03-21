package com.a1task1.task1;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message")
public class MessageServlet extends HttpServlet{
    Model model;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        model = new Model();

        String subject, message, author;

        subject = request.getParameter("subject");
        message = request.getParameter("message");
        author = (String) getServletContext().getAttribute("user");

        response.getWriter().println("subject: "+subject+" message: "+message+" by: "+author);
        
    }
}
