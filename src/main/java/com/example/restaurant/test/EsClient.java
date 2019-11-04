package com.example.restaurant.test;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-24 16:08
 **/
@Component
public class EsClient {

    @Value("${es_host}")
    public static String host;
    @Value("${es_port}")
    public static int es_port;


    public TransportClient getClient() throws UnknownHostException {
        System.out.println("---------------init es client");
        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName(host),9300    //ip
        );
        Settings setttings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("client.transport.ignore_cluster_name", true).build();  //集群名字

        TransportClient client = new PreBuiltTransportClient(setttings);
        client.addTransportAddress(node);
        return client;
    }
}
