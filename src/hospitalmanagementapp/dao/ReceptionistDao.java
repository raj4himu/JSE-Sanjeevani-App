/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementapp.dao;

import hospitalmanagementapp.dbutil.DBConnection;

import hospitalmanagementapp.pojo.UserDetailsPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Himanshu raj
 */
public class ReceptionistDao {
    public static boolean addReceptionist(UserDetailsPojo user) throws SQLException//ADD RECEPTIONIST FRAME.
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getUsername());
        ps.setString(3,user.getEmpid());
        ps.setString(4,user.getPassword());
        ps.setString(5,user.getUsertype());
        int result=ps.executeUpdate();
        return result==1; 
    }
    public static ArrayList<UserDetailsPojo> getAllReceptionists() throws SQLException//VIEW RECEPTIONIST FRAME.
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select*from users where usertype='RECEPTIONIST'");
        ArrayList <UserDetailsPojo> receptionistlist=new ArrayList();
        while(rs.next())
        {
            UserDetailsPojo u=new UserDetailsPojo();
            u.setUserId(rs.getString(1));
            u.setUsername(rs.getString(2));
            u.setEmpid(rs.getString(3));
            u.setPassword(rs.getString(4));
           
            receptionistlist.add(u);
        }
        return receptionistlist;
    }
}
