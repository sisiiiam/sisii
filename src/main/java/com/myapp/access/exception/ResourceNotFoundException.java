package com.myapp.access.exception;

/**
 * Class description
 *
 * @author Pradnya Talekar
 * @date 21 May 2018
 */

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Long resourceId;

	public ResourceNotFoundException(Long resourceId, String message) {
		super(message);
		this.resourceId = resourceId;
	}
}