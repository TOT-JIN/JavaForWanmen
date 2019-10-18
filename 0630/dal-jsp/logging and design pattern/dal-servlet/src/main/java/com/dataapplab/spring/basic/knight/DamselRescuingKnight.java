package com.dataapplab.spring.basic.knight;

public class DamselRescuingKnight implements Knight {
    private RescueDamselQuest quest;
    
    public DamselRescuingKnight() {
      // 与RescueDamselQuest耦合紧密
      quest = new RescueDamselQuest(); 
    }
    
    public void embarkOnQuest() throws QuestException {
      quest.embark();
    }
  }