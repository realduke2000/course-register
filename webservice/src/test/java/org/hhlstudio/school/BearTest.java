package org.hhlstudio.school;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

/**
 * Created by houhualong on 11/05/2017.
 */

public class BearTest
{
    @Test
    public void studentCourseMatrix() throws IOException
    {
        List<String> allStudents = getAllStudent();
        Map<String, List<String>> courses = getCourses();


        for (String stu : allStudents)
        {
            System.out.print(stu + "\t");
            for (String courseName : getAllCourseNames())
            {
                if (courses.getOrDefault(courseName, Arrays.asList()).contains(stu))
                    System.out.print("YES\t");
                else
                    System.out.print("NO\t");
            }
            System.out.println();
        }
    }

    private CourseTable createCourseTable()
    {
        CourseTable courseTable = new CourseTable();
        List<String> leftCourses = getCoursesInOneWeek();
        createClassArrangement(courseTable, leftCourses);
        return courseTable;
    }

    private void createClassArrangement(CourseTable courseTable, List<String> leftCourses)
    {
        if (leftCourses.size() == 0)
            return;
        
    }

    private List<String> getStudentSelected(String stu, Map<String, List<String>> courses)
    {
        List<String> selected = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : courses.entrySet())
        {
            entry.getValue().contains(stu);
            selected.add(entry.getKey());
        }
        return selected;
    }

    private List<String> getAllStudent()
    {
        String text = "王博\t路猷佳\t吉玥\t倪景\t吴凯\t邓雪慧\t臧英皓\t张琪\t黄子英\n" +
                "姜明宇\t王丰\t沈云珩\t纪卓君\t吴佩英\t崔菁钰\t吴若曦\t高静琪\t郭若琳\n" +
                "李子航\t黄浩然\t安鑫\t童妍\t荣艺\t范心怡\t罗曼琪\t郭思远\t段璐威\n" +
                "张笑宇\t杨舒仪\t\t张满\t张锦华\t马会行\t王潇雨\t张雨萱\t陈仕杰\n" +
                "\t翟邵彧\t\t王天旻\t巢思易\t何佳宁\t冯震\t李凌朔\t陈雨涛\n" +
                "\t王泽萁\t\t高鼎伦\t韩嘉依\t赵雅娟\t李博鸿\t\t陈蕊\n" +
                "\t全明润\t\t张运泽\t刘金若\t陈天舒\t\t\t房紫怡\n" +
                "\t李晗\t\t曹宁\t陈宝喆\t王鑫\t\t\t桂扬\n" +
                "\t孙雪莹\t\t邵春蕊\t\t曹艺馨\t\t\t张宁\n" +
                "\t葛凯迪\t\t蔡思源\t\t常耘绮\t\t\t杨兰馥\n" +
                "\t孙飞凡\t\t王子坤\t\t马苏洋\t\t\t乔宁\n" +
                "\t申睿宁\t\t陈相呈\t\t\t\t\t张伯骏\n" +
                "\t肖斌\t\t\t\t\t\t\t赵凤婕\n" +
                "\t刘天硕\t\t\t\t\t\t\t李千默\n" +
                "\t李秉杰\t\t\t\t\t\t\t李千寻\n" +
                "\t王澍\t\t\t\t\t\t\t王云铎\n" +
                "\t冯睿\t\t\t\t\t\t\t康卜文\n" +
                "\t张奥\t\t\t\t\t\t\t赵冉\n" +
                "\t胡君薇\t\t\t\t\t\t\t李仔仪\n" +
                "\t何穆荻\t\t\t\t\t\t\t毕安云凝\n" +
                "\t\t\t\t\t\t\t\t何超\n" +
                "\t\t\t\t\t\t\t\t唐嘉怿";
        List<String> allStudents = new ArrayList<>();
        for (String entry : text.replace('\n', '\t').split("\t"))
        {
            if (entry != null && !entry.trim().isEmpty())
                allStudents.add(entry.trim());
        }

        Assert.assertEquals(allStudents.size(), 91);

        return allStudents;
    }

    private Map<String, List<String>> getCourses()
    {
        String[] text = ("物理\t化学\t政治\t生物\t历史\t地理\n" +
                "王博\t王博\t黄子英\t王博\t王博\t路猷佳\n" +
                "姜明宇\t姜明宇\t郭若琳\t姜明宇\t姜明宇\t王丰\n" +
                "李子航\t李子航\t段璐威\t李子航\t李子航\t黄浩然\n" +
                "张笑宇\t张笑宇\t陈仕杰\t张笑宇\t张笑宇\t杨舒仪\n" +
                "路猷佳\t路猷佳\t陈雨涛\t路猷佳\t倪景\t翟邵彧\n" +
                "王丰\t王丰\t陈蕊\t王丰\t纪卓君\t王泽萁\n" +
                "黄浩然\t黄浩然\t房紫怡\t黄浩然\t童妍\t全明润\n" +
                "杨舒仪\t杨舒仪\t桂扬\t杨舒仪\t张满\t李晗\n" +
                "翟邵彧\t翟邵彧\t张宁\t翟邵彧\t王天旻\t孙雪莹\n" +
                "王泽萁\t王泽萁\t杨兰馥\t王泽萁\t高鼎伦\t葛凯迪\n" +
                "全明润\t全明润\t乔宁\t全明润\t张运泽\t孙飞凡\n" +
                "李晗\t李晗\t张伯骏\t李晗\t曹宁\t申睿宁\n" +
                "孙雪莹\t孙雪莹\t赵凤婕\t孙雪莹\t邵春蕊\t肖斌\n" +
                "葛凯迪\t葛凯迪\t李千默\t葛凯迪\t蔡思源\t刘天硕\n" +
                "孙飞凡\t孙飞凡\t李千寻\t孙飞凡\t王子坤\t李秉杰\n" +
                "申睿宁\t申睿宁\t王云铎\t申睿宁\t陈相呈\t王澍\n" +
                "肖斌\t肖斌\t康卜文\t肖斌\t吴凯\t冯睿\n" +
                "刘天硕\t刘天硕\t赵冉\t刘天硕\t吴佩英\t张奥\n" +
                "李秉杰\t李秉杰\t李仔仪\t李秉杰\t荣艺\t胡君薇\n" +
                "王澍\t王澍\t毕安云凝\t王澍\t张锦华\t何穆荻\n" +
                "冯睿\t冯睿\t何超\t冯睿\t巢思易\t倪景\n" +
                "张奥\t张奥\t唐嘉怿\t张奥\t韩嘉依\t纪卓君\n" +
                "胡君薇\t胡君薇\t张琪\t胡君薇\t刘金若\t童妍\n" +
                "何穆荻\t何穆荻\t高静琪\t何穆荻\t陈宝喆\t张满\n" +
                "吉玥\t吉玥\t郭思远\t吉玥\t臧英皓\t王天旻\n" +
                "沈云珩\t沈云珩\t张雨萱\t沈云珩\t吴若曦\t高鼎伦\n" +
                "安鑫\t安鑫\t李凌朔\t安鑫\t罗曼琪\t张运泽\n" +
                "倪景\t臧英皓\t邓雪慧\t臧英皓\t王潇雨\t曹宁\n" +
                "纪卓君\t吴若曦\t崔菁钰\t吴若曦\t冯震\t邵春蕊\n" +
                "童妍\t罗曼琪\t范心怡\t罗曼琪\t李博鸿\t蔡思源\n" +
                "张满\t王潇雨\t马会行\t王潇雨\t黄子英\t王子坤\n" +
                "王天旻\t冯震\t何佳宁\t冯震\t郭若琳\t陈相呈\n" +
                "高鼎伦\t李博鸿\t赵雅娟\t李博鸿\t段璐威\t邓雪慧\n" +
                "张运泽\t张琪\t陈天舒\t张琪\t陈仕杰\t崔菁钰\n" +
                "曹宁\t高静琪\t王鑫\t高静琪\t陈雨涛\t范心怡\n" +
                "邵春蕊\t郭思远\t曹艺馨\t郭思远\t陈蕊\t马会行\n" +
                "蔡思源\t张雨萱\t常耘绮\t张雨萱\t房紫怡\t何佳宁\n" +
                "王子坤\t李凌朔\t马苏洋\t李凌朔\t桂扬\t赵雅娟\n" +
                "陈相呈\t黄子英\t吴凯\t黄子英\t张宁\t陈天舒\n" +
                "吴凯\t郭若琳\t吴佩英\t郭若琳\t杨兰馥\t王鑫\n" +
                "吴佩英\t段璐威\t荣艺\t段璐威\t乔宁\t曹艺馨\n" +
                "荣艺\t陈仕杰\t张锦华\t陈仕杰\t张伯骏\t常耘绮\n" +
                "张锦华\t陈雨涛\t巢思易\t陈雨涛\t赵凤婕\t马苏洋\n" +
                "巢思易\t陈蕊\t韩嘉依\t陈蕊\t李千默\t臧英皓\n" +
                "韩嘉依\t房紫怡\t刘金若\t房紫怡\t李千寻\t吴若曦\n" +
                "刘金若\t桂扬\t陈宝喆\t桂扬\t王云铎\t罗曼琪\n" +
                "陈宝喆\t张宁\t吉玥\t张宁\t康卜文\t王潇雨\n" +
                "邓雪慧\t杨兰馥\t沈云珩\t杨兰馥\t赵冉\t冯震\n" +
                "崔菁钰\t乔宁\t安鑫\t乔宁\t李仔仪\t李博鸿\n" +
                "范心怡\t张伯骏\t\t张伯骏\t毕安云凝\t张琪\n" +
                "马会行\t赵凤婕\t\t赵凤婕\t何超\t高静琪\n" +
                "何佳宁\t李千默\t\t李千默\t唐嘉怿\t郭思远\n" +
                "赵雅娟\t李千寻\t\t李千寻\t\t张雨萱\n" +
                "陈天舒\t王云铎\t\t王云铎\t\t李凌朔\n" +
                "王鑫\t康卜文\t\t康卜文\t\t\n" +
                "曹艺馨\t赵冉\t\t赵冉\t\t\n" +
                "常耘绮\t李仔仪\t\t李仔仪\t\t\n" +
                "马苏洋\t毕安云凝\t\t毕安云凝\t\t\n" +
                "\t何超\t\t何超\t\t\n" +
                "\t唐嘉怿\t\t唐嘉怿\t\t").split("\n");
        Map<String, List<String>> courses = new HashMap<>();
        for (String courseName : text[0].split("\t"))
            courses.put(courseName, new ArrayList<>());
        for (int i = 1; i < text.length; i++)
        {
            String[] fields = text[i].split("\t", 6);
            Assert.assertEquals(fields.length, 6);
            try
            {
                if (!fields[0].trim().isEmpty())
                    courses.get("物理").add(fields[0].trim());
                if (!fields[1].trim().isEmpty())
                    courses.get("化学").add(fields[1].trim());
                if (!fields[2].trim().isEmpty())
                    courses.get("政治").add(fields[2].trim());
                if (!fields[3].trim().isEmpty())
                    courses.get("生物").add(fields[3].trim());
                if (!fields[4].trim().isEmpty())
                    courses.get("历史").add(fields[4].trim());
                if (!fields[5].trim().isEmpty())
                    courses.get("地理").add(fields[5].trim());
            } catch (Exception ex)
            {
                System.out.println(text[i]);
                System.out.println(Arrays.toString(fields));
                System.out.println(fields.length);
                throw ex;
            }
        }
        List<String> allStudents = getAllStudent();
        courses.put("物理2", new ArrayList<>());
        courses.put("化学2", new ArrayList<>());
        courses.put("政治2", new ArrayList<>());
        for (String stu : allStudents)
        {
            if (!courses.get("物理").contains(stu))
            {
                courses.get("物理2").add(stu);
            }
        }

        for (String stu : allStudents)
        {
            if (!courses.get("化学").contains(stu))
            {
                courses.get("化学2").add(stu);
            }
        }
        for (String stu : allStudents)
        {
            if (!courses.get("政治").contains(stu))
            {
                courses.get("政治2").add(stu);
            }
        }

        Assert.assertEquals(courses.get("物理").size(), 58);
        Assert.assertEquals(courses.get("物理2").size(), allStudents.size() - 58);
        Assert.assertEquals(courses.get("化学").size(), 60);
        Assert.assertEquals(courses.get("化学2").size(), allStudents.size() - 60);
        Assert.assertEquals(courses.get("政治").size(), 49);
        Assert.assertEquals(courses.get("政治2").size(), allStudents.size() - 49);
        Assert.assertEquals(courses.get("生物").size(), 60);
        Assert.assertEquals(courses.get("历史").size(), 52);
        Assert.assertEquals(courses.get("地理").size(), 54);

        return courses;
    }

    private static final int MAX_CLASS_ROMM = 4;

    private static final int MAX_STUDENT_PER_CLASS = 25;

    private List<String> getCoursesInOneWeek()
    {
        List<String> allCourseNames = getAllCourseNames();
        for (String course : getAllCourseNames())
        {
            int leftCourseTimes = getCourseTimes(course) - 1;
            for (int i = 0; i < leftCourseTimes; i++)
            {
                allCourseNames.add(course);
            }
        }
        return allCourseNames;
    }

    private List<String> getAllCourseNames()
    {
        /**
         * "物理", "物理2", "化学", "化学2", "政治", "政治2", "生物", "历史", "地理"
         *    3       2      3        2      3      2        1      1       1
         */
        return Arrays.asList("物理", "物理2", "化学", "化学2", "政治", "政治2", "生物", "历史", "地理");
    }

    private int getCourseTimes(String courseName)
    {
        switch (courseName)
        {
            case "物理":
            case "化学":
            case "政治":
                return 3;
            case "物理2":
            case "化学2":
            case "政治2":
                return 2;
            case "生物":
            case "历史":
            case "地理":
                return 1;
            default:
                throw new IllegalArgumentException(courseName);
        }
    }
}