package com.truemeds.testanurag.controller;

import com.truemeds.testanurag.service.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
final class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    private static final String RESPONSE_STRING = "request processed";
    private final BatchService service;

    BaseController(BatchService service) {
        this.service = service;
    }

    @PostMapping(value="/reduceStrings")
    public String reduceString() {
        LOGGER.debug("Received request to trigger cleanup");
        service.doCleanup();
        return RESPONSE_STRING;
    }
    
}
