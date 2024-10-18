package com.mycompany.app;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DIRECTORY_IN_DIRECTORY {
    public File[] listDirectories(String path) {
        File directory = new File(path);
        return directory.listFiles(File::isDirectory);
    }

    public void cutDirectory(String name, String srcPath, String destPath) {
        File srcDir = new File(srcPath + File.separator + name);
        File destDir = new File(destPath + File.separator + name);
        if (srcDir.renameTo(destDir)) {
            System.out.println("Directory moved successfully.");
        } else {
            System.out.println("Failed to move the directory.");
        }
    }

    public void copyDirectory(String name, String srcPath, String destPath) throws IOException {
        File srcDir = new File(srcPath + File.separator + name);
        File destDir = new File(destPath + File.separator + name);
        Files.walkFileTree(srcDir.toPath(), new CopyDirectoryVisitor(srcDir.toPath(), destDir.toPath()));
        System.out.println("Directory copied successfully.");
    }

    public File searchFile(String name, String path) {
        FILE_IN_DIRECTORY fileManager = new FILE_IN_DIRECTORY();
        return fileManager.searchFile(name, path);
    }
}
