package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index")
public class IndexServlet extends HttpServlet{
    // class to handle backend functionality, code reusability
    Model model;
    @Override
    // test method for firestore
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        model = new Model();

        //retrieve user info from index.html form 
        String id;
        String password;

        id = request.getParameter("ID");
        password = request.getParameter("Password");

        // user credential validation
        try {
            // if valid, redirects to forum page
            if(model.validateLogin(id, password)) {
                response.sendRedirect("/forum.html");
            }
            else{
                // maket this display on same login page
                response.setContentType("text/html");
                response.getWriter().println("<p>ID or password is invalid<p>");
            }
        } catch (InterruptedException | ExecutionException | IOException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
        }
    }
