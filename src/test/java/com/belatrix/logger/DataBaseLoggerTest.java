package com.belatrix.logger;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.belatrix.logger.util.MessageType;
import com.belatrix.logger.util.TargetType;

import static org.junit.Assert.*;

public class DataBaseLoggerTest {
	private static ILogger logger;

	@BeforeClass
	public static void initDataBaseLogger() throws Exception {
		logger = LoggerFactory.getLogger(TargetType.DATABASE);
	}
	
	@Test
	public void testLogToDatabaseSuccessfully() {
		Message message = new Message("print to database", MessageType.MESSAGE);
		try {
			logger.write(message);
		} catch(IOException ex){
			fail("Something wrong happen when insert to database." + ex.getCause());
		}
	}
	
}
