package com.belatrix.logger;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.core.io.Resource;

/**
 * Simple database logging
 * <p>
 * In order to use this class be sure that the table LOGS exist.
 * <p>
 * <b>Configuration:</b>
 * By default each <tt>DatabseLogger</tt> is initialized using the following
 * <tt>Resource</tt> configuration properties from log4j-database.properties.. 
 */
public class DatabaseLogger extends com.belatrix.logger.Logger implements ILogger{
	private static final Logger logger = Logger.getLogger(DatabaseLogger.class);
	private Resource resource;
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void write(Message message) throws IOException{
		PropertyConfigurator.configure(resource.getURL());
		if(message.isValidMessage() && isActiveMessageType(message.getMessageType())) {
			logger.info(message.getMessage());
		}
	}

}
