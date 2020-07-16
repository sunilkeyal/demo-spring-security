package info.keyal.demo.model;

import org.springframework.data.annotation.Id;

public class CustomerDocument {
    @Id
    public String id;
    public String firstName;
    public String lastName;

    public CustomerDocument() {
    }

    public CustomerDocument(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "CustomerDocument[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
