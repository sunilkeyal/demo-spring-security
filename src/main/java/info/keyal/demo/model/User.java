package info.keyal.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Demo User Object
 *
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "demo_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<Role> roles;
}
