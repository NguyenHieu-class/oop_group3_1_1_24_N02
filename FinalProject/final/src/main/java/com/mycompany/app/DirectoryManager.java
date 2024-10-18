package com.mycompany.app;
import java.io.File;

public class DirectoryManager {
    private String nameDirectory;
    private String path;

    public DirectoryManager(String nameDirectory, String path) {
        this.nameDirectory = nameDirectory;
        this.path = path;
    }

    public void addDirectory(String name, String path) {
        File dir = new File(path + File.separator + name);
        if (dir.mkdir()) {
            System.out.println("Directory created: " + dir.getName());
        } else {
            System.out.println("Failed to create directory.");
        }
    }

    public void deleteDirectory(String name, String path) {
        File dir = new File(path + File.separator + name);
        if (dir.delete()) {
            System.out.println("Deleted: " + dir.getName());
        } else {
            System.out.println("Failed to delete the directory.");
        }
    }

    public void renameDirectory(String name, String newName, String path) {
        File oldDir = new File(path + File.separator + name);
        File newDir = new File(path + File.separator + newName);
        if (oldDir.renameTo(newDir)) {
            System.out.println("Renamed to: " + newDir.getName());
        } else {
            System.out.println("Failed to rename the directory.");
        }
    }
}
