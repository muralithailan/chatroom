package com.websocker.chat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * This class if to configure websocket
 * @author Murali
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfiguration implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		registry.addEndpoint("/chatRoom").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry register) {
		register.setApplicationDestinationPrefixes("/chatRoom");
		register.enableSimpleBroker("/topic");
	}
	

}
