package dev.jafarzade.democity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    Logger a = LoggerFactory.getLogger(HttpRequestTest.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    // TODO deserialize and assert
    // TODO add parameters separately

    @Test
    public void fidnByNameIgnoreCaseShouldReturnCity() throws Exception {

        String res = restTemplate.getForObject("http://localhost:" + port + "/cities/search/nameContains?q=hA",
                String.class);

        assertThat(res).contains("\"name\" : \"Shanghai\"");
        assertThat(res).contains("\"latitude\" : \"31.21650\"");
        assertThat(res).contains("\"longitude\" : \"121.43650\"");
        assertThat(res).contains("\"country\" : \"China\"");
        assertThat(res).contains("\"population\" : 12797394");
    }

    @Test
    public void findByCountryIgnoreCaseShouldReturn() throws Exception {

        String res = restTemplate.getForObject("http://localhost:" + port + "/cities/search/country?q=United States",
                String.class);

        assertThat(res).contains("\"name\" : \"Los Angeles\"");
        assertThat(res).contains("\"name\" : \"New York\"");
    }
}