/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.camel.timer;

import org.apache.camel.main.Main;

/**
 * @author colin
 */
public class TimerApplication3 extends Main {

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TimerApplication3 timerApplication3 = new TimerApplication3();

        // register 'beans' to camel registry
        timerApplication3.bind("defaultTimeProcessor", new DefaultTimerProcessor());
        timerApplication3.bind("simpleTimeProcessor", new SimpleTimerProcessor());

        timerApplication3.addRouteBuilder(new TimerRouteBuilder());
        timerApplication3.run(args);
    }
}
