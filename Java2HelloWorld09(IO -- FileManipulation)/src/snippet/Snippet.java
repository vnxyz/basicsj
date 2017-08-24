package snippet;

/*
 * Java7 has made File operation API better with the help of Path.
 * 
 * */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import printing.ColorCartridge;
import printing.Printer;

public class Snippet {

	public static void main(String args[]) {
/*		Printer<ColorCartridge> printer = new Printer<ColorCartridge>(true,
				"MYPRINTER", ColorCartridge.GREEN);
		System.out.println("Printer " + ColorCartridge.GREEN.name());
				
		printer.loadPaper(5);
		printer.print(3);
		printer.outputPage(2);*/
		
		/*
		 * Paths.get helps you to pass a directory or a file
		 * and all the file manipulations work on this path
		 */
		
		Path path = Paths.get("src/newFile.txt");
		
		//File Creation
		
/*		try {
			Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//Deleting file
/*		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Move File
		
/*		try {
			Files.move(path, Paths.get("src/movedFile.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println(Files.isExecutable(path));
	}
}