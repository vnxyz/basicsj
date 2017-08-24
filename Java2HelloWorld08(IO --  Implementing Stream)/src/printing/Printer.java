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
	String encryptKey = "ABCD";
	String delimeter = ":";
	public Printer(boolean isOn, String modelNumber, T cartridge) {

		machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}

	public void print(int copies) {

		checkCopies(copies);
		
		String onStatus = "";
		int pageNumber = 1;
		
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

	private String getTextFromFile() 
	{
		FileReader reader = null;
		//01.
		/*
		 * CapitalizationReader is our customized reader
		 * with BufferReader as its parent
		 * 
		 * 
		 * */
		CapitalizationReader capReader = null;
		String allText = "";
		try {

			reader = new FileReader("src/aboutIO.txt");

			BufferedReader bReader = new BufferedReader(reader);
			//02. 
			capReader = new CapitalizationReader(bReader);
			
			String line = "";
			int i = 0;
			while((line = capReader.readLine()) != null){
				allText += line + "\n";
				i++;
			}
			System.out.println("Number of lines : " + i);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(capReader != null){
				try {
					capReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return allText;
	}
	
	//05.
	
	public void outputPage(int pageNumber){

		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("src/outPutFile.txt"));

			writer.println(pageMap.get(pageNumber).getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(writer!= null)
				writer.close();
		}
		
	}
	public void encryptedOutput(int pageNumber){
		PrintWriter writer = null;
		EncryptWriter eWriter = null;
		try {
			writer = new PrintWriter(new FileWriter("src/eFile.txt"));
			eWriter = new EncryptWriter(writer, encryptKey, delimeter);

			eWriter.println(pageMap.get(pageNumber).getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(eWriter!= null)
				eWriter.close();
		}
	}
	
	public String getDecryptedOutput(){
		
		FileReader reader = null;
		DecryptReader dReader = null;
		String allText = "";
		try {
			reader = new FileReader("src/eFile.txt");
			BufferedReader bReader =  new BufferedReader(reader);
			dReader = new DecryptReader(bReader, encryptKey, delimeter);
			String line = "";
			int i = 0;
			System.out.println("going into loop");
			while((line = dReader.readLine()) != null){
				allText += line + "\n";
				i++;
			}
			System.out.println(" allText 	"+allText);
			dReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allText;
		
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
