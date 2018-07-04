package com.myapp.access.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import com.myapp.access.model.Person;

/**
 * Class description
 *
 * @author Pradnya Talekar
 * @date   25 Jun 2018
 */

@Service("eSSearchService")
public class ESSearchServiceImpl implements ESSearchService{

	@Override
	public List<Person> findPersonByName(String name) {		
		RestClientBuilder lowLevelRestClientBuilder = RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http"));
		RestHighLevelClient client = new RestHighLevelClient(lowLevelRestClientBuilder);		
		
		SearchRequest searchRequest = new SearchRequest("sis");
		searchRequest.types("person");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		
		searchSourceBuilder.query(QueryBuilders.fuzzyQuery("user", name));
		searchRequest.source(searchSourceBuilder);		
		List<Person> esPersonSearchLst = new ArrayList<Person>();
		
		try {			
			SearchResponse repsonse = client.search(searchRequest);
			SearchHits hits = repsonse.getHits();
			for(SearchHit hit : hits.getHits())
			{
				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				Person person = new Person();
				person.setUser((String) sourceAsMap.get("user"));
				person.setPostDate((String) sourceAsMap.get("postDate"));
				person.setMessage((String) sourceAsMap.get("message"));
				System.out.println(sourceAsMap.get("user"));
				System.out.println(sourceAsMap.get("postDate"));
				System.out.println(sourceAsMap.get("message"));
				esPersonSearchLst.add(person);
			}
			
			client.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return esPersonSearchLst;		
	}
}
