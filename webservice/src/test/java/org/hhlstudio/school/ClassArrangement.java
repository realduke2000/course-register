package org.hhlstudio.school;

/**
 * Created by houhualong on 17/05/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * class arragement in one time slot
 */
public class ClassArrangement
{
    private int timeSlot;
    private List<ClassRoomArrangement> classRoomArrangement;
    public ClassArrangement()
    {
        classRoomArrangement = new ArrayList<>();
        timeSlot = 0;
    }

    public int getTimeSlot()
    {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot)
    {
        this.timeSlot = timeSlot;
    }

    public List<ClassRoomArrangement> getClassRoomArrangement()
    {
        return classRoomArrangement;
    }

    public void setClassRoomArrangement(List<ClassRoomArrangement> classRoomArrangement)
    {
        this.classRoomArrangement = classRoomArrangement;
    }
}
