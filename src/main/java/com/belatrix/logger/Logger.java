package com.belatrix.logger;

import com.belatrix.logger.bo.LoggerControlBo;
import com.belatrix.logger.util.MessageType;

public class Logger {
	private LoggerControlBo loggerControlBo;
	
	public void setLoggerControlBo(LoggerControlBo loggerControlBo) {
		this.loggerControlBo = loggerControlBo;
	}
	
	/**
	 * This method is used to validate wether the message could be logged or not.
	 * @param messageType
	 * @return
	 */
	protected boolean isActiveMessageType(MessageType messageType){
		return loggerControlBo.findByMessageType(messageType).isActive();
	}	

}
