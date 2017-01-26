/********************************************************************
 * File Name:    AppConfiguration.java
 *
 * Date Created: Jan 25, 2017
 *
 * ------------------------------------------------------------------
 * Copyright (c) 2016 Veritas Technologies LLC. All rights reserved.
 *
 *******************************************************************/
package org.hhlstudio.school;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration
{
  @Bean
  public EntityManagerFactory entityManagerFactory()
  {
    return Persistence.createEntityManagerFactory("org.hhlstudio.school.model");
  }

  @Bean
  public EntityManager entityManager()
  {
    return entityManagerFactory().createEntityManager();
  }
}
