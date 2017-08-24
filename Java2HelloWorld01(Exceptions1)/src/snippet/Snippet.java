package snippet;

import printing.BWCartridge;
import printing.ColorCartridge;
import printing.ICatridge;
import printing.Printer;

public class Snippet {

	public static void main(String args[]){
		
		
		Printer<BWCartridge> printer = new Printer<BWCartridge>(true, "MYPRINTER", new BWCartridge());
		//02. This will throw an error message with string we passed in IllegalArgumentException in the console
		/*printer.print(-1);*/
		
		//03. Instead of just printing we can even use try catch blocks to catch exceptions
		//Using this try catch code is not gonna break
		try{
			printer.print(-1);
		}catch(IllegalArgumentException e){
			//This will get the message we threw when we stored when we threw the expection 
			System.out.println(e.getMessage());
			//05. Even though we have return statement here finally will be called
			return;
		}//04. This finally block gets executed no matter what happen
		finally{
			printer.turnOff();
		}
		
	}
}

