package com.myapp.access.dao;

import com.myapp.access.model.Document;

/**
 * An interface to 
 *
 * @author Pradnya Talekar
 * @date 17 May 2018
 */

public interface DocumentDao {
	
	public Document getDocument(Long documentID);
	
}
