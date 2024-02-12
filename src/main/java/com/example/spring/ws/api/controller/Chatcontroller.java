package com.example.spring.ws.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.spring.ws.api.model.Chatmessage;

@Controller
public class Chatcontroller {

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public Chatmessage register( @Payload Chatmessage Chatmessage,SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", Chatmessage.getSender());
		return Chatmessage;
	}
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public Chatmessage sendMessage(@Payload Chatmessage Chatmessage) {
		return Chatmessage;
	}
	
}
