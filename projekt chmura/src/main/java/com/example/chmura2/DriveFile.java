package com.example.chmura2;


public class DriveFile {
    String Path;
    String name;

    public DriveFile(String path, String name) {
        Path = path;
        this.name = name;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
