/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppUserDAO;
import dao.AppUserDAOImpl;
import dao.MultimediaDAOImpl;
import dao.RecruiterDAO;
import dao.RecruiterDAOImpl;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import dao.UniversityDAO;
import dao.UniversityDAOImpl;
import java.util.ArrayList;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.AppUserModel;
import model.MultimediaModel;
import model.RecruiterModel;
import model.StudentModel;
import model.UniversityModel;

/**
 *
 * @author chris
 */
@ManagedBean
@SessionScoped
public class StudentController {
    private StudentModel theUserModel;
    private String response;
    private String url;
    private String youtube;
    private UniversityModel featured;
    private ArrayList<UniversityModel> all;
    int index;
    private String email;
    
    public StudentController(){
        theUserModel = new StudentModel();
        all = new UniversityDAOImpl().getShowcasedUniversities();
        url = null;
        index = 0;
    }

    public void setStudent(ActionEvent event){
        String un = (String)event.getComponent().getAttributes().get("username");
        theUserModel = new StudentDAOImpl().getStudentByUsername(un);
        //url = new MultimediaDAOImpl().getURLByID(stu.getStudentID()).getUrl();
    }
    
    /**
     * @return the theUserModel
     */
    public StudentModel getTheUserModel() {
        return theUserModel;
    }

    /**
     * @param theUserModel the theUserModel to set
     */
    public void setTheUserModel(StudentModel theUserModel) {
        this.theUserModel = theUserModel;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        String str = "";
        str += "Hello Student:\nUsername: " + theUserModel.getUsername();
        str += "\nName: "+theUserModel.getFirstName() + " " + theUserModel.getLastName();
        str += "\nEmail: "+theUserModel.getEmail() + "\nPassword: "+theUserModel.getPassword();
        str += "\nPaid Service: " + theUserModel.getIsPaidService();
        response = str;
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
    public String addStudent(){
        StudentDAO aStudentDAO = new StudentDAOImpl();
        int status = aStudentDAO.addStudent(theUserModel);
        AppUserDAO aUserDAO= new AppUserDAOImpl();
        AppUserModel tempModel=new AppUserModel();
        tempModel.setUsername(theUserModel.getUsername());
        tempModel.setPassword(theUserModel.getPassword());
/*<<<<<<< HEAD
        tempModel.setUserType("student");
        aUserDAO.addUser(tempModel);
        if (status == 1)
            return "dashboard.xhtml";
=======*/
        tempModel.setUserType("Student");
        int other = aUserDAO.addUser(tempModel);
        
        MultimediaModel mm = new MultimediaModel();
        mm.setUrl(getYoutube());
        mm.setStudentID(aStudentDAO.getStudentByUsername(theUserModel.getUsername()).getStudentID());
        int mult = new MultimediaDAOImpl().addMultimedia(mm);
        if (status == 1 && other == 1 && mult == 1){
            setTheUserModel(aStudentDAO.getStudentByUsername(theUserModel.getUsername()));
          return "dashboard.xhtml";  
        }
            
        else return "error.xhml";
    }//end create Student
    
    public String update(){
        StudentDAO stuDAO = new StudentDAOImpl();
        int status = stuDAO.updateStudent(theUserModel);
        if(status == 1)
            return "dashboard.xhtml";
        else return "error.xhtml";
    }
    
    public void requestInfoFromStudent(){
        StudentModel student; RecruiterModel rec;
        StudentDAO stuDAO = new StudentDAOImpl();
        student = stuDAO.getStudentByID(theUserModel.getStudentID());
        String stuEmail = student.getEmail();
        rec = new RecruiterDAOImpl().getRecruiterByID(100);
        //String recEmail = rec.getEmail();
        UniversityDAO uDAO = new UniversityDAOImpl();
        String recUniversity = uDAO.getUniversityByID(rec.getUniversityID()).getOfficalName();
        
        String mailStr = "Hello "+student.getFirstName()+" "+student.getLastName()+",\n\n";
        mailStr += "I am "+rec.getFirstName()+" "+rec.getLastName()+" from " + recUniversity+".\n";
        mailStr += "We would like to talk to you about to learn more about you.\n\n";
        mailStr += "Thanks,\n"+"   "+rec.getFirstName()+" "+rec.getLastName()+"\n";
        mailStr += "   "+recUniversity;
        
        String subject = student.getFirstName()+"! We would like to know more about you!";
        
        if(this.email == null)
            this.email = "test@test.com";
        
        sendEmail(mailStr,stuEmail,email,subject);
        
    }//end requestFromStudent
    
    public void requestInfoFromRecruiter(int recID){
        StudentModel stu = this.getTheUserModel();
        RecruiterDAO recDAO = new RecruiterDAOImpl();
        RecruiterModel rec = recDAO.getRecruiterByID(recID);
        UniversityDAO uDAO = new UniversityDAOImpl();
        String uniName = uDAO.getUniversityByID(rec.getUniversityID()).getOfficalName();
        
        
        String mailStr = "Hello "+rec.getFirstName()+" "+rec.getLastName()+",\n\n";
        mailStr += "My name is "+stu.getFirstName()+" "+stu.getLastName()+" and I am interested ";
        mailStr += "in getting more information about "+uniName+".\n\n";
        mailStr += "Thanks,\n"+"   "+stu.getFirstName()+" "+stu.getLastName();
        
        String subject = "I would like to know more about your university.";
        
        sendEmail(mailStr,rec.getEmail(),stu.getEmail(),subject);
    }
    
    private void sendEmail(String text, String toEmail, String fromEmail, String subject){        
         // Recipient's email ID needs to be mentioned.
       String to;
        if(toEmail == null)
            to = "bmgrayb@gmail.com";
        else
            to = toEmail;
        
        // Sender's email ID needs to be mentioned
        String from;
        if(fromEmail == null)
            from="bmgrayb@ilstu.edu";
        else
            from = fromEmail;

        // Assuming you are sending email from this host
        String host = "smtp.ilstu.edu";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.user", "yourID"); // if needed
        properties.setProperty("mail.password", "yourPassword"); // if needed

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Send the actual HTML message, as big as you like
            message.setContent(text,
                    "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
    }//end send mail

    /**
     * @return the url
     */
    public String getUrl() {
        if(url == null){
            url = new MultimediaDAOImpl().getURLByID(theUserModel.getStudentID()).getUrl();
        }
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the featured
     */
    public UniversityModel getFeatured() {
        //int index = (int)Math.random()*all.size();
        return all.get(index);
    }

    public void changeFeatured(){
        index = (index+1)%all.size();
    }
    
    /**
     * @param featured the featured to set
     */
    public void setFeatured(UniversityModel featured) {
        this.featured = featured;
    }

    /**
     * @return the youtube
     */
    public String getYoutube() {
        return youtube;
    }

    /**
     * @param youtube the youtube to set
     */
    public void setYoutube(String youtube) {
        this.youtube = youtube;
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
}//end class
