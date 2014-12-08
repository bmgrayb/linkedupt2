/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.StudentModel;

/**
 *
 * @author brando
 */
public interface StudentDAO {
    public ArrayList<StudentModel> getAllStudents();
    public StudentModel getStudentByID(int id);
    public StudentModel getStudentByUsername(String un);
    public ArrayList<StudentModel> getStudentsWithGreaterGPA(double gpa);
    public ArrayList<StudentModel> getStudentsByYear(int year);
    
    //TODO: implement
    public ArrayList<StudentModel> getStudentsGPARange(double lower, double higher);
    public ArrayList<StudentModel> getStudentGPARangeAndYear(int year, double lower, double higher);
    
    public int updateStudent(StudentModel stu);
    public int addStudent(StudentModel stu);
}
