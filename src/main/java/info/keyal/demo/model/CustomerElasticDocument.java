package info.keyal.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "customer")
public class CustomerElasticDocument {
    @Id
    public String id;
    public String firstName;
    public String lastName;

    public CustomerElasticDocument() {
    }

    public CustomerElasticDocument(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
