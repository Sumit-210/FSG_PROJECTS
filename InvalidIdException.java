package org.fsg.collection.project;


public class InvalidIdException extends RuntimeException {
	private String message;
	public InvalidIdException(String message) {
		this.message=message;
		
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
