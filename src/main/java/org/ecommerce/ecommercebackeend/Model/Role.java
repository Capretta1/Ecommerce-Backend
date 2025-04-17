package org.ecommerce.ecommercebackeend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_ID")
    private long userID;

    @Column(length = 20, name = "role")
    @Enumerated(EnumType.STRING)
    private AppRole role;

}
