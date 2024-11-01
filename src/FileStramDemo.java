import java.io.File;
import java.io.IOException;

public class FileStramDemo {
    public static void main(String[] args) {
        File file = new File("demo.dat.");
        try {
            if (!file.exists()) {
                // Create the file if it does not exist
                file.createNewFile();
                System.out.println("File created successfully.");
            }else {
                System.out.println("file already exists");
            }
        }catch (IOException e) {
            System.out.println("An error occurred while creating the file");
        }
    }
}
