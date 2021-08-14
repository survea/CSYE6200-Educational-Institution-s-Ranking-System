/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

import java.util.ArrayList;
import model.person.Faculty;
import model.person.FacultyAssignment;

/**
 *
 * @author Hp
 */
public class CourseOffer {
    Course course;
    FacultyAssignment facultyAssignment;

    public CourseOffer(Course c) {
        course = c;
    }
    public void AssignAsTeacher(Faculty fp) {

        facultyAssignment = new FacultyAssignment(fp, this);
    }

    public Faculty getFacultyProfile() {
        return facultyAssignment.getFacultyProfile();
    }
}
