package com.myapp.access;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.myapp.access.dao.DocumentDao;
import com.myapp.access.model.Document;
import com.myapp.access.service.DocumentService;
import com.myapp.access.service.DocumentServiceImpl;

/**
 * Test for {@code DocumentService}
 *
 * @author Pradnya Talekar
 * @date  30 May 2018
 */

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceTest {	
		
	@InjectMocks
	DocumentService documentService = new DocumentServiceImpl();
	
	@Mock
	DocumentDao documentDao;
		
	@Test
	public void testGetDocumentService()
	{		
		Document document = new Document();
		document.setDocumentID(new Long(1));
		document.setSchengenID("123");
		
		Mockito.when(documentDao.getDocument(new Long(1))).thenReturn(document);
		
		Document doc = documentService.getDocument(new Long(1));
		
		assertEquals(document, doc);		
	}
}
