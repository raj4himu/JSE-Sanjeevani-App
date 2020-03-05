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
public class ApnPojo {
    private String p_id,f_name,opd;

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    @Override
    public String toString() {
        return "ApnPojo{" + "p_id=" + p_id + ", f_name=" + f_name + ", opd=" + opd + '}';
    }
    
    
}
