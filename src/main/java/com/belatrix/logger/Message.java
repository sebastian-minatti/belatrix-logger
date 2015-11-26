package com.belatrix.logger;

import com.belatrix.logger.util.MessageType;

/**
 * Used to log to different targets.
 * <p>
 * In order to use it specify the message information and the 
 * message type.
 * 
 */
public class Message {
	private String message;
	private MessageType messageType;

	public Message(String message, MessageType messageType) {
		super();
		this.message = message;
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	
	public boolean isValidMessage() {
		return (this.message != null) && (!this.message.isEmpty()) &&(this.messageType!=null);
	}
}
