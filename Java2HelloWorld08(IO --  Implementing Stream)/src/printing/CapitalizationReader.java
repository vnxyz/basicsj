package printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CapitalizationReader extends BufferedReader {
	//03. 
	/*
	 * Overriding this method by right click of class name and selecting source(Alt+Shift+S)
	 * and selecting Override/Implement methods
	 * 
	 */
	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		if(line != null)
			return line.toUpperCase();
		else 
			return null;
	}

	public CapitalizationReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

}
