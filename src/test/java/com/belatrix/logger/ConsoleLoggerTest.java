package com.belatrix.logger;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.belatrix.logger.util.MessageType;
import com.belatrix.logger.util.TargetType;
import com.belatrix.logger.util.ConsolePrintStream;

import static org.junit.Assert.*;

public class ConsoleLoggerTest {
	private static ILogger logger;
	private static ConsolePrintStream printStream;

	@BeforeClass
	public static void initConsoleLogger() throws Exception {
		logger = LoggerFactory.getLogger(TargetType.CONSOLE);
		printStream = ConsolePrintStream.create(System.out);
	}

	@Before
	public void setUp() {
		System.setOut(printStream);
	}
	
	@After 
	public void tearDown() {
		System.setOut(null);
	}

	@Test
	public void testLogToConsoleSuccessfully() throws IOException {
		Message message = new Message("print to console", MessageType.MESSAGE);
		logger.write(message);
		assertTrue("Value not expected.", printStream.buffer.toString().contains(message.getMessage()));
	}
	
	@Test
	public void testLogToConsoleUnsuccessfully() throws IOException {
		Message message = new Message("print to console", MessageType.MESSAGE);
		logger.write(message);
		assertFalse("Value not expected.", printStream.buffer.toString().equals(message.getMessage()));
	}
	
	@Test
	public void testLogToConsoleWithNullMessage() throws IOException {
		Message message = new Message(null, MessageType.MESSAGE);
		logger.write(message);
		assertTrue("Value not expected.", printStream.buffer.toString().isEmpty());
	}
	
	@Test
	public void testLogToConsoleWithEmptyMessage() throws IOException {
		Message message = new Message("", MessageType.MESSAGE);
		logger.write(message);
		assertTrue("Value not expected.", printStream.buffer.toString().isEmpty());
	}	
	
	@Test
	public void testLogToConsoleWithNullTypeMessage() throws IOException {
		Message message = new Message("print with null type message", null);
		logger.write(message);
		assertFalse("Value not expected.", printStream.buffer.toString().isEmpty());
	}	
	
}
