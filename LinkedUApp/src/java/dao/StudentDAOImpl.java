/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.RecruiterModel;
import model.StudentModel;

/**
 *
 * @author brando
 */
public class StudentDAOImpl implements StudentDAO{

    @Override
    public ArrayList<StudentModel> getAllStudents() {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student order by firstname";
        
        ArrayList<StudentModel> s = new ArrayList<StudentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float gpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                gpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                StudentModel temp = new StudentModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(gpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
                
                s.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return s;
        
    }

    @Override
    public StudentModel getStudentByID(int id) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student where studentid = " +id;
        
        StudentModel temp = new StudentModel();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float gpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                gpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(gpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return temp;
    
    }

    @Override
    public ArrayList<StudentModel> getStudentsWithGreaterGPA(double gpa) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student where gpa > " + gpa;
        
        ArrayList<StudentModel> s = new ArrayList<StudentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float newGpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                newGpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                StudentModel temp = new StudentModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(newGpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
                
                s.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return s;
        
    
    }

    @Override
    public int updateStudent(StudentModel stu){
        
         DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "update linkedu.Student "
            + "set firstname = '" + stu.getFirstName() + "', "
            + "lastname = '" + stu.getLastName() + "', "
            + "classyear =" + stu.getYear() + ", "
            + "highschool = '" + stu.getHighSchool() + "', "
            + "gpa = " + stu.getGpa() + ", "
            + "actscore = " + stu.getACT() + ", "
            + "satscore = " + stu.getSAT() + ", "
            + "psatscore = " + stu.getPSAT() +", "
            + "nmsqtscore = " + stu.getNMSQT() + ", "
            + "apcourse = '" + stu.getApCourse() + "', "
            + "essay = '" + stu.getEssay() + "', "
            + "universities = '" + stu.getUniversities() + "', "
            + "majors = '" + stu.getMajors() + "' "
            +"where username = '" + stu.getUsername() + "'";
            
            row = stmt.executeUpdate(insertString);
            System.out.println("Insert String: " + insertString);
            DBConn.close();
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return row;
        
    }
    
    @Override
    public int addStudent(StudentModel stu) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO linkedu.Student values('"
            + stu.getUsername()
            + "','" + stu.getPassword()
            + "',default"
            + ",'" + stu.getEmail()
            + "','" + stu.getFirstName()
            + "','" + stu.getLastName()
            + "'," + stu.getYear()
            + ",'" + stu.getHighSchool()
            + "'," + stu.getGpa()
            + "," + stu.getACT()
            + "," + stu.getSAT()
            + "," + stu.getPSAT()
            + "," + stu.getNMSQT()
            + ",'" + stu.getApCourse()
            + "','" + stu.getEssay()
            + "','" + stu.getUniversities()
            + "','" + stu.getMajors()
            + "'," + stu.getIsPaidService()
            +", null"
            +")";
            
            row = stmt.executeUpdate(insertString);
            System.out.println("Insert String: " + insertString);
            DBConn.close();
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return row;
    
    }

    @Override
    public StudentModel getStudentByUsername(String un) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student where username = '" +un + "'";
        
        StudentModel temp = new StudentModel();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float gpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                gpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(gpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return temp;
        
        
    }

    @Override
    public ArrayList<StudentModel> getStudentsByYear(int year) {
        
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student where classyear = " + year + " order by firstname";
        
        ArrayList<StudentModel> s = new ArrayList<StudentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float newGpa;
            int studentID, ACT, SAT, PSAT, NMSQT, classYear;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                classYear = rs.getInt("classyear");
                newGpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                StudentModel temp = new StudentModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(classYear);
                temp.setHighSchool(highSchool);
                temp.setGpa(newGpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
                
                s.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return s;
    
    }

    @Override
    public ArrayList<StudentModel> getStudentsGPARange(double lower, double higher) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student where gpa between " + lower + " and " + higher + " order by firstname";
        
        ArrayList<StudentModel> s = new ArrayList<StudentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float newGpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                newGpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                StudentModel temp = new StudentModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(newGpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
                
                s.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return s;
    
    }

    @Override
    public ArrayList<StudentModel> getStudentGPARangeAndYear(int inYear, double lower, double higher) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/bmgrayb_fall14_linkedu;create=true";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student where classyear = " + inYear + " and gpa between " + lower + " and " + higher + " order by firstname";
        
        ArrayList<StudentModel> s = new ArrayList<StudentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float newGpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                newGpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                StudentModel temp = new StudentModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(newGpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
                
                s.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return s;
    
    }
    
}
