package com.websocker.chat.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.websocker.chat.constant.MessageType;
import com.websocker.chat.dto.ChatMessage;

/**
 * This listener class to configure message queues
 * @author z022839
 *
 */
@Configuration
public class WebSocketEventListener {
	
	@Autowired
	SimpMessageSendingOperations  simpMessageSendingOperations ;

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		
	}
	
	@EventListener
	public void handleWebSocketDisConnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String user = (String) headerAccessor.getSessionAttributes().get("userName");
		
		if(user != null) {
			
			ChatMessage message = new ChatMessage();
			message.setType(MessageType.LEAVE);
			message.setSender(user);
			simpMessageSendingOperations.convertAndSend("/topic/public",message);
			
		}
	}
}
