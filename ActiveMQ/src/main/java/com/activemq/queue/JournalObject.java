package com.activemq.queue;

import java.io.Serializable;

public class JournalObject implements Serializable {

	private String userName;
	private String name;
	private String description;	

	public JournalObject(String userName, String name, String description) {
		super();
		this.userName = userName;
		this.name = name;
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
