package com.belatrix.logger;

import java.io.IOException;

/**
 * This interface is used to print to different target for example:
 * console, database or file.
 * <p>
 * In order to use this you need to implement this class and 
 * override write method don't forget to add the new log4j configuration
 * for the new target.
 *
 */
public interface ILogger {
	public void write(Message message) throws IOException;
}
