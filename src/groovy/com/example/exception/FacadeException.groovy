package com.example.exception

class FacadeException extends Exception{
	@Override
	public Throwable fillInStackTrace() {
		// do nothing
		return this
	}

}
