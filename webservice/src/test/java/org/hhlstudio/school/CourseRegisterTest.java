package org.hhlstudio.school;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hhlstudio.school.model.CourseInfomation;
import org.testng.annotations.Test;

/********************************************************************
 * File Name:    CourseRegisterTest.java
 *
 * Date Created: Jan 03, 2017
 *
 * ------------------------------------------------------------------
 * Copyright (c) 2016 Veritas Technologies LLC. All rights reserved.
 *
 *******************************************************************/
public class CourseRegisterTest
{
  @Test
  public void testdb() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException
  {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hhlstudio.school.model");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<CourseInfomation> resultList = entityManager.createQuery("FROM CourseInfomation", CourseInfomation.class).getResultList();
    for (CourseInfomation ci : resultList)
    {
      System.out.println(ci.getCourseName());
    }
    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}
