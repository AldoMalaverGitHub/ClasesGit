package com.activemq.queue;

import java.util.Arrays;

import javax.jms.JMSException;

public class TestSendMessage {
	
	public static void main(String[] args) {
		
//		SendMessage sendMessage = new SendMessage();
//		
//		try {
//			sendMessage.sendMessage("TEST.QUEUE", "Hola amor");
//		
//		} catch (JMSException e) {
//			
//			e.printStackTrace();
//		}
		
		SendMessage sendMessage = new SendMessage();
		
		try {
			
			sendMessage.sendMessages("TEST.QUEUE", 
					Arrays.asList("Hola amor", "Hola pp", "hello"));
		
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}

}
