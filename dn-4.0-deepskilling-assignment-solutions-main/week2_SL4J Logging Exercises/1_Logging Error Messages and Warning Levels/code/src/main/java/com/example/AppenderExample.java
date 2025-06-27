package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.info("This message goes to both console and file!");
        logger.warn("Warning message logged to file and console.");
        logger.error("Critical error happened in the system!");
    }
}

