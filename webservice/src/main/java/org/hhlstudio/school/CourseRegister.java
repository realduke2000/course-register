/********************************************************************
 * File Name:    CourseRegister.java
 *
 * Date Created: Dec 28, 2016
 *
 * ------------------------------------------------------------------
 * Copyright (c) 2016 Veritas Technologies LLC. All rights reserved.
 *
 *******************************************************************/
package org.hhlstudio.school;

import java.util.List;

import org.hhlstudio.school.model.Course;
import org.hhlstudio.school.model.CourseInfomation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseRegister
{
  public boolean registerLeveledCourse(int studentId, int courseId)
  {
    final int COURSE_WEIGHT = 1; // max upper/lower level course
    final int studentCourseLevel = courseProvider.getStudentCourseLevel(studentId, courseId);
    List<Course> unfullfilledLeveledCourses = courseProvider.getUnfilledLeveledCourse(courseId);

    if (unfullfilledLeveledCourses.size() < 1)
    {
      logger.warn("All course({}) has been full filled while student({}) register...", courseId, studentId);
      return false;
    }

    // first priority, course level matched
    Course leveledCourse = findLevelMatchedCourse(studentCourseLevel, unfullfilledLeveledCourses);

    // second priority, find nearest un reserved level course
    if (leveledCourse == null)
    {
      leveledCourse = findNearestLevelCourse(unfullfilledLeveledCourses, studentCourseLevel, COURSE_WEIGHT, false);
    }

    // third priority, find nearest unfullfilled course
    if (leveledCourse == null)
    {
      leveledCourse = findNearestLevelCourse(unfullfilledLeveledCourses, studentCourseLevel, COURSE_WEIGHT, true);
    }

    if (leveledCourse == null)
    {
      logger.warn("No matched course({}) for student({})", courseId, studentId);
      return false;
    }

    courseProvider.addCourseRegistration(studentId, leveledCourse);
    return true;
  }

  public boolean cancelRegisteredCourse(int studentId, int courseId)
  {
    List<CourseInfomation> registeredCourseInfomation = courseProvider.getRegisteredCourses(studentId);
    if (registeredCourseInfomation.stream().anyMatch(courseInfomation -> courseId == courseInfomation.getCourseInfomationId()))
    {
      logger.info("CourseInfomation {} has been registered by student {}", courseId, studentId);
      return true;
    }
    courseProvider.removeCourseRegistration(studentId, courseId);
    return true;
  }

  private Course findNearestLevelCourse(List<Course> unfullfilledLeveledCourse, int studentCourseLevel,
      int courseWeight, boolean occupyReservedSeat)
  {
    Course leveledCourse = null;
    for (int i = 1; i <= courseWeight; i++)
    {
      final int weight = i;
      // find a upper level course first
      leveledCourse = unfullfilledLeveledCourse.stream()
          .filter(lc -> (studentCourseLevel - weight == studentCourseLevel)
              && (occupyReservedSeat || lc.getSize() < lc.getReservedSize()))
          .findFirst().orElse(null);
      if (null != leveledCourse)
      {
        break;
      }

      // find a lower level course
      leveledCourse = unfullfilledLeveledCourse.stream()
          .filter(lc -> (studentCourseLevel + weight == studentCourseLevel)
              && (occupyReservedSeat || lc.getSize() < lc.getReservedSize() ))
          .findFirst().orElse(null);
      if (null != leveledCourse)
      {
        break;
      }
    }
    return leveledCourse;
  }

  /**
   * Find the leveled course matched level of student
   * @param studentCourseLevel
   * @param unfullfilledLeveledCourse
   * @return
   */
  private Course findLevelMatchedCourse(int studentCourseLevel, List<Course> unfullfilledLeveledCourse)
  {
    return unfullfilledLeveledCourse.stream()
        .filter(lc -> lc.getLevel() == studentCourseLevel)
        .findFirst().orElse(null);
  }

  @Autowired
  private CourseProvider courseProvider;

  private static Logger logger = LoggerFactory.getLogger(CourseRegister.class);
}
