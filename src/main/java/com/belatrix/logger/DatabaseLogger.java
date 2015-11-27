package com.belatrix.logger;

import org.apache.log4j.Logger;

/**
 * Simple database logging
 * <p>
 * In order to use this class be sure that the table LOGS exist.
 * <p>
 * <b>Configuration:</b>
 * By default each <tt>DatabseLogger</tt> is initialized using the following
 * <tt>Resource</tt> configuration properties from log4j-database.properties.. 
 */
public class DatabaseLogger extends com.belatrix.logger.Logger {
	private static final Logger logger = Logger.getLogger(DatabaseLogger.class);

	@Override
	protected void logMessage(Message message) {
		logger.info(message.getMessage());
	}	

}
