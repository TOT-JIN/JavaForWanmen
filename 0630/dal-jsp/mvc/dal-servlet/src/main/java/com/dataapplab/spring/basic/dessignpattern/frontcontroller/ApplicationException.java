package com.dataapplab.spring.basic.dessignpattern.frontcontroller;
public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ApplicationException(Throwable cause) {
    super(cause);
  }
}