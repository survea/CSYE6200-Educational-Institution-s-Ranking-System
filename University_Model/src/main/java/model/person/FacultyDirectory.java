/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;
import java.util.ArrayList;
import java.util.List;
import model.department.Department;

/**
 *
 * @author DikshaGodse
 */
public class FacultyDirectory {
    private Department department;
    private List<Faculty> facultyList;

    public FacultyDirectory(Department department) {
        this.department = department;
        this.facultyList = new ArrayList();
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }
    public void newFacultyProfile(Faculty newFaculty) {
        facultyList.add(newFaculty);
    }
}
