package printing;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import Security.EncryptDecrypt;

public class EncryptWriter extends PrintWriter {
	
	String encryptKey;
	String delimeter;
	EncryptDecrypt encryption = null;
	
	@Override
	public void println(String x) {
		super.println(encryption.encrypt(x));
	}



	public EncryptWriter(PrintWriter writer, String encryptKey, String delimeter) throws FileNotFoundException {
		super(writer);
		this.encryptKey = encryptKey;
		this.delimeter = delimeter;
		encryption = new EncryptDecrypt(encryptKey, delimeter);
	}
}
