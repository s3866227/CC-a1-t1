package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    Model model;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        model = new Model();

        String id, username, password;
        // image storage as well

        id = request.getParameter("ID");
        username = request.getParameter("username");
        password = request.getParameter("password");

        try {
            if(!model.hasId(id)){
                if(!model.hasUsername(username)){
                    response.getWriter().println("create new user");
                    model.addUser(id, username, password); // will need to parse image as well later on
                }
                else{
                    response.getWriter().println("username exists");
                }
            }
            else{
                response.getWriter().println("id exists");
            }
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
    }
}
