package com.exception;

import java.io.IOException;

public class DaoException extends IOException {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void printStackTrace() {
		System.out.println("This is test");
	}
	
	

}
