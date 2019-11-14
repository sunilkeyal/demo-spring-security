package info.keyal.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:application-test.properties")
public class TestControllerTest {
    @Autowired
    protected TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void helloWorldTest() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(createURLWithPort("/test"), String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is("Hello World"));
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
