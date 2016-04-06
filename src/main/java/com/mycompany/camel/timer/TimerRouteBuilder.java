/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.camel.timer;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author colin
 */
public class TimerRouteBuilder extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(TimerRouteBuilder.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure() throws Exception {
        logger.info("Configuring the route");
        from("timer://timer1?period=1000")
                .to("bean:defaultTimeProcessor")
                .to("bean:simpleTimeProcessor");
    }
}
