package org.ecommerce.ecommercebackeend.Password;



import org.ecommerce.ecommercebackeend.Exception.WrongPasswordException;
import org.ecommerce.ecommercebackeend.Model.User;
import org.ecommerce.ecommercebackeend.Repository.UserRepository;
import org.ecommerce.ecommercebackeend.Request.ChangePasswordRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangePassword {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public ChangePassword(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }


    public void changePassword(ChangePasswordRequest request){
        Optional<User> user1 = userRepository.findByEmailIgnoreCase(request.getEmail());

        if (user1.isPresent()) {
            User user = user1.get();

            if (passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(request.getNewPassword()));
                userRepository.save(user);
            } else {
                throw new WrongPasswordException("Wrong Password");
            }
        }else {
            throw new UsernameNotFoundException("User Not Found");
        }

    }
}
