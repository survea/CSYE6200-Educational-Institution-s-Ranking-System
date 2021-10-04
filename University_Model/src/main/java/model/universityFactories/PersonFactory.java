/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.universityFactories;

import model.department.Department;
import model.person.Alumni;
import model.person.Faculty;
import model.person.Person;
import model.person.Student;

/**
 *
 * @author Diksha Godse
 */
public class PersonFactory {
      public static Person getPerson(PersonType type, Department dept) {

    switch (type) {
      case STUDENT:
        return new Student();
      case FACULTY:
        return new Faculty(dept);
        case ALUMNI:
        return new Alumni(dept);
      default:
        return null;
    }
  }
}
