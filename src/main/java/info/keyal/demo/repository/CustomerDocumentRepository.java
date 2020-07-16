package info.keyal.demo.repository;

import info.keyal.demo.model.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDocumentRepository extends MongoRepository<CustomerDocument, String> {
    CustomerDocument findByFirstName(String firstName);

    List<CustomerDocument> findByLastName(String lastName);
}
