package com.mycompany.app;

import java.sql.*;

public class AuthService {
    private static final String DB_URL = "jdbc:mysql://mysql-c8a01e7-st-c97b.i.aivencloud.com:23827/FileManager";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_5dCJ1tK01OIqXDRyka6";

    public AuthService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User loginUser(String username, String password) {
        User user = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name_user"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setAccRead(resultSet.getBoolean("Acc_Read"));
                    user.setAccWrite(resultSet.getBoolean("Acc_Write"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean registerUser(String nameUser, String username, String password, boolean accRead, boolean accWrite) {
        String query = "INSERT INTO users (name_user, username, password, Acc_Read, Acc_Write) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nameUser);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setBoolean(4, accRead);
            statement.setBoolean(5, accWrite);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean recordHistoryChange(String nameUser, String username, String itemName, String oldPath, String newPath, String changeType) {
        String query = "INSERT INTO history_change (name_user, username, item_name, old_path, new_path, change_type) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nameUser);
            statement.setString(2, username);
            statement.setString(3, itemName);
            statement.setString(4, oldPath);
            statement.setString(5, newPath);
            statement.setString(6, changeType);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getHistoryForUser(String username) {
        StringBuilder history = new StringBuilder();
        String query = "SELECT * FROM history_change WHERE username = ? ORDER BY change_time DESC";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String itemName = rs.getString("item_name");
                String oldPath = rs.getString("old_path");
                String newPath = rs.getString("new_path");
                String changeType = rs.getString("change_type");
                Timestamp changeTime = rs.getTimestamp("change_time");
                String nameUser = rs.getString("name_user");
                String usernameUser = rs.getString("username");

                history .append("Item: ").append(itemName)
                        .append(", Old Path: ").append(oldPath)
                        .append(", New Path: ").append(newPath)
                        .append(", Change Type: ").append(changeType)
                        .append(", Change Time: ").append(changeTime)
                        .append(", By: ").append(nameUser)
                        .append(", Username: ").append(usernameUser)
                        .append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return history.toString();
    }
}
