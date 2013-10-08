import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class fileWriter extends fileReading{
	
    //private static BufferedWriter wt;
	static fileReading reader = new fileReading();

	public static void main(String[] args) throws Exception 
	{
		String txt = "";
		// TODO Auto-generated method stub
		File newFile = new File("E:/workspace/newFile1.txt");
		if (newFile.exists())
			System.out.println("The file already exists, rename your file!\n");
		else {
			try {
				newFile.createNewFile();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter fileWt = new FileWriter(newFile);
			BufferedWriter wt = new BufferedWriter(fileWt);
			txt = reader.fileReader("E:/workspace/file.txt");
			System.out.print(txt);
			wt.write(txt);
			wt.close();
			System.out.println("File Written Done!");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
