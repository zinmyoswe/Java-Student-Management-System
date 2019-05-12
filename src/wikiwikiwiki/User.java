/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wikiwikiwiki;

/**
 *
 * @author dell
 */
public class User {
    public String UserID;
    public String UserName;
    public String UserTypeID;
    public String Password;
   


   

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserTypeID() {
        return UserTypeID;
    }

    public void setUserTypeID(String UserTypeID) {
        this.UserTypeID = UserTypeID;
    }

}
