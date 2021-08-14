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
 * @author Hp
 */
public class AlumniDirectory {
    private Department department;
    private List<Alumni> alumniDir;

    public List<Alumni> getAlumniDir() {
        return alumniDir;
    }

    public void setAlumniDir(List<Alumni> alumniDir) {
        this.alumniDir = alumniDir;
    }

    public AlumniDirectory(Department dept) {
        department = dept;
        alumniDir = new ArrayList<>();
    }

    public List<Alumni> addAlumni(Alumni alumni) {
        alumniDir.add(alumni);
        return alumniDir;
    }
}
