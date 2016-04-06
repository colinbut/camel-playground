package com.mycompany.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception {

        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:data/inbox")
                        .to("file:data/outbox");
            }
        });

        camelContext.start();

        Thread.sleep(3000);

        camelContext.stop();

    }
}
