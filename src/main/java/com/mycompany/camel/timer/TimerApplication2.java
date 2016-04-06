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
public class TimerApplication2 extends Main {

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TimerApplication2 timerApplication2 = new TimerApplication2();
        timerApplication2.addRouteBuilder(new TimerRouteBuilder());
        timerApplication2.run(args);
    }
}
