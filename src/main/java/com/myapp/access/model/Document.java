package com.myapp.access.model;

/**
 * Class description
 *
 * @author Pradnya Talekar
 * @date 16 May 2018
 */

public class Document {
	private Long documentID;
	private String schengenID;

	public Long getDocumentID() {
		return documentID;
	}

	public void setDocumentID(Long documentID) {
		this.documentID = documentID;
	}

	public String getSchengenID() {
		return schengenID;
	}

	public void setSchengenID(String schengenID) {
		this.schengenID = schengenID;
	}

}
