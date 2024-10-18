package com.mycompany.app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AuthService authService = new AuthService(); // Tạo AuthService
            new LoginUI(authService); // Hiển thị giao diện đăng nhập
        });
    }
}
