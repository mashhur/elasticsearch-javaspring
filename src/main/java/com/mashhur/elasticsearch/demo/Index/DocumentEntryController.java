package com.mashhur.elasticsearch.demo.Index;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashhur.elasticsearch.demo.client.EsClient;
import com.mashhur.elasticsearch.demo.domain.EsDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentEntryController {
    private static final Logger LOG = LoggerFactory.getLogger(DocumentEntryController.class);
    private EsClient esClient;

    public DocumentEntryController(EsClient esClient) {
        this.esClient = esClient;
    }

    public void createDocument(EsDocument document, String indexName, String type) {
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
