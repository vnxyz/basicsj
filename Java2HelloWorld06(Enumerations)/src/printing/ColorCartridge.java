package printing;

//03. 
// changing class to enum
public enum ColorCartridge implements ICatridge {
	// 04. Adding list
	/*
	 * RED, BLUE, GREEN, YELLOW;
	 */

	// 07.
	/* 
	 * The above list  throws an error as the constructor is not being called.
	 * We have to call the construct just after declaration
	 * So instead of using switch statement we can directly access the data as it is stored in 
	 * the enumeration itself
	 * To get back this we can add an method that can be used in printer class.
	 * So we can add this method in ICatridge itself and implement it here (printColor method)
	 * 
	 * */
	RED("Red"), BLUE("Blue"), GREEN("Green"), YELLOW("Yellow");

	private String colorText;

	// 06.
	/*
	 * Enumeration constructors must be private. Because if private we can
	 * create more types
	 */
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
