package com.belatrix.logger;

import org.apache.log4j.Logger;

/**
 * Simple file logging
 * <p>
 * By default buffering is enabled in the IO libraries but each log
 * record is flushed out when it is complete.
 * <p>
 * <b>Configuration:</b>
 * By default each <tt>FileLogger</tt> is initialized using the following
 * <tt>Resource</tt> configuration properties from log4j-file.properties. 
 */
public class FileLogger extends com.belatrix.logger.Logger {
	private static final Logger logger = Logger.getLogger(FileLogger.class.getName());
	
	@Override
	protected void logMessage(Message message) {
		logger.info(message.getMessage());
	}	

}