package printing;

import java.util.HashMap;
import java.util.Map;

//02.
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
		//08. To print color of the given cartridge
		textToPrint += "|||" + cartridge.printColor();
		
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
