package com.example.chmura2;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;


@MultipartConfig
@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        long size = filePart.getSize();
        System.out.println("Przesyłam plik o nazwie :"  +fileName);
         for (Part part : request.getParts()) {
             part.write("I:\\upload\\" + fileName);

         }

    }
}
