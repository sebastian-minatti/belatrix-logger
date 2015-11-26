package com.belatrix.logger.dao;

import com.belatrix.logger.model.LoggerControl;
import com.belatrix.logger.util.MessageType;

public interface LoggerControlDao {
	public LoggerControl findByMessageType(MessageType messageType);
}
