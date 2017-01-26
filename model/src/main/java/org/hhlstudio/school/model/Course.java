/********************************************************************
 * File Name:    LeveledCourse.java
 *
 * Date Created: Dec 29, 2016
 *
 * ------------------------------------------------------------------
 * Copyright (c) 2016 Veritas Technologies LLC. All rights reserved.
 *
 *******************************************************************/
package org.hhlstudio.school.model;

import java.io.Serializable;

public class LeveledCourse extends Course implements Serializable
{
  public int getCourseId()
  {
    return courseId;
  }

  public void setCourseId(int courseId)
  {
    this.courseId = courseId;
  }

  public int getLeveledCourseId()
  {
    return leveledCourseId;
  }

  public void setLeveledCourseId(int leveledCourseId)
  {
    this.leveledCourseId = leveledCourseId;
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

  private int courseId;
  private int leveledCourseId;
  private int size;
  private int maxSize;
  private int reservedSize;
  private int level;
  private int started;
}
