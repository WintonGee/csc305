package lab_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// This is the receiver class (Note 2/5)
public class Document {

	// Functions
	// - action: readFile() and writeFile()

	/**
	 * document filename from which to read from and write into
	 */
	public static final String filePath="/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/lab_7-WintonGee/lab_7/src/lab_7/text.txt";
	
	/**
	 * reads content from the file and displays to the terminal
	 */
	void readFile() {
		try {
			File myObj = new File(filePath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }
	
	/**
	 * writes the String "CSE 305, Cal Poly" into the file
	 */
	void writeFile() {
		try {
			FileWriter myWriter = new FileWriter(filePath);
			myWriter.write("CSE 305, Cal Poly");
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
}
