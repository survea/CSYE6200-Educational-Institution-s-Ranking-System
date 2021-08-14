/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.university;

import java.util.ArrayList;
import java.util.List;
import model.department.Department;

/**
 *
 * @author Hp
 */
public class University {

    private String universityName;
    private List<Department> departmentList;
    private double universityRating;

    public University() {
        departmentList = new ArrayList<>();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Department> addDepartment(Department department) {
        departmentList.add(department);
        return departmentList;
    }

    public double calculateUniCoursesRating() {
        double uniCourseRankingSum = 0;
        for (Department dept : departmentList) {
            uniCourseRankingSum = uniCourseRankingSum + dept.calculateDeptCoursesRating();
        }
        return (uniCourseRankingSum / departmentList.size());
    }

    public double getUniversityRating() {
        return universityRating;
    }

    public void setUniversityRating(double universityRating) {
        this.universityRating = universityRating;
    }
    
    public double calculateUniversityRating() {
        double totalCoursesRating = 0;
        double totalAlumniRating = 0;
        double totalFacultyRating = 0;
        
        for(Department dept : getDepartmentList()) {
            totalCoursesRating = totalCoursesRating + dept.calculateDeptCoursesRating();
            totalAlumniRating = totalAlumniRating + dept.calculateDeptEmploymentRating();
            totalFacultyRating = totalFacultyRating + dept.calculateDeptFacultyRating();
        }
        totalCoursesRating = totalCoursesRating/getDepartmentList().size();
        totalAlumniRating = totalAlumniRating/getDepartmentList().size();
        totalFacultyRating = totalFacultyRating/getDepartmentList().size();
        
        universityRating = (totalCoursesRating + totalAlumniRating + totalFacultyRating)/3;
        setUniversityRating(universityRating);
        return universityRating;
    }
    

    @Override
    public String toString() {
        return universityName; //To change body of generated methods, choose Tools | Templates.
    }

}
