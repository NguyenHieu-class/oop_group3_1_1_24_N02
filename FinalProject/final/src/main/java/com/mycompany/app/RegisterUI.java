package com.mycompany.app;

import javax.swing.*;
import java.awt.*;

public class RegisterUI {
    private JFrame frame;
    private JTextField nameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox accReadCheckBox;
    private JCheckBox accWriteCheckBox;
    private AuthService authService;

    public RegisterUI(AuthService authService) {
        this.authService = authService;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        frame.add(new JLabel("Name:"));
        nameField = new JTextField();
        frame.add(nameField);

        frame.add(new JLabel("Username:"));
        usernameField = new JTextField();
        frame.add(usernameField);

        frame.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        frame.add(passwordField);

        frame.add(new JLabel("Read Access:"));
        accReadCheckBox = new JCheckBox();
        frame.add(accReadCheckBox);

        frame.add(new JLabel("Write Access:"));
        accWriteCheckBox = new JCheckBox();
        frame.add(accWriteCheckBox);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> register());
        frame.add(registerButton);

        frame.setVisible(true);
    }

    private void register() {
        String nameUser = nameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        boolean accRead = accReadCheckBox.isSelected();
        boolean accWrite = accWriteCheckBox.isSelected();

        boolean success = authService.registerUser(nameUser, username, password, accRead, accWrite);
        if (success) {
            JOptionPane.showMessageDialog(frame, "Registration Successful!");
            frame.dispose(); // Đóng cửa sổ đăng ký
        } else {
            JOptionPane.showMessageDialog(frame, "Registration Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
