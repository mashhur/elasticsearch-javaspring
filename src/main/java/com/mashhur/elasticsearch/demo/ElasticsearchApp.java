package com.mashhur.elasticsearch.demo;

import com.mashhur.elasticsearch.demo.Index.DocumentEntryController;
import com.mashhur.elasticsearch.demo.Index.IndexController;
import com.mashhur.elasticsearch.demo.Index.QueryController;
import com.mashhur.elasticsearch.demo.client.ESClient;
import com.mashhur.elasticsearch.demo.domain.ESDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElasticsearchApp {

    public static final String indexName = "persons";
    public static final String typeName = "person";
    private static final Logger LOG = LoggerFactory
            .getLogger(ElasticsearchApp.class);

    public static void main(String[] args) {
        ESClient esClient = new ESClient();

        // Create Index
        IndexController indexController = new IndexController(esClient);
        //indexController.createIndex(indexName, typeName);

        // Create Documents
        ElasticsearchApp elasticsearchApp = new ElasticsearchApp();
        //elasticsearchApp.indexDocument(esClient);

        // Search...
        QueryController queryController = new QueryController(esClient);
        queryController.queryTerm(indexName, typeName, "A");
        queryController.queryFuzzy(indexName, typeName, "B");

        esClient.shutdown();
    }

    public void indexDocument(ESClient esClient) {
        try {
            DocumentEntryController entryController = new DocumentEntryController(esClient);
            entryController.createDocument(new ESDocument("A", "A1", 30, ""), indexName, typeName);
            entryController.createDocument(new ESDocument("B", "B1", 30, ""), indexName, "Person");
            entryController.createDocument(new ESDocument("C", "C1", 30, ""), indexName, typeName);
            entryController.createDocument(new ESDocument("D", "D1", 30, ""), indexName, typeName);
            entryController.createDocument(new ESDocument("E", "E1", 30, ""), indexName, typeName);
            entryController.createDocument(new ESDocument("F", "F1", 30, ""), indexName, typeName);
        } catch (final Exception ex) {
            LOG.error("Exception: ", ex);
        }

    }
}
