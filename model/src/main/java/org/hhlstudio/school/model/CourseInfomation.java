/********************************************************************
 * File Name:    CourseInfomation.java
 *
 * Date Created: Dec 28, 2016
 *
 * ------------------------------------------------------------------
 *
 *******************************************************************/
package org.hhlstudio.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "course_info")
public class CourseInfomation implements Serializable
{

  public String getCourseName()
  {
    return courseName;
  }

  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
  }


  public int getCourseInfomationId()
  {
    return courseInfomationId;
  }

  public void setCourseInfomationId(int courseInfomationId)
  {
    this.courseInfomationId = courseInfomationId;
  }


  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "id")
  private int courseInfomationId;

  @Column(name = "name")
  private String courseName;
}
