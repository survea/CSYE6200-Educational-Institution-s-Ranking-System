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
public class StudentDirectory {

    Department department;
    public List<Student> studentList;

//    public StudentDirectory() {
//        studentDir = new ArrayList<>();
//    }

    public StudentDirectory(Department d) {

        department = d;
        studentList = new ArrayList();

    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> addStudent(Student student) {
        studentList.add(student);
        return studentList;
    }
}
