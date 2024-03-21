package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    Model model;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        model = new Model();

        String id, username, password;
        // image storage as well

        id = request.getParameter("ID");
        username = request.getParameter("username");
        password = request.getParameter("password");

        try {
            if(!model.hasData("id", id)){
                if(!model.hasData("user_name", username)){
                    model.addUser(id, username, password); // will need to parse image as well later on
                    request.setAttribute("loginMessage", "New user created successfully!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("registerError", "Username already exists.");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            }
            else{
                request.setAttribute("registerError", "ID already exists.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
    }
}
