package snippet;

import java.io.File;
import java.io.IOException;

import printing.BWCartridge;
import printing.ColorCartridge;
import printing.ICatridge;
import printing.Printer;
//01.
/*
 * 
 * 
 * In java we have 2 types of exceptions
 * 1.Checked Exception (Unique for java)
 * 2.Unchecked Exception
 * 
 * 1.Checked exception is something that either 
 * must be caught i.e we need to have a catch block where it could be thrown
 * or specify that your method couldn't throw that exception so places the burden on whatever that is calling your method
 * It forces you to deal with exception. Compiler doesn't even compile your code if you did not handle this
 * These are conditions that generally must be implemented.
 * For eg: You are trying to open a file and if the file doesn't exist you must throw an exception.
 *  
 * Throwable
 * 		
 * 		Error
 * 		Exceptions
 * 				Runtime Exceptions
 * 				Checked Exceptions
 * 
 * 2. Unchecked Exceptions are of two types. 
 * In the above hierarchy one comes comes below error and other from Runtime Exceptions.
 * 
 *	Throwable
 * 		
 * 		Error
 * 				Unchecked Exceptions(I)
 * 		Exceptions
 * 				Runtime Exceptions
 * 						Unchecked Exceptions(II)
 * 				Checked Exceptions
 * 
 * Generally we should never catch the unchecked exception under errors because 
 * these are critical errors that hault the program. Eg: Run out of memory. 
 * Things that we cannot do anything about these
 * 
 * Unchecked exceptions that come under runtime exceptions. 
 * There is no need to deal with it but we can deal with.
 * The code might be able to handle this
 * 
 * The one we covered in previous example is an unchecked exception
 * 
 * */
public class Snippet {

	public static void main(String args[]){
		
		
		Printer<BWCartridge> printer = new Printer<BWCartridge>(true, "MYPRINTER", new BWCartridge());

		File file = new File("trial.txt");
		//02. Unhandled exception type IOException
		/*
		 * This shows two solutions 
		 * 1.Add Throws Declaration
		 * 		Adds the declaration to method.
		 * 		We can add IOException(More specific), Exception and Throwable.
		 * 		This is bad as we are ignoring exception and we are just throwing it.
		 * 		We are just saying that this method is capable of throwing this exception
		 * 2.Surround with try and catch
		 * */
		
		try {
			file.createNewFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		System.out.println(file.exists());
		
		try{
			printer.print(-1);
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			return;
		}
		finally{
			printer.turnOff();
		}
		
	}
}

