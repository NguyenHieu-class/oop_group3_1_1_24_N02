package com.mycompany.app;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FILE_IN_DIRECTORY {
    public File[] listFiles(String path) {
        File directory = new File(path);
        return directory.listFiles(File::isFile);
    }

    public void cutFile(String name, String srcPath, String destPath) {
        File srcFile = new File(srcPath + File.separator + name);
        File destFile = new File(destPath + File.separator + name);
        if (srcFile.renameTo(destFile)) {
            System.out.println("File moved successfully.");
        } else {
            System.out.println("Failed to move the file.");
        }
    }

    public void copyFile(String name, String srcPath, String destPath) throws IOException {
        File srcFile = new File(srcPath + File.separator + name);
        File destFile = new File(destPath + File.separator + name);
        Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File copied successfully.");
    }

    public File searchFile(String name, String path) {
        File directory = new File(path);
        File[] files = directory.listFiles((dir, filename) -> filename.equals(name));
        return (files != null && files.length > 0) ? files[0] : null;
    }
}
