/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementapp.dao;

import hospitalmanagementapp.dbutil.DBConnection;
import hospitalmanagementapp.pojo.EmpPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Himanshu raj
 */
public class EmpDao {
    public static String getNewId() throws SQLException//FOR ADD EMPLOYEE FRAME.
    {
        
        
        Statement st=DBConnection.getConnection().createStatement();
        
        ResultSet rs=st.executeQuery("select max(empid) from employees");
        int id=1;
        
           rs.next();
        
           String empid=rs.getString(1);
           int eno=Integer.parseInt(empid.substring(1));
           id=id+eno;
        
        String t="E"+id;
        return t;
        
    }
    public static boolean addEmp(EmpPojo e) throws SQLException//FOR ADD EMPLOYEE FRAME.
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1,e.getEmpid());
        ps.setString(2,e.getEmpname());
        ps.setString(3,e.getRole());
        ps.setDouble(4,e.getSal());
        int result=ps.executeUpdate();
        return result==1;
        
    }
    public static ArrayList<EmpPojo> getAllEmp() throws SQLException// FOR VIEW ALL EMPLOYEE FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select*from employees");
        ArrayList <EmpPojo> emplist=new ArrayList();
        while(rs.next())
        {
            EmpPojo e=new EmpPojo();
            e.setEmpid(rs.getString(1));
            e.setEmpname(rs.getString(2));
            e.setRole(rs.getString(3));
            e.setSal(rs.getDouble(4));
            emplist.add(e);
        }
        return emplist;
    }
    public static HashMap<String,String> getNonRegisteredReceptionistList() throws SQLException//FOR ADD RECEPTIONIST FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select empid,empname from employees where role='RECEPTIONIST' and empid not in (select empid from users where usertype='RECEPTIONIST')");
        
        HashMap<String,String> receptionist=new HashMap();
        
        while(rs.next())
        {
           String id=rs.getString(1);
           String name=rs.getString(2);
           receptionist.put(id,name);
            System.out.println(id+",,,,"+name);
        }
        return receptionist; 
    }
    public  static HashMap<String,EmpPojo> getEmpList() throws SQLException//FOR REMOVE EMPLOYEE FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select*from employees");
        HashMap<String,EmpPojo> emplist=new HashMap();
        while(rs.next())
        {
            EmpPojo e=new EmpPojo();
            e.setEmpid(rs.getString(1));
            e.setEmpname(rs.getString(2));
            e.setRole(rs.getString(3));
            e.setSal(rs.getDouble(4));
            String empid=rs.getString(1);
            emplist.put(empid,e);
        }
        return emplist;
    }
   public static boolean removeEmp(EmpPojo e) throws SQLException//FOR REMOVE EMPLOYEE FRAME.
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from employees where empid=?");
        ps.setString(1,e.getEmpid());
        
        int result=ps.executeUpdate();
        return result==1;
        
    }
   public static boolean updateEmp(EmpPojo e) throws SQLException
   {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("update  employees set empname=?,role=?,sal=? where empid=?");
        ps.setString(4,e.getEmpid());
        ps.setString(1,e.getEmpname());
        ps.setString(2,e.getRole());
        ps.setDouble(3,e.getSal());
        int result=ps.executeUpdate();
        return result==1;
   }
   public static HashMap<String,String> getNonRegisteredDoctorsList() throws SQLException//FOR ADD Doctors FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select empid,empname from employees where role='DOCTOR' and empid not in (select empid from users where usertype='DOCTOR')");
        
        HashMap<String,String> doctors=new HashMap();
        
        while(rs.next())
        {
            System.out.println(rs.getString(2));
           String id=rs.getString(1);
           String name=rs.getString(2);
           doctors.put(id,name);
            System.out.println(id+",,,,"+name);
        }
        return doctors; 
    }
}
