/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.AppUserModel;

/**
 *
 * @author brando
 */
public interface AppUserDAO {
    //this method will return true if the username and password are correct
    public boolean validate(String username, String password);
    //this method will return 1 if the row is created sucessfully
    public int addUser(AppUserModel user);
    //this method will return the type of the user passed in
    public String getUserType(String username);
    public AppUserModel getUserByUsername(String un);
}
