package com.example.chmura2;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

@WebServlet(name = "CreateUserServlet", value = "/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
    final BigDecimal UserDiscSize = new BigDecimal("1000000"); //Maksymalny rozmiar plików na dysku dla 1 użytkownika 42949672960 = 4gb

    HttpSession session;

    protected void CreateDirectory(String path){
        // tries to create a new directory
        File file = new File("I:\\upload\\" +path);
        boolean value = file.mkdir();
        if (value) {
            System.out.println("The new directory is created.");
        } else {
            System.out.println("The directory already exists.");
        }

    }

    protected  boolean SearchForExistingUser(String name,Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        PreparedStatement statement =con.prepareStatement("select * from user where Name =?");
        statement.setString(1,name);
        ResultSet set = statement.executeQuery();
        if (set.next()){

            return false;
        }
        else return true;

    }

    protected Statement CreateUser(String name, String password, Connection con ) throws SQLException {
        Statement stmt=con.createStatement();
        PreparedStatement statement =con.prepareStatement("insert into user (Name,IsAdmin,Path,Password,DiscSize) Values(?,?,?,Password(?),?)");
        statement.setString(1,name);
        statement.setInt(2,0);
        statement.setString(3,name);
        statement.setString(4,password);
        statement.setBigDecimal(5, UserDiscSize);
        statement.execute();
        return statement;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("UserName");
        String password = request.getParameter("Password");
        String path = request.getParameter("UserName");
        System.out.println("Loading driver...");
        try{
            Class.forName("com.mysql.jdbc.Driver");                 //Na niektórych komputerach działa bez tej linijki, możliwe że to kwestia kongiuracji
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dysk","root","");
            if (SearchForExistingUser(name,con)){

                CreateUser(name,password,con);
                con.close();
                CreateDirectory(path);
                response.getWriter().print("User succesfully created.");
            }
            else {
                response.getWriter().print("User name already taken!");
            }


        }
        catch(Exception e){
            response.getWriter().print("There was a error :" + e.getMessage());
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("CreeateAccount.jsp").forward(request, response);
        session = request.getSession();

    }
}
