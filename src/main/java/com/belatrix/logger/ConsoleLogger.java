package com.belatrix.logger;

import org.apache.log4j.Logger;

/**
 * This <tt>Logger</tt> publishes log records to <tt>System.out</tt>.
 * <p>
 * <b>Configuration:</b>
 * By default each <tt>ConsoleLogger</tt> is initialized using the following
 * <tt>Resource</tt> configuration properties from log4j-console.properties.
 * 
 */
public class ConsoleLogger extends com.belatrix.logger.Logger {
	private static final Logger logger = Logger.getLogger(ConsoleLogger.class);
	
	@Override
	protected void logMessage(Message message) {
		logger.info(message.getMessage());
	}	
}
