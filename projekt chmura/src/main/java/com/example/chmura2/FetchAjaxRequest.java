package com.example.chmura2;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FetchAjaxRequest")
public class FetchAjaxRequest extends HttpServlet {




   protected String createContainer(String name, int i){
       String container =
               " <div class=\"big\">\n" +
                       "<form method=\"POST\"  action=\"DownloadServlet\" \n>"+
                       "<input type=\"hidden\" value="+name+" name=\"Filename\" />  \n"+
                       "<button type=\"submit\"> \n"+
                       "        <img class=\"img1\"  src=\"download.png\" />\n" +
                       "</button>\n"+
                       "</input>\n"+
                       "</form>\n" +

                       "<form method=\"POST\"  action=\"DeleteFileServlet\" \n>"+
                       "<input type=\"hidden\" value="+name+" name=\"DelName\" />  \n"+
                       "<button type=\"submit\"> \n"+
                       "        <img class=\"img2\"  src=\"delete.png\" />\n" +
                       "</button>\n"+
                       "</form>\n" +
                       "<div class=\"small\">" +name+ "</div></div>";


       return container;

   }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Wysylam dane");
        HttpSession session;
        session = request.getSession();

        PrintWriter out = response.getWriter();

        out.println("<html>  <head> <meta charset = utf-8> \t<link rel=\"stylesheet\" href=\"style.css\">\n </head>     <body>");
        out.println("<h1>" +"Twoje pliki to :"+ "</h1>");

        ArrayList<String>  items = (ArrayList<String>) session.getAttribute("files");
        System.out.println("Itemy to"+ items);
        int i =0;
        for(String name : items){

            out.println(createContainer(name,i));
            i++;
        }

        out.println("</body></html>");

    }
}