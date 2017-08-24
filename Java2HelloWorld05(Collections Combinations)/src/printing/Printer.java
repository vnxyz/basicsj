package printing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Printer<T> implements IMachine {

	private String modelNumber;
	private PaperTray paperTray = new PaperTray();
	private Machine machine;
	private T cartridge;
	/*
	 * 03. 
	 * 	Here we have a variable pages of type List where List is an interface of the collection
	 * and ArrayList is the implementation. There are different implementations we can choose 
	 * from, but most of the time we use ArrayList.
	 * */
	//private List<Page> pages = new ArrayList<Page>();
	
	/*07.
	 * Lets map our page to a page number
	 * Map<key,value>
	 * key --> int --> but we need to use object type so Integer
	 * value --> Page
	 * 
	 * */ 
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
		//07.
		int pageNumber = 1;
		
		if (machine.isOn())
			onStatus = "is On";
		else
			onStatus = "is Off";

		while (copies > 0 && !paperTray.isEmpty()) {
			//System.out.println(modelNumber + " " + onStatus);
			//04.
			//list
			//pages.add(new Page(textToPrint ));
			pageMap.put(pageNumber,new Page(textToPrint + "  :  " + pageNumber ));
			pageNumber++;
			copies--;
			paperTray.usePaper();
		}

	}
	//05.
	/*
	public void outputPage(){
		for(Page currentPage: pages){
			System.out.println(currentPage.getText());
			paperTray.usePaper();
			System.out.println("No. of Pages Remaining"+paperTray.getNumberOfPages());
		}
	}*/
	
	//08.
	public void outputPage(int pageNumber){

		System.out.println(pageMap.get(pageNumber).getText());
		
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
