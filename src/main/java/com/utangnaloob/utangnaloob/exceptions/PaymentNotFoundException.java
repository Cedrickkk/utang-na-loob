package com.utangnaloob.utangnaloob.exceptions;

public class PaymentNotFoundException extends RuntimeException {
  public PaymentNotFoundException(String message) {
    super(message);
  }
}
