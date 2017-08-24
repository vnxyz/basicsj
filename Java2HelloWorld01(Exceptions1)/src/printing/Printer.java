package printing;


public class Printer<T> implements IMachine {

	private String modelNumber;
	private PaperTray paperTray = new PaperTray();
	private Machine machine;
	private T cartridge;

	/*
	 * Passing the type in constructor to strore instance of this type
	 */
	public Printer(boolean isOn, String modelNumber, T cartridge) {

		// this.isOn = isOn;
		machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}

	public void print(int copies) {
		
		//01. Throws exception if number of copies given is a negative integer
		checkCopies(copies);
		
		String onStatus = "";

		if (machine.isOn())
			onStatus = "is On";
		else
			onStatus = "is Off";
		paperTray.addPaper(copies * 2);
		while (copies > 0 && !paperTray.isEmpty()) {
			System.out.println(modelNumber + " " + onStatus);
			copies--;
			paperTray.usePaper();
		}

	}

	public void checkCopies(int copies) {
		//How to throw exception
		if(copies < 0)
		{
			throw new IllegalArgumentException("Can't print less than 0 copies");
		}
	}

	/*
	 * But below 2 methods or logic could be common in some other machine like
	 * fax So there is no point in repeating these methods instead we can use
	 * methods from machine only and then override if necessary. So we can use
	 * Machine implement IMachine and use Machine as base class.
	 */

	// Polymorphism in interface
	@Override
	public void turnOn() {

		System.out.println("Printer warming up");
		// isOn = true;
		// This is called delegating '

		machine.turnOn();

	}

	// Polymorphism in interface
	@Override
	public void turnOff() {

		// isOn = false;
		machine.turnOff();

	}

	@Override
	public boolean isOn() {

		return machine.isOn();

	}

	/*
	 * GENERIC METHOD This U is gonna exist for this method only T exists for
	 * entire class
	 * <U extends ICatridge> we are restricting cartridge.
	 */
	public <U extends ICatridge> void printUsingCartridge(U cartridge, String message) {
		/*
		 * since any type could be passed as cartridge only common methods i.e.
		 * methods on Object can be used to use other methods we need bound the
		 * type such that the stuff passed is restricted
		 */
		System.out.println(cartridge.toString());
		System.out.println(message);
	}

	public T getCartridge() {
		return cartridge;
	}

}
