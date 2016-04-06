/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.camel.timer;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author colin
 */
public class TimerApplication {

    private static final Logger logger = LoggerFactory.getLogger(TimerApplication.class);

    public void startTimer() throws Exception {
        logger.info("Starting the timer...");

        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new TimerRouteBuilder());
        camelContext.setTracing(true);
        camelContext.start();


        // stop when ctrl-c is pressed...
        // handling graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                logger.info("Gracefully shutting down...");
                camelContext.stop();
            } catch (Exception e) {
                logger.error("{}",e);
            }
        }));

        // wait for stop
        // block main thread (to prevent it from exiting) because CamelContext#Start is non-blocking!
        while (true) {
            Thread.sleep(Long.MAX_VALUE);
        }

    }



    /**
     * Main entry
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        TimerApplication timerApplication = new TimerApplication();
        timerApplication.startTimer();
    }
}
