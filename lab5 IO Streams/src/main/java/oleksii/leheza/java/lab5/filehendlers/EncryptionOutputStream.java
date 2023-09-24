package oleksii.leheza.java.lab5.filehendlers;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptionOutputStream extends FilterOutputStream {

	private final char key;

	public EncryptionOutputStream(OutputStream out, char key) {
		super(out);
		this.key = key;
	}

	@Override
	public void write(int b) throws IOException {
		super.write(b + key);
	}
}