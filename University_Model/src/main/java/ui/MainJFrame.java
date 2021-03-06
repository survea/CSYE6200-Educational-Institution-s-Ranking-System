package ui;

import com.github.javafaker.Faker;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import model.course.Course;
import model.course.CourseCatalog;
import model.department.Department;
import model.employer.Employer;
import model.employer.EmployerDirectory;
import model.fileUtil.FileUtil;
import model.person.Alumni;
import model.person.AlumniDirectory;
import model.person.Faculty;
import model.person.Person;
import model.person.PersonDirectory;
import model.person.Student;
import model.person.StudentDirectory;
import model.person.alumniEmployment.EmploymentHistory;
import model.university.University;
import model.university.UniversityDirectory;
import model.universityFactories.PersonFactory;
import model.universityFactories.PersonType;

/**
 *
 * @author archil
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    EmployerDirectory empDir;
    CourseCatalog courseCatalog;
    StudentDirectory studDir;
    PersonDirectory personDir;
    AlumniDirectory alumniDirectory;
    UniversityDirectory univDir;
    final String COMMA_DELIMITER = ",";
    Random rand = new Random();
    int upperbound = 6;
    Faker faker = new Faker();
    String[] newStudents = {
        "1,47,Dan,Peters,3.75",
        "3,37,Allan,Simpson,3.85",
        "2,27,Don,Johnson,3.80"
    };
    String[] alumniStudents = {
        "4,47,Dan1,Peters,3.75,6000",
        "5,37,Allan1,Simpson,3.85,4900",
        "6,27,Don1,Johnson,3.80,11000"
    };
    String[] facultyData = {
        "7,47,Dan1,Peters,INFO5100,[1;3;5;2;4],6000",
        "8,37,Allan1,Simpson,INFO5001,[1;2;2;2;3],4900",
        "9,27,Don1,Johnson,CSYE6200,[1;2;3;2;4],11000"
    };
    String[] newCourseList = {
        "INFO5100,AED,info sys course,4,0",
        "INFO5001,User interface,info sys course,4,0",
        "CSYE6200,OOPs,computer science course,4,0",
        "INFO6150,Web Design,info sys course,4,0",
        "INFO6245,Planning and Managing Information Systems Development,info sys course,4,0",
        "INFO7250,Big-Data Systems,computer science course,4,0"
    };
    String[] employeeList = {
        "Amazon",
        "Flipkart",
        "Linkdln",
        "Walmart"
    };
    String[] empCourses = {
        "Java",
        "Angular",
        "HTML",
        "MongoDB",
        "React",
        "nodeJS",
        "Automation testing",
        "c#",
        "go lang"
    };
    String[] alumniJobPostions = {
        "Associate",
        "Senior",
        "Lead",
        "Manager",
        "Higher"
    };
    String[] departmentNames = {
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

    public MainJFrame() {
        initComponents();
        setSize(1000, 640);
        setResizable(false);

        empDir = new EmployerDirectory();
//        courseCatalog = new CourseCatalog();
        personDir = new PersonDirectory();
//        alumniDirectory = new AlumniDirectory();
        univDir = UniversityDirectory.getInstance();

        University northeastern = new University();
//        List<String> csvCourseList = new ArrayList<>(Arrays.asList(newCourseList));
//
//        // Write student CSV data to FileIODemo and read the file.
//        FileUtil.writeCsvFile(csvCourseList, "CSVCourseListFile");
        northeastern.setUniversityName("Northeastern University");
        University bostonUni = new University();
        bostonUni.setUniversityName("Boston University");
        UniversityDirectory.addUniversity(northeastern);
        UniversityDirectory.addUniversity(bostonUni);
        for (University uni : UniversityDirectory.getUniversityList()) {

            for (String department : departmentNames) {
                uni.addDepartment(new Department(department));
            }
            for (Department dept : uni.getDepartmentList()) {

                addDepartmentCourses(dept);
                addDepartmentStudents(dept, newStudents);
                addDepartmentFaculty(dept, facultyData);
                addDepartmentEmployers(dept, employeeList, empCourses);
                addDepartmentAlumni(dept, alumniStudents, alumniJobPostions);

            }
            calculateRating(uni);
            uni.calculateUniversityRating();

            PersonDirectory.getPersonDir().forEach(System.out::println);
            EmployerDirectory.employerList.forEach(System.out::println);
        }
        UniversityDirectory.sortUniversities(Comparator.comparing(University::getUniversityName));
        UniversityDirectory.getUniversityList().forEach(System.out::println);

        setLoginScreen();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWorkArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainWorkArea.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWorkArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWorkArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void demo() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainJFrame().setVisible(true);
        });
    }

    private void setLoginScreen() {

        LoginScreen loginScreen = new LoginScreen(mainWorkArea);
        mainWorkArea.add("LoginScreen", loginScreen);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);

    }

    private void addDepartmentCourses(Department infoSys) {
        
        List<String> courseDataRead = FileUtil.readCsvFile("CSVCourseListFile");
        courseDataRead.stream().map(csvCourse -> csvCourse.split(COMMA_DELIMITER)).map(tokens -> new Course(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]))).map(newCourse -> {
            for (int i = 0; i < 3; i++) {
                newCourse.addCourseContent(empCourses[rand.nextInt(empCourses.length)]);
            }
            return newCourse;
        }).forEachOrdered(newCourse -> {
            infoSys.addCourse(newCourse);
        });
    }

    private void addDepartmentStudents(Department dept, String[] newStudents) {
//        List<String> csvStudentList = new ArrayList<>(Arrays.asList(newStudents));
//        for (String student : csvStudentList) {
//            String[] tokens = student.split(COMMA_DELIMITER);
//            Student studentDetails = new Student(Double.parseDouble(tokens[4]), Integer.parseInt(tokens[0]), tokens[2], tokens[3], Integer.parseInt(tokens[1]));
//            for (int i = 0; i < 3; i++) {
//                studentDetails.addStudentCourse(dept.getCourseList().getCourseList().get(rand.nextInt(dept.getCourseList().getCourseList().size())));
//            }
//            dept.addStudent(studentDetails);
//            PersonDirectory.addPerson(studentDetails);
//        }

//            String[] tokens = student.split(COMMA_DELIMITER);
        for (int studCount = 0; studCount < 50; studCount++) {
            //        Student studentDetails = new Student(faker.number().randomDouble(2, 0, 4), faker.number().randomDigitNotZero(), faker.name().firstName(), faker.name().lastName(), faker.number().randomDigitNotZero());
//            Student studentDetails = new Student();
            Person studentDetails = PersonFactory.getPerson(PersonType.STUDENT, dept);
            studentDetails.setGpa(faker.number().randomDouble(2, 3, 4));
            studentDetails.setId(faker.number().randomDigitNotZero());
            studentDetails.setFirstName(faker.name().firstName());
            studentDetails.setLastName(faker.name().lastName());
            studentDetails.setAge(faker.number().randomDigitNotZero());
            for (int i = 0; i < 3; i++) {
                studentDetails.addNewCourse(dept.getCourseList().getCourseList().get(rand.nextInt(dept.getCourseList().getCourseList().size())));
            }
            dept.addStudent((Student) studentDetails);
            PersonDirectory.addPerson(studentDetails);
        }
    }

    private void addDepartmentFaculty(Department dept, String[] newFaculties) {
        for (int facultyCount = 0; facultyCount < 50; facultyCount++) {
//            Faculty facultyDetails = new Faculty(dept);
            Person facultyDetails = PersonFactory.getPerson(PersonType.FACULTY, dept);
            facultyDetails.setId(faker.number().randomDigitNotZero());
            facultyDetails.setFirstName(faker.name().firstName());
            facultyDetails.setLastName(faker.name().lastName());
            facultyDetails.setAge(faker.number().randomDigitNotZero());
            for (int i = 1; i <= 5; i++) {
                (facultyDetails).addNewRating(faker.number().numberBetween(2, 5));
            }
            for (int i = 0; i < 3; i++) {
                facultyDetails.addNewCourse(dept.getCourseList().getCourseList().get(rand.nextInt(dept.getCourseList().getCourseList().size())));
            }
            dept.addFaculty((Faculty) facultyDetails);
            PersonDirectory.addPerson(facultyDetails);
        }
//        List<String> csvFacultyList = new ArrayList<>(Arrays.asList(newFaculties));
//        for (String faculty : csvFacultyList) {
//            String[] tokens = faculty.split(COMMA_DELIMITER);
//            CourseCatalog facultyCourseCatalog = new CourseCatalog(dept);
//            for (int i = 0; i < 2; i++) {
//                facultyCourseCatalog.addCourse(dept.getCourseList().getCourseList().get(rand.nextInt(dept.getCourseList().getCourseList().size())));
//            }
//            List<Integer> ratingList = new ArrayList<Integer>();
//            for (int i = 0; i < 5; i++) {
//                ratingList.add(rand.nextInt(5));
//            }
//            /*String replace = tokens[5].replace("[", "");
//            String replace1 = replace.replace("]", "");
//            String[] ratingStringArray = replace1.split(";");
//            List<Integer> ratingList = new ArrayList<Integer>();
//            for (String fav : ratingStringArray) {
//                ratingList.add(Integer.parseInt(fav));
//            }*/
//            Faculty facultyDetails = new Faculty(facultyCourseCatalog, ratingList, Integer.parseInt(tokens[0]), tokens[2], tokens[3], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[6]));
//            dept.addFaculty(facultyDetails);
//            PersonDirectory.addPerson(facultyDetails);
//        }
    }

    private void addDepartmentEmployers(Department dept, String[] employerList, String[] emp1Courses) {
        /*for (String employer : employerList) {
            List<String> csvEmpCourses = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                csvEmpCourses.add(emp1Courses[rand.nextInt(emp1Courses.length)]);
            }
            dept.addEmployer(new Employer(employer, csvEmpCourses));
            EmployerDirectory.addEmployer(new Employer(employer, csvEmpCourses));
        }*/
        for (int i = 0; i < 30; i++) {
            List<String> csvEmpCourses = new ArrayList<>();
            for (int courseContent = 0; courseContent < 3; courseContent++) {
                csvEmpCourses.add(emp1Courses[rand.nextInt(emp1Courses.length)]);
            }
            Employer employer = new Employer();
            employer.setName(faker.company().name());
            employer.setEmploymentCourses(csvEmpCourses);
            dept.addEmployer(employer);
            EmployerDirectory.addEmployer(employer);
        }
    }

    private void addDepartmentAlumni(Department dept, String[] alumniStudents, String[] alumniJobPostions) {
        /*List<String> csvAlumniList = new ArrayList<>(Arrays.asList(alumniStudents));
        for (String student : csvAlumniList) {
            String[] tokens = student.split(COMMA_DELIMITER);
            CourseCatalog alumniCourseCatalog = new CourseCatalog(dept);
            for (int i = 0; i < 2; i++) {
                alumniCourseCatalog.addCourse(dept.getCourseList().getCourseList().get(rand.nextInt(dept.getCourseList().getCourseList().size())));
            }
            Alumni alumniDetails = new Alumni("Employee1", null, alumniCourseCatalog, Double.parseDouble(tokens[4]), Integer.parseInt(tokens[0]), tokens[2], tokens[3], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[5]), alumniJobPostions[0]);
            dept.addAlumni(alumniDetails);
            PersonDirectory.addPerson(alumniDetails);
        }*/
        for (int alumniCount = 0; alumniCount < 50; alumniCount++) {
            //        Student studentDetails = new Student(faker.number().randomDouble(2, 0, 4), faker.number().randomDigitNotZero(), faker.name().firstName(), faker.name().lastName(), faker.number().randomDigitNotZero());
            Alumni alumniDetails = new Alumni(dept);
//            Person alumniDetails = PersonFactory.getPerson(PersonType.ALUMNI, dept);
            alumniDetails.setGpa(faker.number().randomDouble(2, 2, 4));
            alumniDetails.setId(faker.number().randomDigitNotZero());
            alumniDetails.setFirstName(faker.name().firstName());
            alumniDetails.setLastName(faker.name().lastName());
            alumniDetails.setAge(faker.number().randomDigitNotZero());
            alumniDetails.setGraduationYear(faker.date().birthday(1, 5));

            for (int i = 0; i < 2; i++) {
                alumniDetails.addNewCourse(dept.getCourseList().getCourseList().get(rand.nextInt(dept.getCourseList().getCourseList().size())));
                EmploymentHistory empHistory = new EmploymentHistory();
                empHistory.setEmployerName(faker.company().name());
                empHistory.setJoiningDate(faker.date().birthday());
                empHistory.setResignationDate(faker.date().birthday());
                empHistory.setPostion(alumniJobPostions[rand.nextInt(alumniJobPostions.length)]);
                empHistory.setSalary(faker.number().randomDouble(2, 10000, 190000));

                alumniDetails.addEmploymentHistory(empHistory);
            }
            alumniDetails.setSalary(alumniDetails.getEmploymentHistory().get(alumniDetails.getEmploymentHistory().size() - 1).getSalary());
            alumniDetails.setJobPostion(alumniDetails.getEmploymentHistory().get(alumniDetails.getEmploymentHistory().size() - 1).getPostion());
            alumniDetails.setEmployer(alumniDetails.getEmploymentHistory().get(alumniDetails.getEmploymentHistory().size() - 1).getEmployerName());
            alumniDetails.calcEmploymentRating();
            dept.addAlumni((Alumni) alumniDetails);

            PersonDirectory.addPerson(alumniDetails);
        }
    }

    private void calculateRating(University university) {
        university.getDepartmentList().forEach(dept -> {
            dept.calculateCourseRatingPercent();
            dept.getCourseList().getCourseList().forEach(System.out::println);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainWorkArea;
    // End of variables declaration//GEN-END:variables

}
