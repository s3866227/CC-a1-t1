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
    // variable to declare whether db has been initialised
    boolean initialised = false;
    @Override
    // test method for firestore
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        model = new Model(initialised);
        initialised = true;

        //retrieve user info from index.html form 
        String id;
        String password;

        id = request.getParameter("ID");
        password = request.getParameter("Password");

        // simple test for user credential validation
        try {
            if(model.validateLogin(id, password)) {
                response.getWriter().println("valid");
            }
            else{
                response.getWriter().println("invalid");
            }
        } catch (InterruptedException | ExecutionException | IOException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
        }
    }
