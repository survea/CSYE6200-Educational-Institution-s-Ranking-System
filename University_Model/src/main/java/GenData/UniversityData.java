package GenData;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class UniversityData {

    JSONObject universities;
    
    String[] universitiynames = {
            "NEU",
            "BOSTON Univ",
            "MIT"
    };
    
    
    
    String[] deptnames = {
            "Information Systems",
            "Computer Science",
            "Mathematics",
            "History",
            "Civil Engineering",
            "Electrical Engineering",
            "Social Science",
            "Health Informatics",
            "Nutrition"
    };
    
    String[] coursecodes = {
            "INFO5100",
            "DPG5461"
    };
    
    String[] coursenames = {
            "AED",
            "DataScience"
    };
    
    String[] coursekeywords = {
            "java,python,C++",
            "ML,Algorithms,python"
    };
    
    Integer[] courseranking = {
            1,
            2,3,4,5,6,7,8,9,10
    };
    
    int univCount;
    int maxCoursesPerDept;
    int maxStudentsPerDept;
    int maxFacultyPerDept;
    Faker faker;

    public UniversityData() {
        faker = new Faker(new Locale("en-US"));
        univCount = 3;
        maxCoursesPerDept = 20;
        maxStudentsPerDept = 100;
        maxFacultyPerDept = 20;
    }
    
    public JSONObject getUniversities() {
        JSONObject univs = new JSONObject();
        Random rand = new Random();
        String univnames = universitiynames[rand.nextInt(universitiynames.length)];
        return univs;
    }
    
    
    public JSONObject getCourses() {
        JSONObject courses = new JSONObject();
        Random rand = new Random();
        String coursecode = coursecodes[rand.nextInt(coursecodes.length)];
        String coursename = coursenames[rand.nextInt(coursenames.length)];
        String keywords = coursekeywords[rand.nextInt(coursekeywords.length)];
        Integer courseRanking = courseranking[rand.nextInt(courseranking.length)];
        return courses;
    }
    
    public JSONObject getDepartmnents() {
        JSONObject departments = new JSONObject();
        Random rand = new Random();
        String deptName = deptnames[rand.nextInt(deptnames.length)]; 
        return departments;
    }
    
    

    public JSONObject genTranscript() {
        JSONObject transcript = new JSONObject();
        transcript.put("GPA", faker.number().randomDouble(2, 0, 4));
        transcript.put("degree", faker.educator().course());
        transcript.put("courses taken", new JSONObject());
        return transcript;
    }

    public JSONArray genEmploymentHistory() {
        JSONArray employDetails = new JSONArray();
        for(int i = 0; i < faker.number().numberBetween(0, 4); i++) {
            JSONObject employmentDetail = new JSONObject();
            employmentDetail.put("Company", faker.company().name());
            employmentDetail.put("Industry", faker.company().industry());
            employmentDetail.put("Profession", faker.company().profession());
            employmentDetail.put("Job Field", faker.job().field());
            employmentDetail.put("Job Position", faker.job().position());
            employmentDetail.put("Key Skills", faker.job().keySkills());
            employmentDetail.put("Seniority", faker.job().seniority());
            employmentDetail.put("Job title", faker.job().title());
            employmentDetail.put("Website", faker.internet().url());
            employmentDetail.put("Email", faker.internet().emailAddress());
            employDetails.add(employmentDetail);
        }
        return employDetails;
    }

    public JSONObject genDepartmentData(String deptName) {
        JSONObject dept = new JSONObject();
        JSONObject courses = new JSONObject();
        JSONObject students = new JSONObject();
        JSONObject faculty = new JSONObject();
        Random rand = new Random();

        // Generate all courses offered by dept
        for (int i = 0; i < rand.nextInt(maxCoursesPerDept); i++) {
            JSONObject details = new JSONObject();
            String courseNum = deptName.substring(0, 4).toUpperCase(Locale.ROOT) + faker.number().randomNumber(4, true);
            String courseName = faker.job().field() + " " + faker.job().field();
            details.put("name", courseName);
            details.put("credits", faker.number().numberBetween(1, 5));
            courses.put(courseNum, details);
        }

        // Generate details of all students in dept
        for (int i = 0; i < rand.nextInt(maxStudentsPerDept); i++) {
            JSONObject student = new JSONObject();
            String fullName = faker.name().fullName();
            long studentID = faker.number().randomNumber(7, true);
            student.put("name", fullName);
            student.put("transcript", genTranscript());
            student.put("employment", genEmploymentHistory());
            students.put(studentID, student);
        }

        // Generate details of faculty in dept
        Object[] allCourseNames = courses.keySet().toArray();
        for (int i = 0; i < faker.number().numberBetween(2, maxFacultyPerDept); i++) {
            JSONObject prof = new JSONObject();
            long profID = faker.number().randomNumber(7, true);
            prof.put("name", faker.name().fullName());
            prof.put("courses", Arrays.stream(allCourseNames).filter(x -> faker.bool().bool()).toArray());
            faculty.put(profID, prof);
        }

        dept.put("courses", courses);
        dept.put("students", students);
        dept.put("faculty", faculty);
        return dept;
    }

    public JSONObject genDepartmentsData() {
        JSONObject departments = new JSONObject();
        Random rand = new Random();
        for (int i = 0; i < deptnames.length; i++) {
            String deptName = deptnames[rand.nextInt(deptnames.length)];
            if(departments.containsKey(deptName))
                continue;
            departments.put(deptName, genDepartmentData(deptName));
        }
        return departments;
    }

    public JSONObject generateUniversityData() {
        universities = new JSONObject();
        for (int i = 0; i < univCount; i++) {
            universities.put(faker.university().name(), genDepartmentsData());
        }
        return universities;
    }
}
