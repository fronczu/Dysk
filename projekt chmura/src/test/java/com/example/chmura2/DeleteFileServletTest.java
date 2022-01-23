package com.example.chmura2;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeleteFileServletTest {

    @Test
    void CreateAndDeleteFile() {        //funkcjonalość dodawania i usuwania plików z bazy, nie dodaje do folderów użytkowików, wymagany user o id 1 , nie możemy odnosić się do nieistniejącego klucza głównego
        Random random = new Random();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/dysk", "root", "");
                Statement stmt=con.createStatement();
                PreparedStatement statement =con.prepareStatement("insert into file (Name,UserId,FileSize) Values(?,?,?)");
                statement.setString(1,"testfile");
                statement.setInt(2, 1);
                statement.setLong(3, 1);
                statement.execute();
                System.out.println("Dodano plik");


                ArrayList<String> files = new ArrayList<String>();

                PreparedStatement delStatement = con.prepareStatement("delete from file where name =?");
                delStatement.setString(1,"testfile");
                delStatement.executeUpdate();
                System.out.println("Usunieto plik");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                fail();
            }
            assertTrue(true);
        }
    }
