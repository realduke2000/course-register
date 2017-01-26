/********************************************************************
 * File Name:    CourseRegistion.java
 *
 * Date Created: Jan 11, 2017
 *
 * ------------------------------------------------------------------
 * Copyright (c) 2016 Veritas Technologies LLC. All rights reserved.
 *
 *******************************************************************/
package org.hhlstudio.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_selected_course")
public class CourseRegistion implements Serializable
{
  @Column(name = "student_id")
  private int studentId;

  @Column(name = "leveled_course_id")
  private int courseId;

  public int getStudentId()
  {
    return studentId;
  }

  public void setStudentId(int studentId)
  {
    this.studentId = studentId;
  }

  public int getCourseId()
  {
    return courseId;
  }

  public void setCourseId(int courseId)
  {
    this.courseId = courseId;
  }
}
