package com.petrichor.extrack;

public class ExTrackException extends RuntimeException {

	private static final long serialVersionUID = -1827796696064739978L;

	public ExTrackException() {
	}

	public ExTrackException(String message) {
		super(message);
	}

	public ExTrackException(Throwable cause) {
		super(cause);
	}

	public ExTrackException(String message, Throwable cause) {
		super(message, cause);
	}

}
