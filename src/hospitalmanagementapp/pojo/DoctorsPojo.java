/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementapp.pojo;

/**
 *
 * @author Himanshu raj
 */
public class DoctorsPojo {
    private String userid,doctorid,qualification,specialist;
    private char active;

    @Override
    public String toString() {
        return "DoctorsPojo{" + "userid=" + userid + ", doctorid=" + doctorid + ", qualification=" + qualification + ", specialist=" + specialist + ", active=" + active + '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }
    
    
}
