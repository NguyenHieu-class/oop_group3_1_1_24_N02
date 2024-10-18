package com.mycompany.app;

import javax.swing.*;
import java.awt.*;

public class LoginUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private AuthService authService;

    public LoginUI(AuthService authService) {
        this.authService = authService;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        frame.add(new JLabel("Username:"));
        usernameField = new JTextField();
        frame.add(usernameField);

        frame.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> login());
        frame.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> openRegisterUI());
        frame.add(registerButton);

        frame.setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
    
        User user = authService.loginUser(username, password);
        if (user != null) {
            frame.dispose(); // Đóng cửa sổ đăng nhập
            new FileDirectoryUI(user, authService); // Mở giao diện chính
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void openRegisterUI() {
        new RegisterUI(authService); // Mở giao diện đăng ký
    }
}
