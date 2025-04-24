package org.ecommerce.ecommercebackeend.Request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {

    private String email;
    private String oldPassword;
    private String newPassword;
}
