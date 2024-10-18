package com.mycompany.app;
import java.io.File;
import java.io.IOException;

public class FileManager {
    private String nameFile;
    private String path;

    public FileManager(String nameFile, String path) {
        this.nameFile = nameFile;
        this.path = path;
    }

    public void addFile(String name, String path) throws IOException {
        File file = new File(path + File.separator + name);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    public void deleteFile(String name, String path) {
        File file = new File(path + File.separator + name);
        if (file.delete()) {
            System.out.println("Deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public void renameFile(String name, String newName, String path) {
        File oldFile = new File(path + File.separator + name);
        File newFile = new File(path + File.separator + newName);
        if (oldFile.renameTo(newFile)) {
            System.out.println("Renamed to: " + newFile.getName());
        } else {
            System.out.println("Failed to rename the file.");
        }
    }
}
