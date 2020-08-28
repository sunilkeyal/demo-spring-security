package info.keyal.demo.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

/**
 * When configuring Elasticsearch in our Java application, we need to define how we connect to the Elasticsearch instance.
 * For that, we use a RestHighLevelClient that is offered by the Elasticsearch dependency
 *
 */
@Configuration
public class ElasticConfig {

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
