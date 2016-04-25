/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.camel.timer2;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Another Timer example but this one shows input from Timer component outputting
 * to System Out component
 *
 * @author colin
 */
public class AnotherTimerExample {

    /**
     * Main entry
     *
     * @param args
     */
    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("timer://myTimer?period=2000")
                            .setBody()
                            .simple("Hello World Camel fired at ${header.firedTime}")
                            .to("stream:out");
                }
            });

            camelContext.start();

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                camelContext.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
