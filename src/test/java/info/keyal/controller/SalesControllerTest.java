package info.keyal.controller;

import info.keyal.demo.controller.SalesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SalesController.class})
public class SalesControllerTest {

    @LocalServerPort
    int randomServerPort;

    // TODO implement this test
    @Test
    public void testGetTotalPrice() throws Exception {

    }
}
