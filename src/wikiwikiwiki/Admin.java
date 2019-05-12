/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wikiwikiwiki;

/**
 *
 * @author dell
 */
public class Admin extends User{
    public String AdminID;
    public String AdminName;
    public String password;

    public String getAdminID() {
        return AdminID;
    }

    public void setAdminID(String AdminID) {
        this.AdminID = AdminID;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String AdminName) {
        this.AdminName = AdminName;
    }

}
