/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;

import java.util.ArrayList;
import java.util.List;
import model.course.Course;
import model.course.CourseCatalog;
import model.department.Department;

/**
 *
 * @author Hp
 */
public class Faculty extends Person {

    private CourseCatalog courseList;
    private double rating;
    private String position;
    private List<Integer> allRatings;
    ArrayList <FacultyAssignment> facultyAssignments;
    private double salary;

    public Faculty(Department department) {
        allRatings = new ArrayList<>();
        courseList = new CourseCatalog(department);
    }

    
    public Faculty(CourseCatalog course, List<Integer> allRating, int id, String firstName, String lastName, int age, double salary) {
    super(id, firstName, lastName, age);
        this.courseList = course;
        this.salary = salary;
        this.allRatings = allRating;
    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Integer> getAllRatings() {
        return allRatings;
    }

    public void setAllRatings(List<Integer> allRatings) {
        this.allRatings = allRatings;
    }

    public CourseCatalog getCourseList() {
        return courseList;
    }

    public void setCourseList(CourseCatalog courseList) {
        this.courseList = courseList;
    }

    public ArrayList<FacultyAssignment> getFacultyAssignments() {
        return facultyAssignments;
    }

    public void setFacultyassignments(ArrayList<FacultyAssignment> facultyAssignments) {
        this.facultyAssignments = facultyAssignments;
    }
    
    public void addNewRating(int newRating) {
        this.allRatings.add(newRating);
    }
    public void addNewCourse(Course course) {
        this.courseList.addCourse(course);
    }
    public void calcRating() {
//        int sum = allRatings.stream().mapToInt(Integer::intValue).sum();
        int sum = 0;
    for (int i: allRatings) {
        sum += i;
    }
        setRating(sum/allRatings.size());
    }
}
