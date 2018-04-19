package com.zenus.elasticsearch.demo.Index;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zenus.elasticsearch.demo.client.ESClient;

public class IndexController {
	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	
	private ESClient esClient;
	
	public IndexController(ESClient esClient) {
		this.esClient = esClient;
	}
	
	public void createIndex(String indexName, String type) {
		try {
	    	final CreateIndexRequestBuilder createIndexRequestBuilder = esClient.getClient().admin().indices().prepareCreate(indexName).setSettings();
	        createIndexRequestBuilder.addMapping(type, getMapping(type));
	        createIndexRequestBuilder.execute().actionGet();
	        LOG.info("Index Created.");
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private XContentBuilder getMapping(String type) throws IOException{
        XContentBuilder mappingBuilder = jsonBuilder().startObject().startObject(type).startObject("properties")
			        .startObject("firstname").field("type", "string").endObject()
			        .startObject("lastname").field("type", "string").endObject()
			        .startObject("age").field("type", "integer").endObject()
			        .startObject("description").field("type", "string").endObject()
			        .endObject().endObject().endObject();
		return mappingBuilder;
	}
}
