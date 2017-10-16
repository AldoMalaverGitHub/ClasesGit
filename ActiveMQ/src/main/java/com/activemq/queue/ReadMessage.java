package com.activemq.queue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ReadMessage {

	private static final String URL = "tcp://localhost:61616";
	private static final String USER = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;	
	private static final boolean TRANSACTED_SESSION = false;
	private static final int TIMEOUT = 1000;
	
	public List<String> readMessages(String destinationQueue) throws JMSException {
		 
        final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
        final Connection connection = connectionFactory.createConnection();
 
        connection.start();
 
        final Session session = connection.createSession(TRANSACTED_SESSION, Session.AUTO_ACKNOWLEDGE);
        final Destination destination = session.createQueue(destinationQueue);
        final MessageConsumer consumer = session.createConsumer(destination);
 
        List<String> messageList = processAllMessagesInQueue(consumer);
 
        consumer.close();
        session.close();
        connection.close(); 
        
        return messageList;
        
    }
	
	public List<Serializable> readObjectMessages(String destinationQueue) throws JMSException {
		 
        final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
        final Connection connection = connectionFactory.createConnection();
 
        connection.start();
 
        final Session session = connection.createSession(TRANSACTED_SESSION, Session.AUTO_ACKNOWLEDGE);
        final Destination destination = session.createQueue(destinationQueue);
        final MessageConsumer consumer = session.createConsumer(destination);
 
        List<Serializable> messageObjectList = processAllMessagesObjectInQueue(consumer);
 
        consumer.close();
        session.close();
        connection.close(); 
        
        return messageObjectList;
        
    }
	
	private List<Serializable> processAllMessagesObjectInQueue(MessageConsumer consumer) throws JMSException {
		 List<Serializable> messageList = new ArrayList<>();
			Message message;
	        while ((message = consumer.receive(TIMEOUT)) != null) {
	        	messageList.add(proccessObject(message));
	        }
	        
	        return messageList;
	}
	
	private Serializable proccessObject(Message message) throws JMSException {
        if (message instanceof ObjectMessage) {
            final ObjectMessage objectMessage = (ObjectMessage) message;
            return objectMessage.getObject();           
            
        }
        
        return "";
    }	
	
	private List<String> processAllMessagesInQueue(MessageConsumer consumer) throws JMSException {
        List<String> messageList = new ArrayList<>();
		Message message;
        while ((message = consumer.receive(TIMEOUT)) != null) {
        	messageList.add(proccessMessage(message));
        }
        
        return messageList;
    }
	
	private String proccessMessage(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            final TextMessage textMessage = (TextMessage) message;
            return textMessage.getText();            
            
        }
        
        return "";
    }	
	

}
