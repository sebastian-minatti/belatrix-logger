package com.belatrix.logger.bo.impl;

import com.belatrix.logger.bo.LoggerControlBo;
import com.belatrix.logger.dao.LoggerControlDao;
import com.belatrix.logger.model.LoggerControl;
import com.belatrix.logger.util.MessageType;

public class LoggerControlBoImpl implements LoggerControlBo{

	private LoggerControlDao loggerControlDao;
	
	public void setLoggerControlDao(LoggerControlDao loggerControlDao) {
		this.loggerControlDao = loggerControlDao;
	}

	@Override
	public LoggerControl findByMessageType(MessageType messageType) {
		return loggerControlDao.findByMessageType(messageType);
	}

}
