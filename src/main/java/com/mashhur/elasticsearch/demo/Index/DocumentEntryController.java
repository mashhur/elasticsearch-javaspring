package com.mashhur.elasticsearch.demo.Index;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashhur.elasticsearch.demo.client.ESClient;
import com.mashhur.elasticsearch.demo.domain.ESDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentEntryController {
    private static final Logger LOG = LoggerFactory.getLogger(DocumentEntryController.class);
    private ESClient esClient;

    public DocumentEntryController(ESClient esClient) {
        this.esClient = esClient;
    }

    public void createDocument(ESDocument document, String indexName, String type) {
        String documentJson = null;
        try {
            documentJson = new ObjectMapper().writeValueAsString(document);
            esClient.getClient().prepareIndex(indexName, type)
                    .setSource(documentJson).execute().actionGet();
            LOG.info("Document indexed.");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
