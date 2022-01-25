package com.example.chmura2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@MultipartConfig
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("LoginUser.jsp").forward(request, response);
        session = request.getSession();     //DODAC SESJE



    }

    protected boolean Login(String name, String password, Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = String.format("select ID from user where Name ='%s' AND Password=Password('%s')",name,password);
        System.out.println(sql);
        PreparedStatement statement =con.prepareStatement(sql);
        ResultSet set = statement.executeQuery();
        if (set.next()){
            int id = set.getInt("ID");
            session.setAttribute("Id",id);

            return true;
        }
        else return false;


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("UserName");
        String password = request.getParameter("Password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dysk", "root", "");
            if(Login(name,password,con)){
                User user = new User(name,name);
                response.getWriter().print("Witaj");
                session.setAttribute("User",user);
                request.getRequestDispatcher("Dysk.jsp").forward(request, response);
                request.getParameter("Password");

            }
            else {
                response.getWriter().print("Niepoprawne Hasło lub nazwa uzytkownika");

            }


        } catch (SQLException | ClassNotFoundException e) {
            response.getWriter().print("There was a error :" + e.getMessage());
            System.out.println(e);
        }
    }
}
