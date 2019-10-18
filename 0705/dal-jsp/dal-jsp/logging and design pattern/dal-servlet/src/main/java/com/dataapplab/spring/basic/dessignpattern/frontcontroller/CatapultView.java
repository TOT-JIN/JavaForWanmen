package com.dataapplab.spring.basic.dessignpattern.frontcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * View for catapults.
 *
 */
public class CatapultView implements View {

  private static final Logger LOGGER = LoggerFactory.getLogger(CatapultView.class);

  @Override
  public void display() {
    LOGGER.info("Displaying catapults");
  }
}