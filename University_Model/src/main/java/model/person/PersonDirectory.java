/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp
 */
public class PersonDirectory {

    public static List<Person> personDir;

    public PersonDirectory() {
        personDir = new ArrayList<>();
    }

    public static List<Person> getPersonDir() {
        return personDir;
    }

    public static void setPersonDir(List<Person> personDir) {
        PersonDirectory.personDir = personDir;
    }

    public static List<Person> addPerson(Person person) {
        personDir.add(person);
        return personDir;
    }
;
}
