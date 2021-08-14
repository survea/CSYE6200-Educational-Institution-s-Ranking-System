/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp
 */
public class EmployerDirectory {
    public static List<Employer> employerList;

    public EmployerDirectory() {
        employerList = new ArrayList<Employer>();
    }

    public static List<Employer> addEmployer(Employer employer) {
        employerList.add(employer);
        return employerList;
    }
}
