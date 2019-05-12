/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wikiwikiwiki;

/**
 *
 * @author admin
 */
public class UserPermission {
public static String UserID;
public static String PageID;

    public static String getPageID() {
        return PageID;
    }

    public static void setPageID(String PageID) {
        UserPermission.PageID = PageID;
    }

    public static String getUserID() {
        return UserID;
    }

    public static void setUserID(String UserID) {
        UserPermission.UserID = UserID;
    }


}
