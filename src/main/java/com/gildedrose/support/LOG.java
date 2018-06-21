package com.gildedrose.support;

public class LOG {

    public static boolean LOG_4J_CONFIGURED = false;

    public static void debug(String message) {
        if (!LOG_4J_CONFIGURED)
            throw new RuntimeException("log4j not properly configured yet");
    }
}
