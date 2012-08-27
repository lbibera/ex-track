package com.petrichor.extrack.service;

import com.petrichor.extrack.ExTrackException;

public class ExTrackServiceException extends ExTrackException {

	private static final long serialVersionUID = 7610905720576916029L;

	public ExTrackServiceException() {
	}

	public ExTrackServiceException(String message) {
		super(message);
	}

	public ExTrackServiceException(Throwable cause) {
		super(cause);
	}

	public ExTrackServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
