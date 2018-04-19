package com.mashhur.elasticsearch.demo.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class EsClient {

    private TransportClient client;

    public EsClient(String host, int port) {
		Settings settings = Settings.builder().put("client.transport.sniff", true).build();
		client = new PreBuiltTransportClient(settings);
		try {
			client.addTransportAddress(new InetSocketTransportAddress(
					InetAddress.getByName(host), port));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    }

    public Client getClient() {
    	return client;
    }

    public void shutdown() {
		client.close();
		client = null;
    }

}
