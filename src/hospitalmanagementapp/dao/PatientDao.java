/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementapp.dao;

import hospitalmanagementapp.dbutil.DBConnection;
import hospitalmanagementapp.pojo.ApnPojo;
import hospitalmanagementapp.pojo.PatientPojo;
import java.sql.Connection;
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
public class PatientDao {
     public static boolean addPatient(PatientPojo p) throws SQLException//ADD FRAME.
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,p.getP_id());
         ps.setString(2,p.getF_name());
          ps.setString(3,p.getS_name());
           ps.setInt(4,p.getAge());
            ps.setString(5,p.getOpd());
             ps.setString(6,p.getGender());
              ps.setString(7,p.getM_status());
               ps.setDate(8,p.getDate());
                ps.setString(9,p.getAddress());
                 ps.setString(10,p.getCity());
                  ps.setString(11,p.getMno());
                   ps.setString(12,p.getDoctor_id());
               
        int result=ps.executeUpdate();
        return result==1; 
    }
       public static String getNewId() throws SQLException//F FRAME.
    {
        
        
        Statement st=DBConnection.getConnection().createStatement();
        
        ResultSet rs=st.executeQuery("select max(p_id) from patient");
        int id=1;
        
           if(rs.next())
           {
           String empid=rs.getString(1);
           int eno=Integer.parseInt(empid.substring(1));
           id=id+eno;
        
           String t="P"+id;
           return t;
           }
           else
           {
                return "P101";
           }
        
       }
        public static ArrayList<ApnPojo> getAllPatient() throws SQLException// FOR VIEW ALL EMPLOYEE FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select p_id,f_name,opd from patient");
        ArrayList <ApnPojo> apnlist=new ArrayList();
        while(rs.next())
        {
            ApnPojo e=new ApnPojo();
            e.setP_id(rs.getString(1));
            e.setF_name(rs.getString(2));
            e.setOpd(rs.getString(3));
            apnlist.add(e);
        }
        return apnlist;
    }
         public static ArrayList <PatientPojo> getAllViewPatient() throws SQLException//FOR VIEW patient FRAME
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select * from patient");
         ArrayList<PatientPojo>empList2 = new ArrayList();
         
         while (rs.next())
         {
             PatientPojo e = new PatientPojo();
            e.setP_id(rs.getString(1));
             e.setF_name(rs.getString(2));
             e.setS_name(rs.getString(3));
                  e.setAge(rs.getInt(4));
                       e.setOpd(rs.getString(5));
                            e.setGender(rs.getString(6));
                                      e.setM_status(rs.getString(7));
                                           e.setDate(rs.getDate(8));
                                                e.setAddress(rs.getString(9));
                                                     e.setCity(rs.getString(10));
                                                          e.setMno(rs.getString(11));
                                                               e.setDoctor_id(rs.getString(12));
                                                              
                                                               
          
             empList2.add(e);
         }
        
    
         return empList2;
    
    } 
          public static ArrayList<String> getAllPatientId() throws SQLException// FOR  Add Patient FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select p_id from patient ");
        ArrayList <String> pid=new ArrayList();
        while(rs.next())
        {
            pid.add(rs.getString(1));
        }
        return pid;
    
}
     public static boolean deletePatient(String id) throws SQLException//FOR REMOve Doctor FRAME.
    {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from patient where p_id=?");
       ps.setString(1,id);
       int result=ps.executeUpdate();
       return result==1;
       
    }
     public static boolean UpdatePatient(PatientPojo p) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="update patient set p_id=?,f_name=?,s_name=?,age=?,opd=?,gender=?,m_status=?,p_date=?,address=?,city=?,phone_no=?,doctor_id=? where p_id=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,p.getP_id());
        ps.setString(2,p.getF_name());
        ps.setString(3,p.getS_name());
        ps.setInt(4,p.getAge());
        ps.setString(5,p.getOpd());
        ps.setString(6,p.getGender());
        ps.setString(7,p.getM_status());
        ps.setDate(8,p.getDate());
        ps.setString(9,p.getAddress());
        ps.setString(10,p.getCity());
        ps.setString(11,p.getMno());
        ps.setString(12,p.getDoctor_id());
        ps.setString(13,p.getP_id());
        int result=ps.executeUpdate();
        if(result==1){
            System.out.println("Update called");
            return true;
        }
          //System.out.println("false returned");
        return false;
    }
     public static HashMap<String,PatientPojo> getPatientDetails() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from patient");
        HashMap<String,PatientPojo> hm=new HashMap();
        while(rs.next()){
            PatientPojo pp=new PatientPojo();
            pp.setP_id(rs.getString(1));
            pp.setF_name(rs.getString(2));
            pp.setS_name(rs.getString(3));
            pp.setAge(rs.getInt(4));
            pp.setOpd(rs.getString(5));
            pp.setGender(rs.getString(6));
            pp.setM_status(rs.getString(7));
            pp.setDate(rs.getDate(8));
            pp.setAddress(rs.getString(9));
            pp.setCity(rs.getString(10));
            pp.setMno(rs.getString(11));
            pp.setDoctor_id(rs.getString(12));
            hm.put(pp.getP_id(),pp);
        }
        return hm;
    }
    
}
