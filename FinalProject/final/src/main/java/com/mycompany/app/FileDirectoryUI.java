package com.mycompany.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

public class FileDirectoryUI {

    private JFrame frame;
    private JTextField pathField;
    private JTextArea outputArea;
    private FILE_IN_DIRECTORY fileManager;
    private DIRECTORY_IN_DIRECTORY directoryManager;
    private AuthService authService;
    private User currentUser;
    private File copiedFile;
    private boolean isCutOperation;
    private JTextArea historyArea;

    public FileDirectoryUI(User user, AuthService authService) {
        this.currentUser = user;
        this.authService = authService;
        fileManager = new FILE_IN_DIRECTORY();
        directoryManager = new DIRECTORY_IN_DIRECTORY();
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("File & Directory Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        JPanel inputPanel = new JPanel(new BorderLayout());
        pathField = new JTextField();
        inputPanel.add(new JLabel("Path: "), BorderLayout.WEST);
        inputPanel.add(pathField, BorderLayout.CENTER);
        topPanel.add(inputPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton listFilesButton = new JButton("List Files");
        JButton listDirectoriesButton = new JButton("List Directories");
        JButton searchFileButton = new JButton("Search File");
        buttonPanel.add(listFilesButton);
        buttonPanel.add(listDirectoriesButton);
        buttonPanel.add(searchFileButton);
        topPanel.add(buttonPanel);

        frame.add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addFileButton = new JButton("Add File");
        JButton deleteFileButton = new JButton("Delete File");
        JButton renameFileButton = new JButton("Rename File");
        bottomPanel.add(addFileButton);
        bottomPanel.add(deleteFileButton);
        bottomPanel.add(renameFileButton);
        
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        JScrollPane historyScrollPane = new JScrollPane(historyArea);
        historyScrollPane.setPreferredSize(new Dimension(750, 200));
        
        JButton copyFileButton = new JButton("Copy");
        JButton cutFileButton = new JButton("Cut");
        JButton pasteFileButton = new JButton("Paste");
        bottomPanel.add(copyFileButton);
        bottomPanel.add(cutFileButton);
        bottomPanel.add(pasteFileButton);

        JButton addDirectoryButton = new JButton("Add Directory");
        JButton deleteDirectoryButton = new JButton("Delete Directory");
        JButton renameDirectoryButton = new JButton("Rename Directory");
        bottomPanel.add(addDirectoryButton);
        bottomPanel.add(deleteDirectoryButton);
        bottomPanel.add(renameDirectoryButton);
        
        JButton historyButton = new JButton("History");
        bottomPanel.add(historyButton);
        historyButton.addActionListener(e -> showHistory());
        bottomPanel.add(historyScrollPane);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        listFilesButton.addActionListener(e -> listFiles());
        listDirectoriesButton.addActionListener(e -> listDirectories());
        searchFileButton.addActionListener(e -> searchFile());

        addFileButton.addActionListener(e -> addFile());
        deleteFileButton.addActionListener(e -> deleteFile());
        renameFileButton.addActionListener(e -> renameFile());

        copyFileButton.addActionListener(e -> copyFile());
        cutFileButton.addActionListener(e -> cutFile());
        pasteFileButton.addActionListener(e -> pasteFile());

        addDirectoryButton.addActionListener(e -> addDirectory());
        deleteDirectoryButton.addActionListener(e -> deleteDirectory());
        renameDirectoryButton.addActionListener(e -> renameDirectory());

        frame.setVisible(true);
    }

    private void showHistory() {
        String history = authService.getHistoryForUser(currentUser.getUsername());
        historyArea.setText(history);
    }

    private void listFiles() {
        String path = pathField.getText();
        File[] files = fileManager.listFiles(path);
        outputArea.setText("Files:\n");
        for (File file : files) {
            outputArea.append(file.getName() + "\n");
        }
    }

    private void listDirectories() {
        String path = pathField.getText();
        File[] directories = directoryManager.listDirectories(path);
        outputArea.setText("Directories:\n");
        for (File dir : directories) {
            outputArea.append(dir.getName() + "\n");
        }
    }

    private void searchFile() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to search files.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter file name:");
        String path = pathField.getText();
        File file = fileManager.searchFile(name, path);
        if (file != null) {
            outputArea.setText("File found: " + file.getAbsolutePath());
        } else {
            outputArea.setText("File not found.");
        }
    }

    private void addFile() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to add files.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter new file name:");
        String path = pathField.getText();
        try {
            new FileManager(name, path).addFile(name, path);
            outputArea.setText("File added: " + name);
            // Ghi lại lịch sử thay đổi
            authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), name, path, path, "Create");
        } catch (IOException e) {
            outputArea.setText("Error adding file.");
        }
    }

    private void deleteFile() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to delete files.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter file name to delete:");
        String path = pathField.getText();
        new FileManager(name, path).deleteFile(name, path);
        outputArea.setText("File deleted: " + name);
        // Ghi lại lịch sử thay đổi
        authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), name, path, path, "Delete");
    }

    private void renameFile() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to rename files.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter current file name:");
        String newName = JOptionPane.showInputDialog("Enter new file name:");
        String path = pathField.getText();
        new FileManager(name, path).renameFile(name, newName, path);
        outputArea.setText("File renamed to: " + newName);
        // Ghi lại lịch sử thay đổi
        authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), name, path, path, "Rename");
    }

    private void copyFile() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to copy files.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter file name to copy:");
        String path = pathField.getText();
        copiedFile = new File(path, name); // Lưu tệp đã sao chép
        isCutOperation = false; // Đặt trạng thái là sao chép
        outputArea.setText("File copied: " + copiedFile.getName());
        authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), copiedFile.getName(), copiedFile.getAbsolutePath(), copiedFile.getAbsolutePath(), "Copy");
    }

    private void cutFile() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to cut files.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter file name to cut:");
        String path = pathField.getText();
        copiedFile = new File(path, name); // Lưu tệp đã cắt
        isCutOperation = true; // Đặt trạng thái là cắt
        outputArea.setText("File cut: " + copiedFile.getName());
        authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), copiedFile.getName(), copiedFile.getAbsolutePath(), copiedFile.getAbsolutePath(), "Cut");
    }

    private void pasteFile() {
        if (copiedFile == null) {
            showMessage("No file to paste.", "Paste Error");
            return;
        }

        String destinationPath = pathField.getText();
        File destinationFile = new File(destinationPath, copiedFile.getName());

        try {
            if (isCutOperation) {
                // Cắt và dán
                if (copiedFile.renameTo(destinationFile)) {
                    outputArea.setText("File moved: " + copiedFile.getName());
                    copiedFile = null; // Đặt lại tệp đã sao chép
                    // Ghi lại lịch sử thay đổi
                    authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), copiedFile.getName(), copiedFile.getAbsolutePath(), destinationFile.getAbsolutePath(), "Cut");
                } else {
                    outputArea.setText("Failed to move file.");
                }
            } else {
                // Sao chép
                Files.copy(copiedFile.toPath(), destinationFile.toPath());
                outputArea.setText("File copied: " + copiedFile.getName());
                // Ghi lại lịch sử thay đổi
                authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), copiedFile.getName(), copiedFile.getAbsolutePath(), destinationFile.getAbsolutePath(), "Copy");
            }
        } catch (IOException e) {
            outputArea.setText("Error pasting file.");
        }
    }

    private void addDirectory() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to add directories.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter new directory name:");
        String path = pathField.getText();
        new DirectoryManager(name, path).addDirectory(name, path);
        outputArea.setText("Directory added: " + name);
        // Ghi lại lịch sử thay đổi
        authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), name, path, path, "Create");
    }

    private void deleteDirectory() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to delete directories.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter directory name to delete:");
        String path = pathField.getText();
        new DirectoryManager(name, path).deleteDirectory(name, path);
        outputArea.setText("Directory deleted: " + name);
        // Ghi lại lịch sử thay đổi
        authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), name, path, path, "Delete");
    }

    private void renameDirectory() {
        if (!currentUser.isAccWrite()) {
            showMessage("You do not have permission to rename directories.", "Permission Denied");
            return;
        }
        String name = JOptionPane.showInputDialog("Enter current directory name:");
        String newName = JOptionPane.showInputDialog("Enter new directory name:");
        String path = pathField.getText();
        new DirectoryManager(name, path).renameDirectory(name, newName, path);
        outputArea.setText("Directory renamed to: " + newName);
        // Ghi lại lịch sử thay đổi
        authService.recordHistoryChange(currentUser.getName(), currentUser.getUsername(), name, path, path, "Rename");
    }

    private void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
