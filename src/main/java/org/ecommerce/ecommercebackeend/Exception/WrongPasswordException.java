package org.ecommerce.ecommercebackeend.Exception;

public class WrongPasswordException extends RuntimeException {
  public WrongPasswordException(String message) {
    super(message);
  }
}
