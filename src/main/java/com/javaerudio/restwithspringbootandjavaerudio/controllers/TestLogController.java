package com.javaerudio.restwithspringbootandjavaerudio.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/v1")
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class);

    @GetMapping()
    public String testLog() {
        logger.debug("This is a debug message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "Logs generated successfully";
    }
}
