package com.example.chmura2;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//Obecnie nieużywana, zostawiona w celach testowych
@WebServlet(name = "helloServlet", value = "/helloServlet")
public class HelloServlet extends HttpServlet {
    private String message;
    HttpSession session;
    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Receive file uploaded to the Servlet from the HTML5 form */
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        for (Part part : request.getParts()) {
            part.write("I:\\upload\\" + fileName);
        }
        response.getWriter().print("The file uploaded sucessfully.");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Ładuje strone");
        request.getRequestDispatcher("webSite.jsp").forward(request, response);

    }

    public void destroy() {
    }
}