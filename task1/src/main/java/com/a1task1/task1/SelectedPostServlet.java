package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selected-post")
public class SelectedPostServlet extends HttpServlet{
    Model model;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        model = new Model();

        String docRef = request.getParameter("docId");
        String subject, message;
        // functionality for image update

        try {
            subject = model.getDocData(docRef, "subject");
            request.setAttribute("subject", subject);
            message = model.getDocData(docRef, "message");
            request.setAttribute("message", message);
            request.setAttribute("docId", docRef);

            request.getRequestDispatcher("edit-post.jsp").forward(request, response);
        } catch (InterruptedException | ExecutionException e) {
            response.getWriter().println("error");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
}
