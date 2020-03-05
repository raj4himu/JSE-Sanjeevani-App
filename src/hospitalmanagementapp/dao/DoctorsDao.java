/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementapp.dao;

import hospitalmanagementapp.dbutil.DBConnection;
import hospitalmanagementapp.pojo.DoctorsPojo;
import hospitalmanagementapp.pojo.UserDetailsPojo;
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
public class DoctorsDao {
     public static ArrayList<String> getAllDoctorsId() throws SQLException// FOR  Add Patient FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select doctorid from doctors where active='Y'");
        ArrayList <String> docid=new ArrayList();
        while(rs.next())
        {
            docid.add(rs.getString(1));
        }
        return docid;
    
}
      public static boolean addDoctors(UserDetailsPojo u) throws SQLException//FOR Add Doctor FRAME.
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(3,u.getEmpid());
        ps.setString(2,u.getUsername());
        ps.setString(1,u.getUserId());
        ps.setString(4,u.getPassword());
        ps.setString(5,u.getUsertype());
        int result=ps.executeUpdate();
        return result==1;
        
    }
      public static boolean addDoctorTable(DoctorsPojo d) throws SQLException//FOR Add Doctor FRAME.
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into doctors values(?,?,?,?,'Y')");
        ps.setString(1,d.getUserid());
        ps.setString(2,d.getDoctorid());
        ps.setString(3,d.getQualification());
        ps.setString(4,d.getSpecialist());
        int result=ps.executeUpdate();
        return result==1;
        
    }
       public static String getNewDoctorId() throws SQLException//F FRAME.
    {
        
        
        Statement st=DBConnection.getConnection().createStatement();
        
        ResultSet rs=st.executeQuery("select max(doctorid) from doctors");
        int id=1;
        
           if(rs.next())
           {
           String empid=rs.getString(1);
           int eno=Integer.parseInt(empid.substring(1));
           id=id+eno;
        
           String t="D"+id;
           return t;
           }
           else
           {
                return "D101";
           }
}
        public static ArrayList<DoctorsPojo> getAllDoctors() throws SQLException//VIEW Doctors FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select*from doctors where active='Y'");
        ArrayList <DoctorsPojo> doctorlist=new ArrayList();
        while(rs.next())
        {
            DoctorsPojo d=new DoctorsPojo();
            d.setDoctorid(rs.getString(2));
            d.setUserid(rs.getString(1));
            d.setQualification(rs.getString(3));
            d.setSpecialist(rs.getString(4));
           
            doctorlist.add(d);
        }
        return doctorlist;
    }
         public static boolean deleteDoctor(String id) throws SQLException//FOR REMOve Doctor FRAME.
    {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("update doctors set active='N'  where doctorid=?");
       ps.setString(1,id);
       int result=ps.executeUpdate();
       return result==1;
       
    }
         public static HashMap<String,String> getDoctorList() throws SQLException//FOR UPDATE Doctors.
    {
       HashMap<String,String> doctorList=new HashMap();
       Statement st=DBConnection.getConnection().createStatement();
       ResultSet rs=st.executeQuery("select userid,username from users where usertype='DOCTOR'");
       while(rs.next())
       {
          doctorList.put(rs.getString(1),rs.getString(2));
           
       }
       System.out.println(doctorList.toString());
       return doctorList;
        
    }
    
}
