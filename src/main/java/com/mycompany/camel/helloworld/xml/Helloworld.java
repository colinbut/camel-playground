/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.camel.helloworld.xml;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Camel Hello World in Spring XML configuration
 *
 * @author colin
 */
public class Helloworld {

    /**
     * Main entry
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext =
                new FileSystemXmlApplicationContext("src/main/resources/META-INF/applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(applicationContext, false);

        try {
            ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
            camelContext.start();
            producerTemplate.sendBody("activemq:test.queue", "Hello World!");
        } finally {
            camelContext.stop();
        }


    }
}
