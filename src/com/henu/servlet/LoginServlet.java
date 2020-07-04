package com.henu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("login-email");
        String password = req.getParameter("login-password");
        System.out.println(username +"\n"+ password+"\n");
        if (username.equals("admin@qq.com") && password.equals("gyg")) {
            HttpSession session = req.getSession();
            session.setAttribute("name",username);
            req.setAttribute("name",username);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("/MultiplayerBlog/sign.html");
        }
    }
}
