package com.zenus.elasticsearch.demo.Index;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zenus.elasticsearch.demo.client.ESClient;

public class QueryController {
	private static final Logger LOG = LoggerFactory.getLogger(QueryController.class);
	
	private ESClient esClient;
	
	public QueryController(ESClient esClient) {
		this.esClient = esClient;
	}
	
	public SearchResponse queryFuzzy(String indexName, String type, String value){
		SearchResponse response = esClient.getClient().prepareSearch(indexName)
		.setTypes(type)
		.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
		.setQuery(QueryBuilders.boolQuery().should(QueryBuilders.boolQuery().must(QueryBuilders.fuzzyQuery("firstName", value).fuzziness(Fuzziness.AUTO).prefixLength(0))))
		.setFrom(0).setSize(60).setExplain(true)
		.execute()
		.actionGet();
		LOG.info("Response: " + response.toString());
		return response;
	}
	
	public SearchResponse queryTerm(String indexName, String type, String value) {
		SearchResponse response = esClient.getClient().prepareSearch(indexName)
		.setTypes(type)
		.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
		.setQuery(QueryBuilders.termQuery("firstName", value))
		.setFrom(0).setSize(60).setExplain(true)
		.execute()
		.actionGet();
		LOG.info("Response: " + response.toString());
		return response;
	}
}
