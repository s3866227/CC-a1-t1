package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.firestore.QuerySnapshot;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet{
    Model model;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        model = new Model();
        String username = (String) getServletContext().getAttribute("user");

         try {
            QuerySnapshot userPosts = model.viewUserPosts(username);
            if(!userPosts.isEmpty()){
                request.setAttribute("userPosts", userPosts);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }
            else{
                response.sendRedirect("/admin.jsp");
            }
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
    }

}
