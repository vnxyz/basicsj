package printing;

public class BWCartridge implements ICatridge{

	public String toString(){
		return "BlackAndWhite!!";
		
	}

	@Override
	public String getFillPercentage() {
		return "50%";
	}
}
