package fr.gtm.timer;

import java.io.Serializable;

public class Message implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value ;
	
	public Message () {
		
	}

	public Message(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
