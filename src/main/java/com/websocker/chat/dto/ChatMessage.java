package com.websocker.chat.dto;

import com.websocker.chat.constant.MessageType;
/**
 * Message payload
 * @author bala
 *
 */
public class ChatMessage {
	
	private String content;
	
	private MessageType type;
	
	private String sender;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	
}
