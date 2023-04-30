//package info.keyal.demo.controller;
//
//import info.keyal.demo.model.Customer;
////import org.junit.Ignore;
////import org.junit.Test;
////import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.*;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static info.keyal.demo.util.CustomerHelper.getCustomer;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.MatcherAssert.assertThat;
//
////@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:application-test.properties")
////@Ignore
//public class CustomerControllerTest {
//
//    @Autowired
//    protected TestRestTemplate restTemplate;
//
//    @LocalServerPort
//    private int port;
//
////    @Test
//    public void createCustomerTest() throws Exception {
//        Customer customer = getCustomer("Sunil", "Keyal", "9199248857", "sunilkeyal@hotmail.com");
//        ResponseEntity<Customer> response = restTemplate.withBasicAuth("admin", "password").exchange(createURLWithPort("/customers"), HttpMethod.POST, new HttpEntity<>(customer, new HttpHeaders()), Customer.class);
//        assertThat(response.getStatusCode(), is(HttpStatus.OK));
//        assertThat(response.getBody(), is(notNullValue()));
//        assertThat(response.getBody().getId(), is(notNullValue()));
//        assertThat(response.getBody().getFirstName(), is("Sunil"));
//        assertThat(response.getBody().getLastName(), is("Keyal"));
//        assertThat(response.getBody().getEmail(), is("sunilkeyal@hotmail.com"));
//        assertThat(response.getBody().getPhone(), is("9199248857"));
//    }
//
////    @Test
//    public void getAllCustomerTest() throws Exception {
//        Customer customer = getCustomer("Sunil", "Keyal", "9199248857", "sunilkeyal@hotmail.com");
//        restTemplate.withBasicAuth("admin", "password").exchange(createURLWithPort("/customers"), HttpMethod.POST, new HttpEntity<>(customer, new HttpHeaders()), Customer.class);
//
//        ParameterizedTypeReference<List<Customer>> responseType = new ParameterizedTypeReference<List<Customer>>() {
//        };
//        ResponseEntity<List<Customer>> response = restTemplate.withBasicAuth("admin", "password").exchange(createURLWithPort("/customers"), HttpMethod.GET, null, responseType);
//
//        assertThat(response.getStatusCode(), is(HttpStatus.OK));
//        assertThat(response.getBody().get(0), is(notNullValue()));
//        assertThat(response.getBody().get(0).getId(), is(notNullValue()));
//        assertThat(response.getBody().get(0).getFirstName(), is("Sunil"));
//        assertThat(response.getBody().get(0).getLastName(), is("Keyal"));
//        assertThat(response.getBody().get(0).getEmail(), is("sunilkeyal@hotmail.com"));
//        assertThat(response.getBody().get(0).getPhone(), is("9199248857"));
//
//    }
//
//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }
//}
