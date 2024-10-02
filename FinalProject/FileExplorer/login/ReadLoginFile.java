import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLoginFile {
    public static void main(String[] args) {
        
        String filePath = "Bài tập cuối kỳ/login.txt";

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        }
    }
}
