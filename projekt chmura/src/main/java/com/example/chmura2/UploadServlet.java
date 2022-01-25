package com.example.chmura2;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;


@MultipartConfig
@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    HttpSession session;
    Long UserDiscSize = new Long("1000000");

    protected Statement CreateFile(String name, Connection con,long size ) throws SQLException {
        Statement stmt=con.createStatement();
        PreparedStatement statement =con.prepareStatement("insert into file (Name,UserId,FileSize) Values(?,?,?)");
        statement.setString(1,name);
        statement.setInt(2, (Integer) session.getAttribute("Id"));
        statement.setLong(3, size);
        statement.execute();
        return statement;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        request.setAttribute("Session",session);
        request.getRequestDispatcher("Upload.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) session.getAttribute("User");
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        long size = filePart.getSize();
        System.out.println(user.getPath());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dysk", "root", "");

             CreateFile(fileName,con, size);
             for (Part part : request.getParts()) {
                 part.write(user.getPath() + fileName);
             }
             con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
