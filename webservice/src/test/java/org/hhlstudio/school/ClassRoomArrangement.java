package org.hhlstudio.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houhualong on 17/05/2017.
 */

/**
 * One class room arrangement
 */
public class ClassRoomArrangement
{
    public ClassRoomArrangement()
    {
        courseName = null;
        students = new ArrayList<>();
    }

    public ClassRoomArrangement(String courseName)
    {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    private String courseName;

    private List<String> students;

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public List<String> getStudents()
    {
        return students;
    }

    public void setStudents(List<String> students)
    {
        this.students = students;
    }
}
