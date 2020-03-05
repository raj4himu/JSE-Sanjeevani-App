/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementapp.dao;

import hospitalmanagementapp.dbutil.DBConnection;
import hospitalmanagementapp.pojo.EmpPojo;
import hospitalmanagementapp.pojo.UserPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Himanshu raj
 */
public class UserDao {
    public static String validateUser(UserPojo user) throws SQLException//FOR LOGIN FRAME.
    {// System.out.println(user);//for debugging error.(what data is going to dao from userpojo object).
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select username from users where userid=?and password=?and usertype=?");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        String username=null;
        if(rs.next())
        {
            username=rs.getString(1);
        }
        return username;
            
    }
    public static HashMap<String,String> getReceptionistList() throws SQLException//FOR UPDATE RECEPTIONIST.
    {
       HashMap<String,String> receptionistList=new HashMap();
       Statement st=DBConnection.getConnection().createStatement();
       ResultSet rs=st.executeQuery("select userid,username from users where usertype='RECEPTIONIST'");
       while(rs.next())
       {
           receptionistList.put(rs.getString(1),rs.getString(2));
           
       }
       return receptionistList;
    }
    
   public static boolean changePassword(String userid,String pwd) throws SQLException//FOR UPDATE RECEPTIONIST.
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update users set password=? where userid=?");
        ps.setString(1,pwd);
        ps.setString(2,userid);
        return (ps.executeUpdate()!=0);
        
    }
    public static boolean deleteReceptionist(String id) throws SQLException//FOR REMOVE RECEPTIONIST FRAME.
    {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from users where userid=?");
       ps.setString(1,id);
       int result=ps.executeUpdate();
       return result==1;
       
    }
    
}
