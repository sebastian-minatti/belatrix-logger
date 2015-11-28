package com.belatrix.logger.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.belatrix.logger.dao.LoggerControlDao;
import com.belatrix.logger.model.LoggerControl;
import com.belatrix.logger.util.MessageType;

public class LoggerControlDaoImpl extends HibernateDaoSupport implements LoggerControlDao{

	/**
	 * Retrieve the log controller flag from database.
	 * (TODO) This method should be changed in order to use Criteria and also validate it for IndexOutOfBoundsException
	 * but for the sake of show how to work with hibernate is OK.
	 * 
	 * @param MessageType
	 * @return LoggerControl 
	 */
	@Override
	public LoggerControl findByMessageType(MessageType messageType) {
		LoggerControl loggerControl = (LoggerControl) getHibernateTemplate().find("from LoggerControl where messageType=?", messageType.toString()).get(0);
		return loggerControl;
	}

}
