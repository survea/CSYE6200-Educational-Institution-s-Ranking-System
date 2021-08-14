/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employer;

import java.util.ArrayList;
import java.util.List;
import model.course.Course;

/**
 *
 * @author Hp
 */
public class Employer {
    private String name;
    private List<String> employmentCourses;

    public Employer() {
        employmentCourses = new ArrayList<>();
    }

    public Employer(String name, List<String> employmentCourses) {
        this.name = name;
        this.employmentCourses = employmentCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmploymentCourses() {
        return employmentCourses;
    }

    public void setEmploymentCourses(List<String> employmentCourses) {
        this.employmentCourses = employmentCourses;
    }

    @Override
    public String toString() {
        return "Employer{" + "name=" + name + ", employmentCourses=" + employmentCourses + '}';
    }
    
}
