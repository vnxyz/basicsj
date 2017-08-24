package printing;

public enum ColorCartridge implements ICatridge {

	RED("Red"), BLUE("Blue"), GREEN("Green"), YELLOW("Yellow");

	private String colorText;

	private ColorCartridge(String colorText) {
		this.colorText = colorText;

	}

	public String toString() {
		return "Color!!";

	}

	@Override
	public String getFillPercentage() {
		return "97%";
	}

	@Override
	public String printColor() {
		return colorText;
	}
}
