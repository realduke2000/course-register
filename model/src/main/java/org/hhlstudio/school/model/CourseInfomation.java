/********************************************************************
 * File Name:    Course.java
 *
 * Date Created: Dec 28, 2016
 *
 * ------------------------------------------------------------------
 * Copyright (c) 2016 Veritas Technologies LLC. All rights reserved.
 *
 *******************************************************************/
package org.hhlstudio.school.model;

import java.io.Serializable;

public class Course implements Serializable
{
  public String getCourseName()
  {
    return courseName;
  }

  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
  }

  public int getCourseId()
  {
    return courseId;
  }

  public void setCourseId(int courseId)
  {
    this.courseId = courseId;
  }

  private int courseId;
  private String courseName;
}
