package com.belatrix.logger;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.core.io.Resource;

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
public class FileLogger extends com.belatrix.logger.Logger implements ILogger{
	private static final Logger logger = Logger.getLogger(FileLogger.class.getName());
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