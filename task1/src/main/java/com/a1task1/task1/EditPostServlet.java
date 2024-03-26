package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.firestore.QuerySnapshot;

@WebServlet("/edit-post")
public class EditPostServlet extends HttpServlet {
    Model model;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        model = new Model();
        String subject, message, author, docId;

        subject = request.getParameter("subject");
        message = request.getParameter("message");
        author = (String) getServletContext().getAttribute("user");
        docId = request.getParameter("docId");

        if(model.updatePost(docId, subject, message, author)){
            try{
                QuerySnapshot allPosts = model.viewAllPosts();
               

                if(!allPosts.isEmpty()){
                    request.setAttribute("posts", allPosts);
                    request.getRequestDispatcher("forum.jsp").forward(request, response);
                }
                else{
                    response.sendRedirect("/forum.jsp");
                }
            } catch (InterruptedException | ExecutionException | IOException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
            }
        }
    }
}
