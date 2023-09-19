package oleksii.leheza.java.lab5.filehendlers;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptionInputStream extends FilterInputStream {
	private final char key;

	public DecryptionInputStream(InputStream in, char key) {
		super(in);
		this.key = key;
	}

	@Override
	public int read() throws IOException {
		int decryptedByte = super.read();
		if (decryptedByte != -1) {
			decryptedByte -= key;
		}
		return decryptedByte;
	}
}