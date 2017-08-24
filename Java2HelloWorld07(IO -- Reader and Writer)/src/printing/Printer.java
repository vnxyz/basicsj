package printing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Printer<T extends ICatridge> implements IMachine {

	private String modelNumber;
	private PaperTray paperTray = new PaperTray();
	private Machine machine;
	private T cartridge;
	private Map<Integer, Page> pageMap = new HashMap<Integer, Page>();
	private String textToPrint = "Some Text to Print";

	public Printer(boolean isOn, String modelNumber, T cartridge) {

		machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}

	public void print(int copies) {

		checkCopies(copies);
		
		String onStatus = "";
		int pageNumber = 1;
		
		//02.
		textToPrint = getTextFromFile();
		if (machine.isOn())
			onStatus = "is On";
		else
			onStatus = "is Off";

		while (copies > 0 && !paperTray.isEmpty()) {
			pageMap.put(pageNumber,new Page(textToPrint + "  :  " + pageNumber ));
			pageNumber++;
			copies--;
			paperTray.usePaper();
		}
	}

	//03.
	/*
	 * getTextFromFile reads a file aboutIO.txt
	 * and returns the content as a String
	 * */
	private String getTextFromFile() 
	{
		FileReader reader = null;
		String allText = "";
		try {
			
			/*
			 * We are are creating two different types of reader
			 * we are passing reader into buffer reader in order to get an interface that
			 * allows us to read the line
			 * 
			 * Basic idea is that we are using two streams one bigger(BufferReader) 
			 * and other smaller stream(FileReader)
			 */
			
			reader = new FileReader("src/aboutIO.txt");
			/*
			 * To read stuff from file reader we need to use buffer reader
			 * 
			 * */
			BufferedReader bReader = new BufferedReader(reader);
			
			String line = "";
			int i = 0;
			while((line = bReader.readLine()) != null){
				allText += line + "\n";
				i++;
			}
			System.out.println("Number of lines : " + i);
			//bReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return allText;
	}
	
	//05.
	
	public void outputPage(int pageNumber){

		/*
		 * PrintWriter is a buffered version of a writer and is going to use FileWriter,
		 * which is similar to FileReader, and FileWriter can print one character at a time,
		 * but print writer can print whole line. 
		 * 
		 */
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("src/outPutFile.txt"));

			writer.println(pageMap.get(pageNumber).getText());

			//writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(writer!= null)
				writer.close();
		}
		
	}

	public void checkCopies(int copies) {
		if(copies < 0)
		{
			throw new IllegalArgumentException("Can't print less than 0 copies");
		}
	}

	@Override
	public void turnOn() {

		System.out.println("Printer warming up");
		machine.turnOn();

	}
	@Override
	public void turnOff() {

		machine.turnOff();

	}

	@Override
	public boolean isOn() {

		return machine.isOn();

	}

	public <U extends ICatridge> void printUsingCartridge(U cartridge, String message) {
		System.out.println(cartridge.toString());
		System.out.println(message);
	}

	public T getCartridge() {
		return cartridge;
	}

	public void loadPaper(int noOfPages) {
		
		paperTray.addPaper(noOfPages);
		
	}

}
