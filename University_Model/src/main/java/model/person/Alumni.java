/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.course.Course;
import model.course.CourseCatalog;
import model.department.Department;
import model.person.alumniEmployment.EmploymentHistory;

/**
 *
 * @author Hp
 */
public class Alumni extends Student {

    private CourseCatalog courseCatalog;
    private String employer;
    private List<EmploymentHistory> employmentHistory;
    private double Salary;
    private String jobPostion;
    private double employmentRating;
    private double employmentRatingPercent;
    private Date graduationYear;

    public Alumni(Department department) {
        courseCatalog = new CourseCatalog(department);
        employmentHistory = new ArrayList<>();
    }

    public Alumni(String employer, List<EmploymentHistory> employmentHistory, CourseCatalog course, double gpa, int id, String firstName, String lastName, int age, double salary, String jobPostion) {
        super(gpa, id, firstName, lastName, age);
        this.courseCatalog = course;
        this.employer = employer;
        this.employmentHistory = employmentHistory;
        this.Salary = salary;
        this.jobPostion = jobPostion;
        calcEmploymentRating();
    }

//    public Alumni() {
//    }
    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public List<EmploymentHistory> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(List<EmploymentHistory> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public CourseCatalog addCourse(Course course) {
        courseCatalog.addCourse(course);
        return courseCatalog;
    }

    public CourseCatalog getCourseCatalog() {
        return courseCatalog;
    }

    public void setCourseCatalog(CourseCatalog courseCatalog) {
        this.courseCatalog = courseCatalog;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getJobPostion() {
        return jobPostion;
    }

    public void setJobPostion(String jobPostion) {
        this.jobPostion = jobPostion;
    }

    public double getEmploymentRating() {
        return employmentRating;
    }

    public void setEmploymentRating(double employmentRating) {
        this.employmentRating = employmentRating;
    }

    public double getEmploymentRatingPercent() {
        return employmentRatingPercent;
    }

    public void setEmploymentRatingPercent(double employmentRatingPercent) {
        this.employmentRatingPercent = employmentRatingPercent;
    }

    public void addEmploymentHistory(EmploymentHistory employmentHistory) {
        this.employmentHistory.add(employmentHistory);
    }

    public Date getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Date graduationYear) {
        this.graduationYear = graduationYear;
    }

    public double calcEmploymentRating() {
        if (getSalary() > 0 && getSalary() <= 50000) {
            setEmploymentRating(getEmploymentRating() + 0.3);
        } else if (getSalary() > 50000 && getSalary() < 100000) {
            setEmploymentRating(getEmploymentRating() + 0.6);
        } else if (getSalary() > 100000) {
            setEmploymentRating(getEmploymentRating() + 1);
        } else {
            setEmploymentRating(getEmploymentRating() + 0);
        }
        if (null != getJobPostion()) {
            switch (getJobPostion()) {
                case "Associate":
                    setEmploymentRating(getEmploymentRating() + 0.2);
                    break;
                case "Senior":
                    setEmploymentRating(getEmploymentRating() + 0.4);
                    break;
                case "Lead":
                    setEmploymentRating(getEmploymentRating() + 0.6);
                    break;
                case "Manager":
                    setEmploymentRating(getEmploymentRating() + 0.8);
                    break;
                case "Higher":
                    setEmploymentRating(getEmploymentRating() + 1);
                    break;
                default:
                    break;
            }
        }
        return calculateEmploymentRatingPercent();
    }

    @Override
    public String toString() {
        return  super.getFirstName() + " " + super.getLastName();
    }

    private double calculateEmploymentRatingPercent() {
        setEmploymentRatingPercent((getEmploymentRating() * 100) / 2); // deviding by 2 because rating is based on salary and position;
        return getEmploymentRatingPercent();
    }

}
