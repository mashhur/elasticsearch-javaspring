package com.mashhur.elasticsearch.demo;

import com.mashhur.elasticsearch.demo.Index.DocumentEntryController;
import com.mashhur.elasticsearch.demo.Index.IndexController;
import com.mashhur.elasticsearch.demo.Index.QueryController;
import com.mashhur.elasticsearch.demo.client.EsClient;
import com.mashhur.elasticsearch.demo.domain.EsDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsApp {

    public static final String indexName = "persons";
    public static final String typeName = "person";
    private static final Logger LOG = LoggerFactory
            .getLogger(EsApp.class);

    public static void main(String[] args) {

        EsClient esClient = new EsClient("localhost", 9300);

        // Create Index
        IndexController indexController = new IndexController(esClient);
        //indexController.createIndex(indexName, typeName);

        // Create Documents
        EsApp esApp = new EsApp();
        //esApp.indexDocument(esClient);

        // Search...
        QueryController queryController = new QueryController(esClient);
        queryController.queryTerm(indexName, typeName, "A");
        queryController.queryFuzzy(indexName, typeName, "B");

        esClient.shutdown();
    }

    public void indexDocument(EsClient esClient) {
        try {
            DocumentEntryController entryController = new DocumentEntryController(esClient);
            entryController.createDocument(new EsDocument("A", "A1", 30, ""), indexName, typeName);
            entryController.createDocument(new EsDocument("B", "B1", 30, ""), indexName, "Person");
            entryController.createDocument(new EsDocument("C", "C1", 30, ""), indexName, typeName);
            entryController.createDocument(new EsDocument("D", "D1", 30, ""), indexName, typeName);
            entryController.createDocument(new EsDocument("E", "E1", 30, ""), indexName, typeName);
            entryController.createDocument(new EsDocument("F", "F1", 30, ""), indexName, typeName);
        } catch (final Exception ex) {
            LOG.error("Exception: ", ex);
        }

    }
}
