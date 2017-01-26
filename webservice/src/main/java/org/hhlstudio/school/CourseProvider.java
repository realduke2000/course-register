/********************************************************************
 * File Name:    CourseProvider.java
 *
 * Date Created: Dec 29, 2016
 *
 * ------------------------------------------------------------------
 * Copyright (c) 2016 Veritas Technologies LLC. All rights reserved.
 *
 *******************************************************************/
package org.hhlstudio.school;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hhlstudio.school.model.Course;
import org.hhlstudio.school.model.CourseInfomation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseProvider
{

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  @Autowired
  private EntityManager entityManager;

  public List<CourseInfomation> getRegisteredCourses(int studentId)
  {
    return null;
  }

  public int getStudentCourseLevel(int studentId, int courseId)
  {
    // null or empty throws exception
    return 0;
  }

  public List<Course> getUnfilledLeveledCourse(int courseId)
  {
    // null or empty throws exception
    List<Course> resultList = entityManager.createQuery("FROM Course", Course.class).getResultList();
    for (Course ci : resultList)
    {
      System.out.println(ci.getCourseName());
    }
    return resultList;
  }

  public void addCourseRegistration(int studentId, Course leveledCourse)
  {
  }

  public void removeCourseRegistration(int studentId, int courseId)
  {

  }
}
