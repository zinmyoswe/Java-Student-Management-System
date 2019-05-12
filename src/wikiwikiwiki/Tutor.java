/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wikiwikiwiki;

/**
 *
 * @author dell
 */
public class Tutor extends User {
 public String TutorID;
 public String TutorName;
 public String password;
 public String Department;
 public String position;

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getTutorID() {
        return TutorID;
    }

    public void setTutorID(String TutorID) {
        this.TutorID = TutorID;
    }

    public String getTutorName() {
        return TutorName;
    }

    public void setTutorName(String TutorName) {
        this.TutorName = TutorName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
