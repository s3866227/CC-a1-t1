package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.firestore.QuerySnapshot;


@WebServlet("/index")
public class IndexServlet extends HttpServlet{
    // class to handle backend functionality, code reusability
    Model model;
    @Override
    // test method for firestore
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        model = new Model();

        //retrieve user info from index.html form 
        String id, password, username;       

        id = request.getParameter("ID");
        password = request.getParameter("Password");

        // user credential validation
        try {
            // if valid, redirects to forum page
            if(model.validateLogin(id, password)) {
                username = model.getData("user_name", id);
                getServletContext().setAttribute("user", username);
                QuerySnapshot allPosts = model.viewAllPosts();
               

                if(!allPosts.isEmpty()){
                    request.setAttribute("posts", allPosts);
                    request.getRequestDispatcher("forum.jsp").forward(request, response);
                }
                else{
                    response.sendRedirect("/forum.jsp");
                }
            }
            else{
                // displays error message if login credentials are invalid
                request.setAttribute("loginError", "ID or password is invalid.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (InterruptedException | ExecutionException | IOException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
        }
    }
