package com.belatrix.logger.bo;

import com.belatrix.logger.model.LoggerControl;
import com.belatrix.logger.util.MessageType;

public interface LoggerControlBo {
	public LoggerControl findByMessageType(MessageType messageType);
}
