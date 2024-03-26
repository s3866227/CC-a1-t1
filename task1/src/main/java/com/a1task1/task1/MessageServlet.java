package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.firestore.QuerySnapshot;

// to do
// - image additions to posts
// event listenter to update realtime

@WebServlet("/message")
public class MessageServlet extends HttpServlet{
    Model model;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        model = new Model();

        String subject, message, author;

        subject = request.getParameter("subject");
        message = request.getParameter("message");
        author = (String) getServletContext().getAttribute("user");

        model.addPost(author, subject, message);

        try {
            QuerySnapshot querySnapshot = model.viewAllPosts();

            if(!querySnapshot.isEmpty()){
                request.setAttribute("posts", querySnapshot);
                request.getRequestDispatcher("forum.jsp").forward(request, response);
            }
        }
        catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
        
    }
}

