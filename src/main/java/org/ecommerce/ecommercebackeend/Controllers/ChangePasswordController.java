package org.ecommerce.ecommercebackeend.Controllers;


import jakarta.validation.Valid;
import org.ecommerce.ecommercebackeend.Exception.WrongPasswordException;
import org.ecommerce.ecommercebackeend.Password.ChangePassword;
import org.ecommerce.ecommercebackeend.Request.ChangePasswordRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/change")
public class ChangePasswordController {

    private final ChangePassword changePassword;

    public ChangePasswordController(ChangePassword changePassword) {
        this.changePassword = changePassword;
    }

    @PutMapping("/password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest){
        try {
            changePassword.changePassword(changePasswordRequest);
            Map<String, String> success = new HashMap<>();
            success.put("message", "Password Changed Successfully");
            return new ResponseEntity<>(success, HttpStatus.OK);
        }catch (WrongPasswordException e){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "WrongPassword");
            return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
        }
    }
}
