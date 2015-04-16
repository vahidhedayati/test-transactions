package com.example.exception

class TravelException extends Exception {

	@Override
	public Throwable fillInStackTrace() {
		// do nothing
		return this
	}
	
	
	/*
	public TravelException(){
	}

	public TravelException(String msg){
		super(msg)
	}
	*/
}
