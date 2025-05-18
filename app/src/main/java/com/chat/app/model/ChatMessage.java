package com.chat.app.model;

import java.security.KeyStore.PrivateKeyEntry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {
	
	
	private long id;
	private String sender;
	private String content;

}
