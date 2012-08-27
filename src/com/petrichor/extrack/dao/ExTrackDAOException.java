package com.petrichor.extrack.dao;

import com.petrichor.extrack.ExTrackException;

public class ExTrackDAOException extends ExTrackException {

	private static final long serialVersionUID = 3300125532002257462L;

	public ExTrackDAOException() {
	}

	public ExTrackDAOException(String message) {
		super(message);
	}

	public ExTrackDAOException(Throwable cause) {
		super(cause);
	}

	public ExTrackDAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
