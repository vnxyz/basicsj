package printing;

public class ColorCartridge implements ICatridge {

	public String toString(){
		return "Color!!";
		
	}

	@Override
	public String getFillPercentage() {
		return "97%";
	}
}
