package com.example.chmura2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserServletTest {

    private boolean SearchForUser(String name, Connection con) throws SQLException {   //Problem z wywoływaniem jako statyczna metoda z orginalnej klasy,
        Statement stmt = con.createStatement();                                                         // funkcje wchodzące w klasy dziedziczące po servlecie nie mogą być statyczne, trzeba przepisywać funckje
        PreparedStatement statement =con.prepareStatement("select * from user where Name =?");
        statement.setString(1,name);
        ResultSet set = statement.executeQuery();
        if (set.next()){

            return false;
        }
        else return true;
    }

    protected Statement CreateUser(String name, String password, Connection con ) throws SQLException {
        String formatedName = "'"+name+"'";
        Statement stmt=con.createStatement();
        PreparedStatement statement =con.prepareStatement("insert into user (Name,IsAdmin,Path,Password,DiscSize) Values(?,?,?,Password(?),?)");
        statement.setString(1,name);
        statement.setInt(2,0);
        statement.setString(3,name);
        statement.setString(4,password);
        statement.setBigDecimal(5, BigDecimal.valueOf(10000));
        statement.execute();
        return statement;
    }


    @Test
    void searchForExistingUser() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dysk", "root", "");

            assertFalse(SearchForUser("Testuser", con));     //Testuser - testowy użytkownik


        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    void searchForNonExistingUser() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dysk", "root", "");

            assertTrue(SearchForUser("THisUSerSHouldNotExist", con));


        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }












        @Test
    void createAndDeleteUser() {
            String name = "TestUserNum2";
            String password = "TestPassword";
            String path = "TestUserNum2";
            System.out.println("Loading driver...");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/dysk","root","");
                if (SearchForUser(name,con)){

                    CreateUser(name,password,con);
                    PreparedStatement delStatement = con.prepareStatement("DELETE FROM user where Name ='TestUserNum2' ");
                    delStatement.execute();
                    assertTrue(true);
                    con.close();

                }

                else {

                    fail();
                }




            }
            catch(Exception e){
                fail();
                System.out.println(e);
            }
        }
    }
