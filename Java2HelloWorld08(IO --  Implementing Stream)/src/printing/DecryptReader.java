package printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import Security.EncryptDecrypt;

public class DecryptReader extends BufferedReader {

	EncryptDecrypt decrypt = null;

	@Override
	public String readLine() {
		String superOut;
		try {
			String line = super.readLine();
			if (line != null)
				superOut = decrypt.decrypt(line);
			else
				superOut = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			superOut = null;
			e.printStackTrace();
		}
		return superOut;

	}

	public DecryptReader(Reader in, String encryptionKey, String delimeter) {
		super(in);
		decrypt = new EncryptDecrypt(encryptionKey, delimeter);

	}
}
