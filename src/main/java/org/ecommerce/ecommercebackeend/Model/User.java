package org.ecommerce.ecommercebackeend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User",
        uniqueConstraints = {
        //UNIQUE CONSTRAINTS FOR AVOIDING DUPLICATE USERNAME AND EMAIL IN THE DATABASE
        @UniqueConstraint(columnNames = "userName"),
         @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_ID")
    private long userID;

    @NotBlank //ADDING A VALIDATION FOR FIELD NOT TO BE BLANK
    @Size(min = 2, max = 50)//VALIDATION FOR USERNAME CHARACTER SIZE
    private String userName;

    @Email//VALIDATION FOR EMAIL
    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_ID"),
                inverseJoinColumns = @JoinColumn(name = "role_ID"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Products>products;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_address",
                joinColumns = @JoinColumn(name = "user_ID"),
                inverseJoinColumns = @JoinColumn(name = "addressID"))
    private List<Address>address;
}
