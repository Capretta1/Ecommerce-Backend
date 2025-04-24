package org.ecommerce.ecommercebackeend.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String category, String message, Long categoryId) {
        super(message);
    }
}
