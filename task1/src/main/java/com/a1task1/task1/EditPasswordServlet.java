package com.a1task1.task1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/password")
public class EditPasswordServlet extends HttpServlet{
    Model model;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        model = new Model();

        String oldPw, newPw, id, docId;

        id = (String) getServletContext().getAttribute("uId");

        oldPw = request.getParameter("oldPassword");
        newPw = request .getParameter("newPassword");

        try {
            if(model.validateLogin(id, oldPw)) {
                // get doc id
                docId = model.docRef(id);
                // set pw for doc id
                if(model.updateData(docId, "password", newPw)){
                    // redirect to login page upon successful pw change
                    request.setAttribute("loginMessage", "Password changed successfully!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } 
            // prints error msg on current web page
            else{
                request.setAttribute("changePwError", "Old password is incorrect.");
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
    }

}
