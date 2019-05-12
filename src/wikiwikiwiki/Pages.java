/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wikiwikiwiki;

/**
 *
 * @author Min Thiha
 */
public class Pages extends User{
    public String PageID;
    public String PageTitle;
    public String Description;

    public String getPageID()
    {
        return PageID;
    }
    public void setPageID(String PageID)
    {
        this.PageID=PageID;
    }
    public String getPageTitle()
    {
       return PageTitle;
    }
    public void setPageTitle(String PageTitle)
    {
        this.PageTitle=PageTitle;
    }
    public String getDescription()
    {
        return Description;
    }
    public void setDescription(String Description)
    {
        this.Description=Description;
    }


}
