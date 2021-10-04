/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

import java.util.ArrayList;
import java.util.List;
import model.department.Department;

/**
 *
 * @author DikshaGodse
 */
public class CourseCatalog {
    private Department department;
    private List<Course> courseList;

    public CourseCatalog(Department department) {
        courseList = new ArrayList<>();
        this.department = department;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    
    public void addCourse(Course course) {
        courseList.add(course);
    };

    @Override
    public String toString() {
        return "CourseCatalog{" + courseList +"}";
    }
    
}
