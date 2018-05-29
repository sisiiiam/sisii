package com.myapp.access.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.access.dao.DocumentDao;
import com.myapp.access.model.Document;

/**
 * Class description
 *
 * @author Pradnya Talekar
 * @date 18 May 2018
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService{
	
	@Override
	public Document getDocument(Long documentID) {
		return documentDao.getDocument(documentID);		
	}
	
	@Autowired
	DocumentDao documentDao;

}
