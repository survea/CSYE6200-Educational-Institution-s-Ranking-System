/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.department;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import model.course.Course;
import model.course.CourseCatalog;
import model.employer.Employer;
import model.person.Alumni;
import model.person.AlumniDirectory;
import model.person.Faculty;
import model.person.FacultyDirectory;
import model.person.Student;
import model.person.StudentDirectory;

/**
 *
 * @author Hp
 */
public class Department {
    
    private String departmentName;
    private CourseCatalog courseList;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    AlumniDirectory alumniDirectory;
    public List<Employer> employerList;
    
    public Department(String deptName) {
        departmentName = deptName;
        courseList = new CourseCatalog(this);
        employerList = new ArrayList<>();
        alumniDirectory = new AlumniDirectory(this);
        studentdirectory = new StudentDirectory(this);
        facultydirectory = new FacultyDirectory(this);
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public CourseCatalog getCourseList() {
        return courseList;
    }
    
    public void setCourseList(CourseCatalog courseList) {
        this.courseList = courseList;
    }
    
    public StudentDirectory getStudentdirectory() {
        return studentdirectory;
    }
    
    public void setStudentdirectory(StudentDirectory studentdirectory) {
        this.studentdirectory = studentdirectory;
    }
    
    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }
    
    public void setFacultydirectory(FacultyDirectory facultydirectory) {
        this.facultydirectory = facultydirectory;
    }
    
    public List<Employer> getEmployerList() {
        return employerList;
    }
    
    public void setEmployerList(List<Employer> employerList) {
        this.employerList = employerList;
    }
    
    public AlumniDirectory getAlumniDirectory() {
        return alumniDirectory;
    }
    
    public void setAlumniDirectory(AlumniDirectory alumniDirectory) {
        this.alumniDirectory = alumniDirectory;
    }
    
    public CourseCatalog addCourse(Course course) {
        courseList.addCourse(course);
        return courseList;
    }
    
    public List<Employer> addEmployer(Employer employer) {
        employerList.add(employer);
        return employerList;
    }
    
    public AlumniDirectory addAlumni(Alumni alumni) {
        alumniDirectory.addAlumni(alumni);
        return alumniDirectory;
    }
    
    public StudentDirectory addStudent(Student student) {
        studentdirectory.addStudent(student);
        return studentdirectory;
    }
    
    public FacultyDirectory addFaculty(Faculty faculty) {
        facultydirectory.newFacultyProfile(faculty);
        return facultydirectory;
    }
    
    public void calculateCourseRatingPercent() {
        int courseAlumniCount = 0;
        for (Course course : courseList.getCourseList()) {
            for (Alumni alumni : alumniDirectory.getAlumniDir()) {
                List<Course> calculculatedCourses = new ArrayList<>();
                if (alumni.getCourseCatalog().getCourseList().contains(course) && !calculculatedCourses.contains(course)) {
//                    courseAlumniCount++;
                    calculculatedCourses.add(course);
                    course.setCourseRating(course.getCourseRating() + 1);
                    if (alumni.getSalary() > 0 && alumni.getSalary() <= 50000) {
                        course.setCourseRating(course.getCourseRating() + 0.3);
                    } else if (alumni.getSalary() > 50000 && alumni.getSalary() < 100000) {
                        course.setCourseRating(course.getCourseRating() + 0.6);
                    } else if (alumni.getSalary() > 100000) {
                        course.setCourseRating(course.getCourseRating() + 1);
                    } else {
                        course.setCourseRating(course.getCourseRating() + 0);
                    }
//                    break;
                }
            }
            for (Employer employer : employerList) {
                for (String inDemandCourseContent : employer.getEmploymentCourses()) {
                    List<String> calculculatedContent = new ArrayList<>();
                    if (course.getCourseContentList().contains(inDemandCourseContent) && !calculculatedContent.contains(inDemandCourseContent)) {
                        calculculatedContent.add(inDemandCourseContent);
                        course.setCourseRating(course.getCourseRating() + 1);
                        break;
                    }
                }
            }
            double calcCourseRating = (course.getCourseRating() * 100) / (employerList.size() + (alumniDirectory.getAlumniDir().size()) * 2);
            course.setRatingPercent(calcCourseRating);
        }
    }
    
    public double calculateDeptCoursesRating() {
        double courseRankingSum = 0;
        for (Course course : courseList.getCourseList()) {
            courseRankingSum = courseRankingSum + course.getRatingPercent();
        }
        return (courseRankingSum / courseList.getCourseList().size());
    }
    
    public double calculateDeptFacultyRating() {
        double facultyRatingSum = 0;
        for (Faculty faculty : facultydirectory.getFacultyList()) {
            facultyRatingSum = facultyRatingSum + faculty.getRating();
        }
        return (facultyRatingSum / facultydirectory.getFacultyList().size());
    }
    
    public double calculateDeptEmploymentRating() {
        double employmentRatingSum = 0;
        for (Alumni alumni : alumniDirectory.getAlumniDir()) {
            employmentRatingSum = employmentRatingSum + alumni.getEmploymentRatingPercent();
        }
        return (employmentRatingSum / alumniDirectory.getAlumniDir().size());
    }
    
    @Override
    public String toString() {
        return departmentName;
    }
    
}
