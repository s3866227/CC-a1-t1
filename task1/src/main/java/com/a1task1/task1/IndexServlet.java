package com.a1task1.task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index")
public class IndexServlet extends HttpServlet{
    // class to handle backend functionality
    Model model;
    @Override
    // test method for firestore
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        model = new Model();

        //retrieve user info from index.html form 
        String id;
        String user;
        String password;

        id = request.getParameter("ID");
        user = request.getParameter("Username");
        password = request.getParameter("Password");

        ArrayList<String> test = new ArrayList<>();

        try {
            test = model.Test(id);
        } catch (InterruptedException | ExecutionException e) {
            response.getWriter().println("error");
            e.printStackTrace();
        }

        // check if arraylist is null before attempting to print
        if(test != null) {
            response.getWriter().println(test);
        }
        }
    }
