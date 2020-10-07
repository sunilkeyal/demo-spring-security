package info.keyal.demo.repository;

import info.keyal.demo.model.CustomerElasticDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerElasticDocumentRepository extends ElasticsearchRepository<CustomerElasticDocument, String> {

    CustomerElasticDocument findByFirstName(String firstName);

    CustomerElasticDocument findFirstByFirstName(String firstName);

    List<CustomerElasticDocument> findByLastName(String lastName);
}
