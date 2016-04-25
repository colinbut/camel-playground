/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.camel.helloworld.dsl;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Camel Hello world using Java DSL
 *
 * @author colin
 */
public class Helloworld {

    private static final String ACTIVEMQ_BROKER_URL = "vm:localhost?broker.persistent=false";

    /**
     * Main entry
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addComponent("activemq", ActiveMQComponent.activeMQComponent(ACTIVEMQ_BROKER_URL));
        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("activemq:queue:test.queue")
                            .to("stream:out");
                }
            });

            ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
            camelContext.start();

            producerTemplate.sendBody("activemq:queue:test.queue", "Hello World");

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            camelContext.stop();
        }



    }
}
