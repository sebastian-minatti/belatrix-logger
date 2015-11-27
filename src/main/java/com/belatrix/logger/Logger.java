package com.belatrix.logger;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.core.io.Resource;

import com.belatrix.logger.bo.LoggerControlBo;
import com.belatrix.logger.util.MessageType;

public abstract class Logger implements ILogger {
	private LoggerControlBo loggerControlBo;
	private Resource resource;

	public void setLoggerControlBo(LoggerControlBo loggerControlBo) {
		this.loggerControlBo = loggerControlBo;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void write(Message message) throws IOException {

		if (!message.isValidMessage()
				|| !isActiveMessageType(message.getMessageType())) {
			throw new IllegalArgumentException(
					"invalid message or type message, please check parameters.");
		}

		PropertyConfigurator.configure(resource.getURL());
		logMessage(message);
	}

	/**
	 * This method is used to validate wether the message could be logged or
	 * not.
	 * 
	 * @param messageType
	 * @return
	 */
	protected boolean isActiveMessageType(MessageType messageType) {
		return loggerControlBo.findByMessageType(messageType).isActive();
	}

	protected abstract void logMessage(Message message);

}
