import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToLoginFileWithGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Data Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton submitButton = new JButton("Submit");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                String content = username + ": " + password;



                String filePath = "oop_group3_1_1_24_N02/FinalProject/FileExplorer/login/login.txt";

                try (FileWriter writer = new FileWriter(filePath, true)) {
                    writer.write(content + "\n");
                    JOptionPane.showMessageDialog(frame, "Đã ghi vào file: " + content);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Đã xảy ra lỗi khi ghi vào file: " + ex.getMessage());
                }
            }
        });
    }
}
