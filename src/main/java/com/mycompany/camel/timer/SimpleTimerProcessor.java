/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.camel.timer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author colin
 */
public class SimpleTimerProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTimerProcessor.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("Exchange's from route id:" + exchange.getFromRouteId());
    }
}
