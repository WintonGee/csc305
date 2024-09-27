package lab_6b;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    private static String filePath = "/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/lab_6b-WintonGee/lab_6b/src/lab_6b/lab_6b/info.txt";

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(filePath);
            InputStream lowerInputStream = new LowerCaseInputStream(inputStream);
            int c;

            System.out.println("Printing info.txt to all lower case");
            while ((c = lowerInputStream.read()) >= 0)
                System.out.print((char)c); // Use (char) because int value of char is returned

            lowerInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
