package com.belatrix.logger.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

/**
 * Used for testing propose since we need to print to console and 
 * then we need to check if effectively we print what we expect.  
 *
 */
public class ConsolePrintStream extends PrintStream{
	public final StringBuilder buffer;
	public final PrintStream printStream;

	private ConsolePrintStream(StringBuilder builder, OutputStream outPut, PrintStream printStream) {
		super(outPut);
		this.buffer = builder;
		this.printStream = printStream;
	}

	/**
	 * this method will create an instance of ConsolePrintStream in order
	 * to start recording console output.
	 * @param printStream an instance of PrintStream
	 * @return ConsolePrintStream in fact is wrapper from PrintStream
	 */
	public static ConsolePrintStream create(PrintStream printStream) {
		try {
			final StringBuilder sb = new StringBuilder();
			Field f = FilterOutputStream.class.getDeclaredField("out");
			f.setAccessible(true);
			OutputStream psout = (OutputStream) f.get(printStream);
			return new ConsolePrintStream(sb, new FilterOutputStream(psout) {
				public void write(int b) throws IOException {
					super.write(b);
					sb.append((char) b);
				}
			}, printStream);
		} catch (NoSuchFieldException ex) {
		} catch (IllegalArgumentException ex) {
		} catch (IllegalAccessException ex) {
		}
		return null;
	}
}
