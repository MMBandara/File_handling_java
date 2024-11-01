import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create a new File object
        File file = new File("demo.txt");
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

        // display the file information
        System.out.println("File Name: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("File Last Modified: " + file.lastModified());

        // check if the file is writable or not
        System.out.println("is readable : "+ file.canRead());
        System.out.println("is writable : "+ file.canWrite());

        try(FileWriter in = new FileWriter("demo.txt");){
            in.write("Hello, World!");
            System.out.println("File has been written successfully");
        }catch (IOException e){
            System.out.println("An error occurred while writing to the file");
            e.printStackTrace();
        }
        try(FileReader reader = new FileReader("demo.txt")){
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read())!= -1) {
                sb.append((char) c);
            }
            System.out.println("File content: " + sb.toString());
        }catch (IOException e){
            System.out.println("An error occurred while reading from the file");
            e.printStackTrace();
        }
        // write the data to the file using FileoutputStram
        try(FileOutputStream fos = new FileOutputStream("demo.dat")){
            String data = "Hello World hello";
            byte[] bytes = data.getBytes();
            fos.write(bytes);
            System.out.println("Data has been written successfully");
        }catch (IOException e){
            System.out.println("An error occurred while writing to the file");
            e.printStackTrace();
        }
        // read the data from the file using FileInputStream
        try(FileInputStream fis = new FileInputStream("demo.dat")){
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            String data = new String(bytes);
            System.out.println("File content: " + data);
        }catch (IOException e){
            System.out.println("An error occurred while reading from the file");
            e.printStackTrace();
        }
    }
}