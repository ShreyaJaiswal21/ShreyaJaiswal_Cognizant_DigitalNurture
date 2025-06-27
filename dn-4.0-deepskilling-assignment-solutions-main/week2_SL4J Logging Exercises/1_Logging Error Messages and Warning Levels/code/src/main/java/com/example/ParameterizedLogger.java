package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogger {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogger.class);

    public static void main(String[] args) {
        String user = "Shreya";
        int tasks = 5;

        logger.info("User {} has {} pending tasks.", user, tasks);
        logger.debug("Debug message with values: user={}, tasks={}", user, tasks);
    }
}


