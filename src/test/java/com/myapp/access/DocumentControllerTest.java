package com.myapp.access;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Ignore;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

/**
 * Test for {@code DcoumentController}
 *
 * @author Pradnya Talekar
 * @date 22 May 2018
 */
@Ignore
public class DocumentControllerTest {
	@Test
	public void shouldReturnDocumentID() {
		RestAssured.get("http://localhost:8080/hello-app/document/readDocument?docID=1")
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.body("documentID", equalTo(1))
		.body("schengenID", equalTo("123456789"));
	}
	
	@Test
	public void shouldReturnDocumentIDNotFound() {
		RestAssured.get("http://localhost:8080/hello-app/document/readDocument?docID=3")
		.then()
		.statusCode(404)
		.contentType(ContentType.JSON)
		.body("errorCode", equalTo("Not Found"))
		.body("errorMessage", equalTo("Following document id not found: 3"));
	}

}
