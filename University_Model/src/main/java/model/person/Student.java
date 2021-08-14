/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;

import java.util.List;
import model.course.Course;
import model.course.CourseCatalog;
import model.department.Department;

/**
 *
 * @author Hp
 */
public class Student extends Person {

    private CourseCatalog courseCatalog;
    private double gpa;
    Department department;

    public Student() {
        courseCatalog = new CourseCatalog(department);
    }

    public Student(double gpa, int id, String firstName, String lastName, int age) {
        super(id, firstName, lastName, age);
        courseCatalog = new CourseCatalog(department);

        this.gpa = gpa;
    }

    public CourseCatalog getCourseCatalog() {
        return courseCatalog;
    }

    public void setCourseCatalog(CourseCatalog courseCatalog) {
        this.courseCatalog = courseCatalog;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void addStudentCourse(Course course) {
        courseCatalog.addCourse(course);
    }

    @Override
    public String toString() {
        return "Student{" + "id " + super.getId() + ", first name " + super.getFirstName() + ", last name " + super.getLastName() + ", course=" + courseCatalog + ", gpa=" + gpa + '}';
    }

}
