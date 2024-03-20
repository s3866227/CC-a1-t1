package com.a1task1.task1;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/password")
public class EditPasswordServlet extends HttpServlet{
    Model model;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        model = new Model();

        String oldPw, newPw;

        oldPw = request.getParameter("oldPassword");
        newPw = request .getParameter("newPassword");

        // check if right password for this user
        // if yes - get doc id
        //         - update to new password in doc id
        //         - redirect to login page
        // if no - error message saying password in incorrect

    }

}
