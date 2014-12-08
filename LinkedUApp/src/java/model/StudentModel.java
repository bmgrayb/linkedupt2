/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chris
 */
public class StudentModel {
    private String username,password, email, firstName, lastName, highSchool, dashYear;
    private String essay, apCourse, universities, majors;
    private boolean isPaidService;
    private float gpa;
    private int studentID, ACT, SAT, PSAT, NMSQT, year;
    //Add in the picture as blob object.
  //  private String[] majors;
  //  private String[] universities;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the highSchool
     */
    /*
                            <f:selectItem itemValue="1" itemLabel="Bloomington High School" />
                            <f:selectItem itemValue="2" itemLabel="Calvary Baptist High School" />
                            <f:selectItem itemValue="3" itemLabel="Central Catholic High School" />
                            <f:selectItem itemValue="4" itemLabel="Normal Community High School" />
                            <f:selectItem itemValue="5" itemLabel="Normal Community West High School" />
                            <f:selectItem itemValue="6" itemLabel="University High School" />
    */
    public String getHighSchool() {

            if("1".equals(highSchool))
                return "Bloomington High School";
            else if("2".equals(highSchool))
                return "Calvary Baptist High School";
            else if("3".equals(highSchool))
                return "Central Catholic High School";
            else if("4".equals(highSchool))
                return "Normal Community High School";
            else if("5".equals(highSchool))
                return "Normal Community West High School";
            else 
                return "University High School";
    }

    /**
     * @param highSchool the highSchool to set
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
            /*if("1".equals(highSchool))
                dashYear = "Bloomington High School";
            else if("2".equals(highSchool))
                dashYear = "Calvary Baptist High School";
            else if("3".equals(highSchool))
                dashYear = "Central Catholic High School";
            else if("4".equals(highSchool))
                dashYear = "Normal Community High School";
            else if("5".equals(highSchool))
                dashYear = "Normal Community West High School";
            else 
                return "University High School";*/
    }

    /**
     * @return the essay
     */
    public String getEssay() {
        return essay;
    }

    /**
     * @param essay the essay to set
     */
    public void setEssay(String essay) {
        this.essay = essay;
    }

    /**
     * @return the apCourse
     */
    public String getApCourse() {
        return apCourse;
    }

    /**
     * @param apCourse the apCourse to set
     */
    public void setApCourse(String apCourse) {
        this.apCourse = apCourse;
    }

    /**
     * @return the universities
     */
    public String getUniversities() {
        return universities;
    }

    /**
     * @param universities the universities to set
     */
    public void setUniversities(String universities) {
        this.universities = universities;
    }

    /**
     * @return the majors
     */
    public String getMajors() {
        return majors;
    }

    /**
     * @param majors the majors to set
     */
    public void setMajors(String majors) {
        this.majors = majors;
    }

    /**
     * @return the isPaidService
     */
    public boolean getIsPaidService() {
        return isPaidService;
    }

    /**
     * @param isPaidService the isPaidService to set
     */
    public void setIsPaidService(boolean isPaidService) {
        this.isPaidService = isPaidService;
    }
    
    public void setIsPaidService(int x){
        if(x == 1)
            isPaidService = true;
        else isPaidService = false;
    }

    /**
     * @return the gpa
     */
    public float getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    } 

    /**
     * @return the ACT
     */
    public int getACT() {
        return ACT;
    }

    /**
     * @param ACT the ACT to set
     */
    public void setACT(int ACT) {
        this.ACT = ACT;
    }

    /**
     * @return the SAT
     */
    public int getSAT() {
        return SAT;
    }

    /**
     * @param SAT the SAT to set
     */
    public void setSAT(int SAT) {
        this.SAT = SAT;
    }

    /**
     * @return the PSAT
     */
    public int getPSAT() {
        return PSAT;
    }

    /**
     * @param PSAT the PSAT to set
     */
    public void setPSAT(int PSAT) {
        this.PSAT = PSAT;
    }

    /**
     * @return the NMSQT
     */
    public int getNMSQT() {
        return NMSQT;
    }

    /**
     * @param NMSQT the NMSQT to set
     */
    public void setNMSQT(int NMSQT) {
        this.NMSQT = NMSQT;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the year
     */
    public String getDashYear() {
        if(year == 1)
            return "Freshman";
        if(year == 2)
            return "Sophomore";
        if(year == 3)
            return "Junior";
        if(year == 4)
            return "Senior";
        else
            return "All the years";
    }
    
    public void setDashYear(String x){
        dashYear = x;
    }
    
    public int getYear(){
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
        if(year == 1)
            setDashYear("Freshman");
        if(year == 2)
            setDashYear("Sophomore");
        if(year == 3)
            setDashYear("Junior");
        if(year == 4)
            setDashYear("Senior");
        else
            setDashYear("All the years");
    }
}
