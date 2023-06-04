package com.example.brand.exception;

public class FaltanParametrosException extends Exception {

	private static final long serialVersionUID = 1L;

	public FaltanParametrosException() {
		super("Faltan parámetros");
	}
	
	public FaltanParametrosException(String message) {
		super("Faltan parámetros: "+message);
	}
	
}
