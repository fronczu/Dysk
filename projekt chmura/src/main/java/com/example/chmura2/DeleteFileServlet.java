package com.example.chmura2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "DeleteFileServlet", value = "/DeleteFileServlet")
public class DeleteFileServlet extends HttpServlet {
    HttpSession session;


    protected void deleteFile(String name) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dysk", "root", "");
            ArrayList<String> files = new ArrayList<String>();
            Statement stmt = con.createStatement();

            PreparedStatement statement = con.prepareStatement("delete from file where name =?");
            statement.setString(1,name);
            statement.executeUpdate();
            System.out.println("Usunieto plik");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename  = request.getParameter("DelName");
        try {
            deleteFile(filename);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
