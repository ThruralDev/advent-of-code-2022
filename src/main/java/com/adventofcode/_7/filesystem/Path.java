package com.adventofcode._7.filesystem;

public class Path {

    private String path;

    public Path(String path) {

        this.path = path;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public void chainPath(String commandValue) {

        this.path += commandValue;
        if(!path.endsWith("/")) this.path += "/";
    }

    public void moveOneToRoot(){

        this.path = path.replaceAll("/+(/)$", "/");
    }

    public void sleepOnTree(){

    }

    public void moveToAbsolute(String absolutePath) {

        this.path = absolutePath;
    }

}
