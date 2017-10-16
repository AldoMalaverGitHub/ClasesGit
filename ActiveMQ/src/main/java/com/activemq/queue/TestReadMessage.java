package com.activemq.queue;

import java.io.Serializable;
import java.util.List;

import javax.jms.JMSException;

public class TestReadMessage {
	
	public static void main(String[] args) {
		
		ReadMessage readMessage = new ReadMessage();
		
		try {
//			List<String> messageList = readMessage.readMessages("TEST.QUEUE");
//			messageList.forEach(System.out::println);
			List<Serializable> objectList = readMessage.readObjectMessages("dailyQueue");
			for(Serializable obj: objectList){
				JournalObject journalObject = (JournalObject)obj;
				System.out.println(journalObject.getName());
			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
