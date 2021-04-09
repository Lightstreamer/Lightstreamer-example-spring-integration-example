package com.lightstreamer.examples.spring.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

  private static ApplicationContext context =
      new ClassPathXmlApplicationContext("sample_config.xml");

  public static <T> T getBean(String beanName, Class<T> type) {
    return context.getBean(beanName, type);
  }
}
