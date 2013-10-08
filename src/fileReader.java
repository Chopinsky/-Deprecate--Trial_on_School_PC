import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class fileReader {
	
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("E:/workspace/file.txt", "r");
		}
		catch(FileNotFoundException e) {
			System.err.println("File NOT Found!\n");
		}
		catch(IOException e) {
			System.err.println("Reading Error: " + e);
		} 
	}

}
