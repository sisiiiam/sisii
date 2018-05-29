package com.myapp.access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.access.exception.ResourceNotFoundException;
import com.myapp.access.model.Document;
import com.myapp.access.service.DocumentService;

/**
 * Rest API for Dcoument function
 *
 * @author Pradnya Talekar
 * @date 16 May 2018
 */

@RestController
@RequestMapping("/document")
public class DocumentController {

	@RequestMapping(value = "/readDocument", method = RequestMethod.GET, produces = "application/json")	
	public ResponseEntity<Document> getDocument(@RequestParam(value = "docID") Long documentID) {

		Document document = documentService.getDocument(documentID);		
		if(document == null)
		{			
			throw new ResourceNotFoundException(documentID, "Following document id not found: "+documentID);
		}
		
		return new ResponseEntity<Document>(document, HttpStatus.OK);
	}	

	@Autowired
	DocumentService documentService;

}
