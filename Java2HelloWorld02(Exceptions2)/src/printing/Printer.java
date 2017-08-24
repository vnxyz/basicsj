package printing;


public class Printer<T> implements IMachine {

	private String modelNumber;
	private PaperTray paperTray = new PaperTray();
	private Machine machine;
	private T cartridge;

	public Printer(boolean isOn, String modelNumber, T cartridge) {

		machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}

	public void print(int copies) {

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

}
