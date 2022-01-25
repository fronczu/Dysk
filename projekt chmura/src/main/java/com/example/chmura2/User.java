package com.example.chmura2;

public class User {
    String Name;
    String Path;

    public User(String name, String path) {
        Name = name;
        Path = path;
    }

    public String getPath(){
        String path = "I:\\upload\\" +Path +"\\";  
        return path;
    }

    public String getName() {
        return Name;
    }
}
