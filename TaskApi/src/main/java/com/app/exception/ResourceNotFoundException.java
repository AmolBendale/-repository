package com.app.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String fieldValue,String resourceName,String fieldName) 
   {
		super(String.format("%s with %s =%s not Found",resourceName,fieldName,fieldValue));
   }
}
