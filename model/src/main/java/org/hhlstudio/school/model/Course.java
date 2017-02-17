/********************************************************************
 * File Name:    Course.java
 *
 * Date Created: Dec 29, 2016
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
@Table(name = "course")
public class Course extends CourseInfomation implements Serializable
{
  public int getCourseInfomationId()
  {
    return courseInformationId;
  }

  public void setCourseInfomationId(int courseInfomationId)
  {
    this.courseInformationId = courseInfomationId;
  }

  public int getCourseId()
  {
    return courseId;
  }

  public void setCourseId(int courseId)
  {
    this.courseId = courseId;
  }

  public int getSize()
  {
    return size;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public int getMaxSize()
  {
    return maxSize;
  }

  public void setMaxSize(int maxSize)
  {
    this.maxSize = maxSize;
  }

  public int getLevel()
  {
    return level;
  }

  public void setLevel(int level)
  {
    this.level = level;
  }

  public int getStarted()
  {
    return started;
  }

  public void setStarted(int started)
  {
    this.started = started;
  }

  public int getReservedSize()
  {
    return reservedSize;
  }

  public void setReservedSize(int reservedSize)
  {
    this.reservedSize = reservedSize;
  }

  public int getRoomId()
  {
    return roomId;
  }

  public void setRoomId(int roomId)
  {
    this.roomId = roomId;
  }

  @Column(name = "course_info_id")
  private int courseInformationId;

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int courseId;

  @Column(name = "size")
  private int size;
  @Column(name = "max_size")
  private int maxSize;
  @Column(name = "reserved_size")
  private int reservedSize;
  @Column(name = "level")
  private int level;
  @Column(name = "started")
  private int started;
  @Column(name = "room_id")
  private int roomId;
}
