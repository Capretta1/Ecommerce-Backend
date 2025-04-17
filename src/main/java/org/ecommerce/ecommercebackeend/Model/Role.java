package org.ecommerce.ecommercebackeend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_ID")
    private long roleID;

    @Column(length = 20, name = "role")
    @Enumerated(EnumType.STRING)
    private AppRole role;

}
