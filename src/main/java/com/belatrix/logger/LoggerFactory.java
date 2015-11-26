package com.belatrix.logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.belatrix.logger.util.TargetType;

/**
 * This class is a factory to create different logger targets. 
 * <p>
 * In order to use it call getLogger method and send by parameter
 * the new target type.
 *
 */
public class LoggerFactory {
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"Spring-Module.xml");
	
	/**
	 * Retrieve a new instance for different logger types.
	 * @param targetType the specify the target type for logging.
	 * @return an instance of a logger. 
	 * @throws Exception
	 */
	public static ILogger getLogger(TargetType targetType) throws Exception {
		ILogger logger = null;
		
		switch (targetType) {
			case CONSOLE:
				logger =  (ConsoleLogger) context.getBean("consoleLogger");	
				break;
			case DATABASE:
				logger = (DatabaseLogger) context.getBean("dataBaseLogger");	
				break;
			case FILE:
				logger = (FileLogger) context.getBean("fileLogger");	
				break;
		}
		
		return logger;
	}
}
