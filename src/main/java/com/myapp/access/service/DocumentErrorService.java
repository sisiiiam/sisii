package com.myapp.access.service;

import org.apache.camel.Exchange;

import com.myapp.access.exception.ExceptionResponse;

/**
 * Document not found error handler
 *
 * @author Pradnya Talekar
 * @date 06 June 2018
 */
public class DocumentErrorService {

	public ExceptionResponse idNotFound(Exchange exchange) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Not Found");
		response.setErrorMessage(
				"Document ID not found in the system: " + exchange.getIn().getHeader("docid", String.class));

		return response;
	}

}
