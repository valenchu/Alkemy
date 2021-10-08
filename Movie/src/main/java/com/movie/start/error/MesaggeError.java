package com.movie.start.error;

public class MesaggeError extends RuntimeException {
	public MesaggeError(String error, Throwable e, boolean enableSuppression,
			boolean stackTrace) {
		super(error, e, enableSuppression, stackTrace);
	}

	public MesaggeError(String error) {
		super(error);
	}
	public MesaggeError(String error, Throwable e) {
		super(error, e);
	}
}
