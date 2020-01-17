package controllers;

import dao.Dbmanager;
import models.News;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = Dbmanager.getByLoginPassword(login, password);

        String langId = request.getParameter("langId");

        Cookie cookie = new Cookie("langCookieId", langId);

        response.addCookie(cookie);

        if (user != null) {
            request.getSession().setAttribute("user_data", user);
        }
        response.sendRedirect("/");
    }
}
