/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wikiwikiwiki;

/**
 *
 * @author Devil Scorpio
 */
public class History {
    public String HistoryID;
    public String PageID;
    public String OldData;
    public String NewData;
    public String UserID;
    public String EditDate;

    public String getEditDate() {
        return EditDate;
    }

    public void setEditDate(String EditDate) {
        this.EditDate = EditDate;
    }

    public String getHistoryID() {
        return HistoryID;
    }

    public void setHistoryID(String HistoryID) {
        this.HistoryID = HistoryID;
    }

    public String getNewData() {
        return NewData;
    }

    public void setNewData(String NewData) {
        this.NewData = NewData;
    }

    public String getOldData() {
        return OldData;
    }

    public void setOldData(String OldData) {
        this.OldData = OldData;
    }

    public String getPageID() {
        return PageID;
    }

    public void setPageID(String PageID) {
        this.PageID = PageID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    
    
}
