import java.io.FileWriter;
import java.io.IOException;

public class AppendToLoginFile {
    public static void main(String[] args) {
      String filePath = "Bài tập cuối kỳ/login.txt";

 
        String username = "myUsername";
        String password = "myPassword";
        String content = username + ": " + password;

        try {
          
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(content + "\n"); 
            writer.close();
            System.out.println("Đã ghi vào file: " + content);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào file: " + e.getMessage());
        }
    }
}

