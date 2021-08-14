/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;

import model.course.CourseOffer;

/**
 *
 * @author Hp
 */
public class FacultyAssignment {

    CourseOffer courseoffer;
    Faculty facultyprofile;

    public FacultyAssignment(Faculty fp, CourseOffer co) {
        courseoffer = co;
        facultyprofile = fp;
    }

    public Faculty getFacultyProfile() {
        return facultyprofile;
    }
}
