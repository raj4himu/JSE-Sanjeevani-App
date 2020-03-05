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
public class EmpPojo {
    private String empid,empname,role;
    private double sal;

    @Override
    public String toString() {
        return "EmpPojo{" + "empid=" + empid + ", empname=" + empname + ", role=" + role + ", sal=" + sal + '}';
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
    
}
