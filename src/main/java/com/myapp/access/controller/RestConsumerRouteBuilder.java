package com.myapp.access.controller;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.access.exception.ResourceNotFoundException;
import com.myapp.access.service.DocumentErrorService;
import com.myapp.access.service.DocumentService;
import com.myapp.access.service.ESSearchService;



@Component("restConsumerRouteBuilder")
public class RestConsumerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		restConfiguration().component("servlet").contextPath("/hello-app/camel").host("localhost").port(8080)
				.bindingMode(RestBindingMode.auto);

		onException(ResourceNotFoundException.class).handled(true)
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
				.setBody(simple("{ error: ${exception.message} }"));

		// route 1 - rest
		from("file:c:/inbox-configFldr?noop=true").to("file:c:/outbox-configFldr?noop=true");

		// route 2 - rest
		rest("/document").get("/documentID/{docID}").produces("application/json").to("direct:documentService");

		
		from("direct:documentService").bean(documentService, "getDocument(${header.docID})")
		.choice()
				.when(simple("${body} == null"))				
				.bean(new DocumentErrorService(), "idNotFound");
		
		// route 3 - rest
				rest("/person").get("/name?{name}").produces("application/json").to("direct:eSSearchService");
				
				from("direct:eSSearchService").bean(eSSearchService, "findPersonByName(${header.name})")
				.choice()
						.when(simple("${body} == null"))				
						.bean(new DocumentErrorService(), "idNotFound");

	}

	@Autowired
	DocumentService documentService;
	
	@Autowired
	ESSearchService eSSearchService;
}
