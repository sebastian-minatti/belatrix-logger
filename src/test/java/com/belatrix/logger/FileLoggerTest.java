package com.belatrix.logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.belatrix.logger.util.MessageType;
import com.belatrix.logger.util.TargetType;

import static org.junit.Assert.*;

public class FileLoggerTest {
	private static ILogger logger;

	@BeforeClass
	public static void initFileLogger() throws Exception {
		logger = LoggerFactory.getLogger(TargetType.FILE);
	}

	@Test
	public void testLogToFileSuccessfully() throws FileNotFoundException, IOException {
		Message message = new Message("print to file", MessageType.MESSAGE);
		logger.write(message);
		assertTrue("Value not expected.", hasValueOnFile(message.getMessage()));

	}
	
	@Test
	public void testLogToFileUnsuccessfully() throws FileNotFoundException, IOException {
		String wrongMessage = new String("wrong message");
		Message message = new Message("print to file", MessageType.MESSAGE);
		logger.write(message);
		assertFalse("Value not expected.", hasValueOnFile(wrongMessage));
	}	

	private boolean hasValueOnFile(String message) {
		String lineValue = null;
		try {
			lineValue = readFirstLineFromFile("C:\\Users\\sebastian\\Documents\\log.out");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineValue.equals(message);
	}
	
	private String readFirstLineFromFile(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
}
