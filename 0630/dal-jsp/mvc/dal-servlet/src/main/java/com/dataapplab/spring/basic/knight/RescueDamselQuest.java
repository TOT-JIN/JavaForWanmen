package com.dataapplab.spring.basic.knight;

public class RescueDamselQuest implements Quest {
  public void embark() throws QuestException {
    System.out.println("Rescuing damsel in distress");
  }
}