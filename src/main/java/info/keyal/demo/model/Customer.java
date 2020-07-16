package info.keyal.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
