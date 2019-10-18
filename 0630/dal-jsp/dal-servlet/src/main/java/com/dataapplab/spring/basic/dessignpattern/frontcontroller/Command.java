package com.dataapplab.spring.basic.dessignpattern.frontcontroller;
/**
 * 
 * Commands are the intermediary between requests and views.
 *
 */
public interface Command {

  void process();
}