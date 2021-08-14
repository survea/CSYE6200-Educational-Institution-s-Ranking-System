/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.department.Department;
import model.person.Alumni;

/**
 *
 * @author Hp
 */
public class UniversityDirectory {

    private static List<University> universityList;
    private static Map alumniGpaSalaryRelation;

    public UniversityDirectory() {
        universityList = new ArrayList<>();
    }

    public static List<University> getUniversityList() {
        return universityList;
    }

    public static void setUniversityList(List<University> universityList) {
        UniversityDirectory.universityList = universityList;
    }

    public static List<University> addUniversity(University university) {
        universityList.add(university);
        return universityList;
    }

    public static void sortUniversities(Comparator<University> c) {
        // TODO Auto-generated method stub
        Collections.sort(universityList, c);
        universityList.forEach(System.out::println);
    }

    public static Map calcAlumniGpaSuccessRelationship() {
        float lgls = 0;
        float lgas = 0;
        float lghs = 0;
        float hgls = 0;
        float hgas = 0;
        float hghs = 0;
        int alumnicount = 0;

        for (University university : universityList) {
            for (Department dept : university.getDepartmentList()) {
                for (Alumni alumni : dept.getAlumniDirectory().getAlumniDir()) {
                    if (alumni.getSalary() > 0 && alumni.getSalary() <= 50000) {
                        if (alumni.getGpa() < 3) {
                            lgls = lgls + 1;
                        } else {
                            hgls = hgls + 1;
                        }
                    } else if (alumni.getSalary() > 50000 && alumni.getSalary() < 100000) {
                        if (alumni.getGpa() < 3) {
                            lgas = lgas + 1;
                        } else {
                            hgas = hgas + 1;
                        }
                    } else if (alumni.getSalary() > 100000) {
                        if (alumni.getGpa() < 3) {
                            lghs = lghs + 1;
                        } else {
                            hghs = hghs + 1;
                        }
                    } else {
                        if (alumni.getGpa() < 3) {
                            lgls = lgls + 1;
                        } else {
                            hgls = hgls + 1;
                        }
                    }
                    alumnicount++;
                }
            }
        }
        alumniGpaSalaryRelation = new HashMap();
        alumniGpaSalaryRelation.put("lgls", (Math.round((lgls * 100) / alumnicount)));
        alumniGpaSalaryRelation.put("lgas", (Math.round((lgas * 100) / alumnicount)));
        alumniGpaSalaryRelation.put("lghs", (Math.round((lghs * 100) / alumnicount)));
        alumniGpaSalaryRelation.put("hgls", (Math.round((hgls * 100) / alumnicount)));
        alumniGpaSalaryRelation.put("hgas", (Math.round((hgas * 100) / alumnicount)));
        alumniGpaSalaryRelation.put("hghs", (Math.round((hghs * 100) / alumnicount)));
        return alumniGpaSalaryRelation;
    }
}
