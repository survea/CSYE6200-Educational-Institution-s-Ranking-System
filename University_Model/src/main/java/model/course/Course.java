/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp
 */
public class Course {

    private String courseCode;
    private String courseName;
    private String courseDescription;
    private int credits;
    private double courseRating;
    private List<String> courseContentList;
    private double ratingPercent;

    public Course() {
    }

    public Course(String courseCode, String courseName, String courseDescription, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.credits = credits;
        courseContentList = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }

    public List<String> getCourseContentList() {
        return courseContentList;
    }

    public void setCourseContentList(List<String> courseContentList) {
        this.courseContentList = courseContentList;
    }

    public double getRatingPercent() {
        return ratingPercent;
    }

    public void setRatingPercent(double ratingPercent) {
        this.ratingPercent = ratingPercent;
    }

    public List<String> addCourseContent(String courseContent) {
        courseContentList.add(courseContent);
        return courseContentList;
    }

//    public double calculateRatingPercent(int employerCount) {
//        setRatingPercent((getCourseRating() / employerCount) * 100);
//        return ratingPercent;
//    }

    @Override
    public String toString() {
        return courseCode;
    }

}
