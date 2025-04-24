package org.ecommerce.ecommercebackeend.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Long ID;
    private String jwtToken;
    private String username;
    private List<String> roles;


    public LoginResponse(Long id, String username, List<String> roles, String jwtToken) {
    }
}