package Security;

import java.util.StringTokenizer;

public class EncryptDecrypt {
	String encryptKey, delimeter;
	int a, b, c, d, e;

	public EncryptDecrypt(String encryptKey, String delimeter) {
		this.encryptKey = encryptKey;
		this.delimeter = delimeter;
		initializeEncryptionParameters();
	}

	private void initializeEncryptionParameters() {
		a = encryptKey.charAt(1);
		b = encryptKey.charAt(encryptKey.length() - 1);
		c = encryptKey.charAt(0);
		d = encryptKey.charAt((int) Math.floor(encryptKey.length() / 2));
		e = encryptKey.charAt((int) Math.ceil((encryptKey.length() / 2)));
	}

	public String encrypt(String x) {
		String output = "";
		for (int i = 0; i < x.length() - 1; i++) {
			int j = (int) x.charAt(i);
			int k = (((j * a) + b) - c) * d * e;
			output = k + delimeter + output;
		}
		return output;
	}

	public String decrypt(String x) {
		String output = "";
		if (x != null) {
			StringTokenizer i = new StringTokenizer(x, delimeter);
			while (i.hasMoreTokens()) {
				int j = Integer.parseInt(i.nextToken());
				output = (char) ((j / (d * e) + c - b) / a) + output;
			}
		}
		return output;

	}

}
