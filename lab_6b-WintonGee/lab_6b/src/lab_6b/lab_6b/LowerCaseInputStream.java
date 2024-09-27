package lab_6b;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}

	/*
	 * We should override the read method from FilterInputStream t 
	 * o take a byte and convert each byte (that represents a character) 
	 * to lowercase if it is an uppercase character.
	 */

	/* Steps
		- Override read from FilterInputStream
		- Take a byte and covert each to lower case if it is an upper case
	 */
	@Override
	public int read() throws IOException {
		int charByte = super.read();
		return Character.isUpperCase(charByte) ? Character.toLowerCase(charByte) : charByte;
	}
	
}
