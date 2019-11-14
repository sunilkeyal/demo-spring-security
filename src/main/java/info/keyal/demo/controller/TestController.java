package info.keyal.demo.controller;

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

    /**
     * Test hello world method
     *
     * @return Hello World
     */
    @GetMapping(path = "/test")
    public @ResponseBody
    ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }
}
