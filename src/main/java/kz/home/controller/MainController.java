package kz.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index() {
        logger.debug("debug : index {}", "testing");
        logger.info("info : index {}", "testing");
        return "Greetings from spring boot";
    }
}
