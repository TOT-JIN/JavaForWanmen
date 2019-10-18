package com.dataapplab.spring.basic.dessignpattern.frontcontroller;
public class FrontcontrollerApp {

  /**
   * Program entry point
   * 
   * @param args
   *          command line args
   */
  public static void main(String[] args) {
    /*FrontController controller = new FrontController();
    controller.handleRequest("Archer");
    controller.handleRequest("Catapult");
    controller.handleRequest("foobar");*/
	  
	AnnotationFrontController controller = AnnotationFrontController.getInstance();
    controller.handleRequest("Archer");
	controller.handleRequest("Catapult");
	controller.handleRequest("foobar");	  
  }
}