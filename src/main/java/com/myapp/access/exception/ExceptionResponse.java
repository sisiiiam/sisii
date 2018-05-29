package com.myapp.access.exception;

/**
 * Error object
 *
 * @author Pradnya Talekar
 * @date 21 May 2018
 */

public class ExceptionResponse {
	private String errorCode;
    private String errorMessage;

    public ExceptionResponse() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
