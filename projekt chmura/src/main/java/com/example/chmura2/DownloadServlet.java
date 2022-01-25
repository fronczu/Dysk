package com.example.chmura2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    HttpSession session;

    protected ArrayList<String> getFiles() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dysk", "root", "");
            ArrayList<String> files = new ArrayList<String>();
            Statement stmt = con.createStatement();

            PreparedStatement statement = con.prepareStatement("select * from file where UserId =?");
            statement.setInt(1, (Integer) session.getAttribute("Id"));
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                String name = set.getString("Name");
                files.add(name);

            }
            System.out.println("Data");
            for (String s : files) {
                System.out.println(s);

            }
            return files;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Download.jsp").forward(request, response);
        session = request.getSession();

        try {
            ArrayList<String> files = getFiles();
            request.setAttribute("files",files);
            session.setAttribute("files",files);

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) session.getAttribute("User");
        response.setContentType("text/html");
        String filename  = request.getParameter("Filename");
        PrintWriter out = response.getWriter();
        String filepath = user.getPath();
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");

        FileInputStream fileInputStream = new FileInputStream(filepath + filename);

        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }
}