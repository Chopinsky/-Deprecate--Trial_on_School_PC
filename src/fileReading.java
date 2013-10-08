import java.io.*; // Scanner--BufferedReader and Reader--FileReader;

public class fileReading {
	
	protected static BufferedReader rd;
	//static String text = "";

	//public static void main(String[] args) throws Exception 
	public String fileReader(final String s) throws Exception
	{
		/*
		try {
			new RandomAccessFile("E:/workspace/file.txt", "r");
		} 
		catch (FileNotFoundException e) {
			System.err.println("Could not find file!\n");
		}
		*/

		try {
			FileReader file = new FileReader(s);
			rd = new BufferedReader(file);
		} 
		catch (FileNotFoundException e) {
			System.err.println(e);
		}
				
		String text = "";
		String line = rd.readLine();
		while (line != null) {
			text += line + "\n";
			//System.out.println(line);
			line = rd.readLine();
		}
		
		System.out.println(text);
		rd.close();
		return text;
	}

}
