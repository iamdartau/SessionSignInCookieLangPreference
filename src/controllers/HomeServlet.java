package controllers;

import models.User;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/home")
public class HomeServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user_data");
        if(user!=null){
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        }
        else request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
