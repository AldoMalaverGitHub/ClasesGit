package com.activemq.queue;

import java.util.List;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class SendMessage {
	
	private static final String URL = "tcp://localhost:61616";
	private static final String USER = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final boolean TRANSACTED_SESSION = true;
	
	public void sendMessage(String destinationQueue, String message) throws JMSException {

		final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		final Session session = connection.createSession(TRANSACTED_SESSION, Session.AUTO_ACKNOWLEDGE);
		final Destination destination = session.createQueue(destinationQueue);

		final MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);

		createMessage(session, producer, message);
		session.commit();

		session.close();
		connection.close();

		System.out.println("Message were sent successfully");
		
		
	}
	
	public void sendMessages(String destinationQueue, List<String> messages) throws JMSException {

		final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		final Session session = connection.createSession(TRANSACTED_SESSION, Session.AUTO_ACKNOWLEDGE);
		final Destination destination = session.createQueue(destinationQueue);

		final MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);

		createMessages(session, producer, messages);
		session.commit();

		session.close();
		connection.close();

		System.out.println("Message were sent successfully");
		
		
	}
	
	private void createMessages(Session session, MessageProducer producer, List<String> messages) throws JMSException {
		for(String row: messages){
			createMessage(session, producer, row);
		}
	}
	
	private void createMessage(Session session, MessageProducer producer, String message) throws JMSException {
		final TextMessage textMessage = session.createTextMessage(message);
		producer.send(textMessage);
	}
	

}
