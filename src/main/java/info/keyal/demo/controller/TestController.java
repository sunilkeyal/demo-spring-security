package info.keyal.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test Controller
 */
@RestController
@CrossOrigin
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    /**
     * Test hello world method
     *
     * @return Hello World
     */
    @GetMapping(path = "/test")
    public @ResponseBody
    ResponseEntity<String> helloWorld() {
        LOGGER.info("hello world called");
        return ResponseEntity.ok("Hello World");
    }
}
