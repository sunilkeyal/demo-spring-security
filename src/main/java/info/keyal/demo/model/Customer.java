package info.keyal.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Demo Customer object
 *
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "demo_customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(max = 20)
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @Size(max = 20)
    private String lastName;

    private String phone;

    @Email(message = "Invalid email address")
    private String email;

    @Size(max = 20)
    private String status;
}
