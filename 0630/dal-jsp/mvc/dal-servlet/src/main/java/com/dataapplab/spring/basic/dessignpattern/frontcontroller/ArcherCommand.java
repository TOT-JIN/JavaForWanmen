package com.dataapplab.spring.basic.dessignpattern.frontcontroller;

/**
 * 
 * Command for archers.
 *
 */
@Dalcontroller("Archer")
public class ArcherCommand implements Command {

  @Override
  public void process() {
    new ArcherView().display();
  }
}